package gr.kokeroulis.androidforms2.adapters;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
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
import gr.kokeroulis.androidforms2.base.HeaderElement;

public class HeaderAdapter<T> implements AdapterDelegate<List<T>> {
    protected final ViewHolderUiProvider viewHolderUiProvider;
    private final LayoutInflater inflater;

    public HeaderAdapter(ViewHolderUiProvider viewHolderUiProvider, Context context) {
        this.viewHolderUiProvider = viewHolderUiProvider;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public boolean isForViewType(@NonNull List<T> items, int position) {
        Object item = items.get(position);
        boolean ok = item instanceof HeaderElement;
        boolean ok2 = items.get(position) instanceof HeaderElement;
        return items.get(position) instanceof HeaderElement;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HeaderViewHolder(inflater.inflate(viewHolderUiProvider.getLayout(), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List<T> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        HeaderViewHolder vh = (HeaderViewHolder) holder;
        HeaderElement element = (HeaderElement) items.get(position);
        vh.headerTitle.setText(element.title());
        if (viewHolderUiProvider.getTextHeaderColor() > 0) {
            vh.headerTitle.setTextColor(vh.getColor(viewHolderUiProvider.getTextHeaderColor()));
        }

        if (viewHolderUiProvider.getBackgroundHeaderColor() > 0) {
            vh.background.setBackgroundColor(vh.getColor(viewHolderUiProvider.getBackgroundHeaderColor()));
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final TextView headerTitle;
        public final ImageView imageView;
        public final FrameLayout background;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerTitle = (TextView) itemView.findViewById(R.id.title);
            background = (FrameLayout) itemView.findViewById(R.id.background);
            imageView = null;
        }

        int getColor(@ColorRes int color) {
            return ContextCompat.getColor(itemView.getContext(), color);
        }
    }
}
