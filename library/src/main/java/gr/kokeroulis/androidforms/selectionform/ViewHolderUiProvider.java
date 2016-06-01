package gr.kokeroulis.androidforms.selectionform;


import android.support.annotation.NonNull;

public interface ViewHolderUiProvider {

    int getLayout();

    void showIcon(@NonNull final SelectionAdapter.ViewHolder holder);

    void hideIcon(@NonNull final SelectionAdapter.ViewHolder holder);
}
