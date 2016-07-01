package gr.kokeroulis.androidforms2.numberform;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import gr.kokeroulis.androidforms2.base.BaseForm;

public abstract class NumberFormModel extends BaseForm {
    public String description;
    public String value;
    public @Nullable ErrorHandler throwableError;

    public abstract int getInputType();

    public abstract Validator getValidator();

    public NumberFormModel() {}

    @Override
    public ViewGroup viewGroup(@NonNull Context context) {
        NumberForm numberForm = new NumberForm(context);
        numberForm.bindTo(this);
        return numberForm;
    }

    protected NumberFormModel(Parcel in) {
        description = in.readString();
        value = in.readString();
        throwableError = in.readParcelable(ErrorHandler.class.getClassLoader());
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeString(value);
        dest.writeParcelable(throwableError, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
