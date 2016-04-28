package gr.kokeroulis.androidforms.numberform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import gr.kokeroulis.androidforms.base.BaseForm;

public class NumberFormModel extends BaseForm {
    public String description;
    public Object value;
    public int typeInput = EditorInfo.TYPE_CLASS_DATETIME;

    @Override
    public ViewGroup viewGroup(@NonNull Context context) {
        NumberForm numberForm = new NumberForm(context);
        numberForm.bindTo(this);
        return numberForm;
    }
}
