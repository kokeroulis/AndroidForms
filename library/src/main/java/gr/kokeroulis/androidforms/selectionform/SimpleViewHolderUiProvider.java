package gr.kokeroulis.androidforms.selectionform;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.view.View;

import gr.kokeroulis.androidforms.R;

public class SimpleViewHolderUiProvider implements ViewHolderUiProvider, Parcelable {

    public SimpleViewHolderUiProvider() {}

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    protected SimpleViewHolderUiProvider(Parcel in) {}

    public static final Creator<SimpleViewHolderUiProvider> CREATOR = new Creator<SimpleViewHolderUiProvider>() {
        @Override
        public SimpleViewHolderUiProvider createFromParcel(Parcel in) {
            return new SimpleViewHolderUiProvider(in);
        }

        @Override
        public SimpleViewHolderUiProvider[] newArray(int size) {
            return new SimpleViewHolderUiProvider[size];
        }
    };
}
