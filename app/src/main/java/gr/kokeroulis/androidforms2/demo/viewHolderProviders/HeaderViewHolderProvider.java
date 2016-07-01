package gr.kokeroulis.androidforms2.demo.viewHolderProviders;

import android.support.annotation.NonNull;

import gr.kokeroulis.androidforms2.adapters.SelectionAdapter;
import gr.kokeroulis.androidforms2.adapters.ViewHolderUiProvider;
import gr.kokeroulis.androidforms2.demo.R;

public class HeaderViewHolderProvider implements ViewHolderUiProvider {
    @Override
    public int getLayout() {
        return R.layout.holder_header;
    }

    @Override
    public void showIcon(@NonNull SelectionAdapter.SelectionViewHolder holder) {

    }

    @Override
    public void hideIcon(@NonNull SelectionAdapter.SelectionViewHolder holder) {

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
