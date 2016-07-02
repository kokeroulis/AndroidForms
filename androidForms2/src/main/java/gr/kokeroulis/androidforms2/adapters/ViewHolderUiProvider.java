package gr.kokeroulis.androidforms2.adapters;


import android.support.annotation.NonNull;

public interface ViewHolderUiProvider {

    int getLayout();

    void showIcon(@NonNull final SelectionAdapter.SelectionViewHolder holder);

    void hideIcon(@NonNull final SelectionAdapter.SelectionViewHolder holder);

    int getBackgroundHeaderColor();

    int getTextHeaderColor();
}
