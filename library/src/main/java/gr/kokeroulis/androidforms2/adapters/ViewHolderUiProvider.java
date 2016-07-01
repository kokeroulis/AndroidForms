package gr.kokeroulis.androidforms2.adapters;


import android.os.Parcelable;
import android.support.annotation.NonNull;

import gr.kokeroulis.androidforms2.selectionform.SelectionAdapter;

public interface ViewHolderUiProvider {

    int getLayout();

    void showIcon(@NonNull final gr.kokeroulis.androidforms2.adapters.SelectionAdapter.SelectionViewHolder holder);

    void hideIcon(@NonNull final gr.kokeroulis.androidforms2.adapters.SelectionAdapter.SelectionViewHolder holder);

    int getBackgroundHeaderColor();

    int getTextHeaderColor();
}
