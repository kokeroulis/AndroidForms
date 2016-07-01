package gr.kokeroulis.androidforms2.numberform;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;

public class IntegerFormModel extends NumberFormModel implements Parcelable {
    public int min;
    public int max;
    public @Nullable ErrorHandler throwableError;

    public IntegerFormModel(int min, int max) {
        this.min = min;
        this.max = max;
    }

    protected IntegerFormModel(Parcel in) {
        super(in);
        min = in.readInt();
        max = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(value);
        dest.writeParcelable(throwableError, flags);
        dest.writeInt(min);
        dest.writeInt(max);
    }

    @Override
    public int describeContents() {
        return 0;
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
        return new IntegerValidator(min, max);
    }

    public static class IntegerValidator implements Validator<Integer> {
        private int mix;
        private int max;

        public IntegerValidator(int mix, int max) {
            this.mix = mix;
            this.max = max;
        }

        @Override
        public Integer validate(String value) throws Exception {
            int currentValue = Integer.parseInt(value);
            if (value.length() > 1 && (currentValue <= mix || currentValue >= max)) {
                throw new RuntimeException("Your value is out of the expected limits");
            }
            return currentValue;
        }
    }
}
