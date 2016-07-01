package gr.kokeroulis.androidforms2.adapters;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegate;

import java.util.List;

import gr.kokeroulis.androidforms2.R;
import gr.kokeroulis.androidforms2.base.SelectionElement;

public class SelectionAdapter implements AdapterDelegate<List<Object>> {
    protected final ViewHolderUiProvider viewHolderUiProvider;
    private final LayoutInflater inflater;
    @Nullable
    private final OnItemSelectedListener listener;

    public interface OnItemSelectedListener<T extends SelectionElement> {
        void onItemSelected(T item);
    }

    public SelectionAdapter(ViewHolderUiProvider viewHolderUiProvider, Context context,
                            @Nullable OnItemSelectedListener listener) {
        this.viewHolderUiProvider = viewHolderUiProvider;
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof SelectionElement;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SelectionViewHolder(inflater.inflate(viewHolderUiProvider.getLayout(), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<Object> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        SelectionViewHolder vh = (SelectionViewHolder) holder;
        final SelectionElement element = (SelectionElement) items.get(position);
        vh.title.setText(element.title());
        if (viewHolderUiProvider.getTextHeaderColor() > 0) {
            vh.title.setTextColor(vh.getColor(viewHolderUiProvider.getTextHeaderColor()));
        }

        if (viewHolderUiProvider.getBackgroundHeaderColor() > 0) {
            vh.background.setBackgroundColor(vh.getColor(viewHolderUiProvider.getBackgroundHeaderColor()));
        }

        if (element.isSelected()) {
            viewHolderUiProvider.showIcon(vh);
        } else {
            viewHolderUiProvider.hideIcon(vh);
        }
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemSelected(element);
                }
            }
        });
    }

    public static class SelectionViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout background;
        public final TextView title;
        public final ImageView checked;
        public SelectionViewHolder(View itemView) {
            super(itemView);
            background = (FrameLayout) itemView.findViewById(R.id.background);
            title = (TextView) itemView.findViewById(R.id.title);
            checked = (ImageView) itemView.findViewById(R.id.checked);
        }

        int getColor(@ColorRes int color) {
            return ContextCompat.getColor(itemView.getContext(), color);
        }
    }
}
