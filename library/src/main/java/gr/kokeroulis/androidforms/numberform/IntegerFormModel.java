package gr.kokeroulis.androidforms.numberform;


import android.os.Parcel;
import android.os.Parcelable;
import android.view.inputmethod.EditorInfo;

public class IntegerFormModel extends NumberFormModel implements Parcelable {

    public IntegerFormModel() {}

    protected IntegerFormModel(Parcel in) {
    }

    public static final Creator<IntegerFormModel> CREATOR = new Creator<IntegerFormModel>() {
        @Override
        public IntegerFormModel createFromParcel(Parcel in) {
            return new IntegerFormModel(in);
        }

        @Override
        public IntegerFormModel[] newArray(int size) {
            return new IntegerFormModel[size];
        }
    };

    @Override
    public int getInputType() {
        return EditorInfo.TYPE_CLASS_PHONE;
    }

    @Override
    public Validator getValidator() {
        return new IntegerValidator();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class IntegerValidator implements Validator<Integer> {

        @Override
        public Integer validate(Object value) throws Exception {
            return Integer.parseInt(value.toString());
        }
    }
}
