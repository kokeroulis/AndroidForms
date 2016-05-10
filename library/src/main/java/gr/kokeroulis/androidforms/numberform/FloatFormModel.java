package gr.kokeroulis.androidforms.numberform;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;

public class FloatFormModel extends NumberFormModel implements Parcelable {
    public float min;
    public float max;
    public @Nullable
    ErrorHandler throwableError;

    public FloatFormModel(float min, float max) {
        this.min = min;
        this.max = max;
    }

    protected FloatFormModel(Parcel in) {
        super(in);
        min = in.readInt();
        max = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(value);
        dest.writeParcelable(throwableError, flags);
        dest.writeFloat(min);
        dest.writeFloat(max);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<FloatFormModel> CREATOR = new Parcelable.Creator<FloatFormModel>() {
        @Override
        public FloatFormModel createFromParcel(Parcel in) {
            return new FloatFormModel(in);
        }

        @Override
        public FloatFormModel[] newArray(int size) {
            return new FloatFormModel[size];
        }
    };

    @Override
    public int getInputType() {
        return EditorInfo.TYPE_CLASS_PHONE;
    }

    @Override
    public Validator getValidator() {
        return new FloatValidator(min, max);
    }

    public static class FloatValidator implements Validator<Float> {
        private float mix;
        private float max;

        public FloatValidator(float mix, float max) {
            this.mix = mix;
            this.max = max;
        }

        @Override
        public Float validate(String value) throws Exception {
            float currentValue = Float.parseFloat(value);
            if (value.length() > 2 && !value.endsWith(".") && (currentValue < mix || currentValue > max)) {
                throw new RuntimeException("Your value is out of the expected limits");
            }
            return currentValue;
        }
    }
}


