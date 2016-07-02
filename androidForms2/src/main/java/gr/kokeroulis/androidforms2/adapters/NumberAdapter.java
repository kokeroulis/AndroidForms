package gr.kokeroulis.androidforms2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegate;

import java.util.List;

import gr.kokeroulis.androidforms2.base.number.NumberFormElement;
import gr.kokeroulis.androidforms2.base.number.OnNumberValueChangedListener;
import gr.kokeroulis.androidforms2.base.number.validators.Validator;

public abstract class NumberAdapter<T, V extends NumberFormElement<T>> implements AdapterDelegate<List<Object>> {
    protected final NumberViewHolderUiProvider viewHolderUiProvider;
    private final LayoutInflater inflater;
    @Nullable
    private final OnNumberValueChangedListener<T, V> listener;

    public NumberAdapter(NumberViewHolderUiProvider viewHolderUiProvider, Context context,
                         @Nullable OnNumberValueChangedListener<T, V> listener) {
        this.viewHolderUiProvider = viewHolderUiProvider;
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public abstract boolean isForViewType(@NonNull List<Object> items, int position);

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new NumberViewHolder(
            inflater.inflate(viewHolderUiProvider.getLayout(), parent, false),
            viewHolderUiProvider
        );
    }

    @Override
    public void onBindViewHolder(@NonNull List<Object> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        NumberViewHolder vh = (NumberViewHolder) holder;
        final NumberFormElement<T> element = (NumberFormElement) items.get(position);
        vh.textView.setText(element.title());
        vh.editText.setInputType(element.getFormType());
        final Validator<T> validator = element.getValidator();
        vh.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s) && listener != null) {
                    listener.onError(new RuntimeException("Please fill the field"));
                } else {
                    try {
                        if (listener != null) {
                            listener.onValueChanged(validator.validate(s.toString()), (V) element);
                        }
                    } catch (Exception e) {
                        listener.onError(e);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    public static class NumberViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public final EditText editText;

        public NumberViewHolder(View itemView, NumberViewHolderUiProvider uiProvider) {
            super(itemView);
            textView = uiProvider.getTextView(itemView);
            editText = uiProvider.getEditTextView(itemView);
        }
    }

    public interface NumberViewHolderUiProvider {
        int getLayout();

        TextView getTextView(View itemView);

        EditText getEditTextView(View itemView);
    }
}