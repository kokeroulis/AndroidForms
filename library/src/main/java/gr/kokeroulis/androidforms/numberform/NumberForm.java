package gr.kokeroulis.androidforms.numberform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import gr.kokeroulis.androidforms.R;

public class NumberForm extends FrameLayout {
    private NumberFormDelegate numberFormDelegate;
    private NumberFormModel numberFormModel;

    public NumberForm(Context context) {
        super(context);
    }

    public NumberForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void bindViews() {
        LayoutInflater.from(getContext())
            .inflate(R.layout.number_form, this, true);

        setInputType(numberFormModel.getInputType());
        setDescription(numberFormModel.description);
        getNumberFormDelegate().getEditView().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                numberFormModel.value = s.toString();
                if (TextUtils.isEmpty(numberFormModel.value.toString())) {
                    return;
                }
                try {
                    numberFormModel.getValidator().validate(numberFormModel.value);
                } catch (Exception e) {
                    numberFormModel.value = null;
                    getNumberFormDelegate().getEditView().setText("");
                    handleInvalidInput(e);
                }
            }
        });
    }

    protected void handleInvalidInput(Throwable e) {
        new AlertDialog.Builder(getContext())
            .setTitle("Invalid Input")
            .setMessage(e.getMessage())
            .setCancelable(false)
            .setPositiveButton("Ok", null)
            .show();
    }

    public void bindTo(@NonNull final NumberFormModel numberFormModel) {
        this.numberFormModel = numberFormModel;
        setInputType(numberFormModel.getInputType());
        setDescription(numberFormModel.description);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bindViews();
    }

    protected NumberFormDelegate getNumberFormDelegate() {
        if (numberFormDelegate == null) {
            numberFormDelegate = new NumberFormDelegateImpl(this);
        }

        return numberFormDelegate;
    }

    public void setInputType(int type) {
        if (getNumberFormDelegate().getEditView() != null) {
            getNumberFormDelegate().getEditView().setInputType(numberFormModel.getInputType());
        }
    }

    public void setDescription(@NonNull final String description) {
        if (getNumberFormDelegate().getDescriptionView() != null) {
            getNumberFormDelegate().getDescriptionView().setText(description);
        } else {
            numberFormModel.description = description;
        }
    }

    public static class NumberFormDelegateImpl implements NumberFormDelegate {
        private final WeakReference<ViewGroup> parentViewGroup;

        public NumberFormDelegateImpl(ViewGroup viewGroup) {
            parentViewGroup = new WeakReference<>(viewGroup);
        }

        @Override
        public TextView getDescriptionView() {
            if (parentViewGroup.get() != null) {
                return (TextView) parentViewGroup.get().findViewById(R.id.description);
            }
            return null;
        }

        @Override
        public EditText getEditView() {
            if (parentViewGroup.get() != null) {
                return (EditText) parentViewGroup.get().findViewById(R.id.edit);
            }
            return null;
        }
    }
}
