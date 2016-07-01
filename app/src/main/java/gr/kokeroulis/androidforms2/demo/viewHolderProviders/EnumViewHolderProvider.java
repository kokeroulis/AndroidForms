package gr.kokeroulis.androidforms2.demo.viewHolderProviders;

import android.support.annotation.NonNull;
import android.view.View;

import gr.kokeroulis.androidforms2.adapters.SelectionAdapter;
import gr.kokeroulis.androidforms2.adapters.ViewHolderUiProvider;
import gr.kokeroulis.androidforms2.demo.R;

public class EnumViewHolderProvider implements ViewHolderUiProvider {

    @Override
    public int getLayout() {
        return R.layout.holder_selection_form;
    }

    @Override
    public void showIcon(@NonNull SelectionAdapter.SelectionViewHolder holder) {
        holder.checked.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideIcon(@NonNull SelectionAdapter.SelectionViewHolder holder) {
        holder.checked.setVisibility(View.GONE);
    }

    @Override
    public int getBackgroundHeaderColor() {
        return 0;
    }

    @Override
    public int getTextHeaderColor() {
        return 0;
    }
}
