package gr.kokeroulis.androidforms.numberform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import gr.kokeroulis.androidforms.base.BaseForm;

public abstract class NumberFormModel extends BaseForm {
    public String description;
    public Object value;
    public @Nullable ErrorHandler throwableError;

    public abstract int getInputType();

    public abstract Validator getValidator();

    @Override
    public ViewGroup viewGroup(@NonNull Context context) {
        NumberForm numberForm = new NumberForm(context);
        numberForm.bindTo(this);
        return numberForm;
    }
}
