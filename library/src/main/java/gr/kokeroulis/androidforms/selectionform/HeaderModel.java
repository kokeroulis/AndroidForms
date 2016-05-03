package gr.kokeroulis.androidforms.selectionform;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;

public class HeaderModel implements Parcelable {

    public @ColorRes int backgroundColor;

    public @ColorRes int textColor;

    public @NonNull String title;

    public HeaderModel(int backgroundColor, int textColor, @NonNull String title) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.title = title;
    }

    protected HeaderModel(Parcel in) {
        backgroundColor = in.readInt();
        textColor = in.readInt();
        title = in.readString();
    }

    public static final Creator<HeaderModel> CREATOR = new Creator<HeaderModel>() {
        @Override
        public HeaderModel createFromParcel(Parcel in) {
            return new HeaderModel(in);
        }

        @Override
        public HeaderModel[] newArray(int size) {
            return new HeaderModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(backgroundColor);
        dest.writeInt(textColor);
        dest.writeString(title);
    }
}
