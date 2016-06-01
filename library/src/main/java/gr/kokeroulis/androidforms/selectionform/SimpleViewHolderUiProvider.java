package gr.kokeroulis.androidforms.selectionform;

import android.support.annotation.NonNull;
import android.view.View;

import gr.kokeroulis.androidforms.R;

public class SimpleViewHolderUiProvider implements ViewHolderUiProvider {
    @Override
    public int getLayout() {
        return R.layout.holder_selection_form;
    }

    @Override
    public void showIcon(@NonNull SelectionAdapter.ViewHolder holder) {
        holder.mChecked.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideIcon(@NonNull SelectionAdapter.ViewHolder holder) {
        holder.mChecked.setVisibility(View.GONE);
    }
}
