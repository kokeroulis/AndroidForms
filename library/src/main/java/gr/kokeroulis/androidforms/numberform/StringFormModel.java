package gr.kokeroulis.androidforms.numberform;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;

public class StringFormModel extends NumberFormModel implements Parcelable {

    public @Nullable
    ErrorHandler throwableError;

    public StringFormModel() {}

    @Override
    public int getInputType() {
        return EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE;
    }

    @Override
    public Validator getValidator() {
        return new StringValidator();
    }

    protected StringFormModel(Parcel in) {
        throwableError = in.readParcelable(ErrorHandler.class.getClassLoader());
    }

    public static final Creator<StringFormModel> CREATOR = new Creator<StringFormModel>() {
        @Override
        public StringFormModel createFromParcel(Parcel in) {
            return new StringFormModel(in);
        }

        @Override
        public StringFormModel[] newArray(int size) {
            return new StringFormModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(throwableError, flags);
    }

    public static class StringValidator implements Validator<String> {

        public StringValidator() {}

        @Override
        public String validate(String value) throws Exception {
            if (TextUtils.isEmpty(value)) {
                throw new RuntimeException("Your must fill your value");
            } else {
                return value;
            }
        }
    }
}
