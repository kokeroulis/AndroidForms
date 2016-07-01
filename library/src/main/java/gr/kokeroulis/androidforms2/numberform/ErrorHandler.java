package gr.kokeroulis.androidforms2.numberform;

import android.os.Parcel;
import android.os.Parcelable;

public class ErrorHandler implements Parcelable {
    public String throwableMessage;


    public ErrorHandler() {}

    protected ErrorHandler(Parcel in) {
        throwableMessage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(throwableMessage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ErrorHandler> CREATOR = new Creator<ErrorHandler>() {
        @Override
        public ErrorHandler createFromParcel(Parcel in) {
            return new ErrorHandler(in);
        }

        @Override
        public ErrorHandler[] newArray(int size) {
            return new ErrorHandler[size];
        }
    };
}
