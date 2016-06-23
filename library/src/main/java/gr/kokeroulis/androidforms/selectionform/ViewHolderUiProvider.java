package gr.kokeroulis.androidforms.selectionform;


import android.os.Parcelable;
import android.support.annotation.NonNull;

public interface ViewHolderUiProvider extends Parcelable {

    int getLayout();

    void showIcon(@NonNull final SelectionAdapter.ViewHolder holder);

    void hideIcon(@NonNull final SelectionAdapter.ViewHolder holder);

    int getBackgroundHeaderColor();

    int getTextHeaderColor();
}
