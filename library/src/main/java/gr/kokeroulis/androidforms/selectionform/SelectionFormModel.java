package gr.kokeroulis.androidforms.selectionform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.ArrayList;

import gr.kokeroulis.androidforms.base.BaseForm;

public class SelectionFormModel extends BaseForm {
    public ArrayList<SelectionModel> items;
    public ArrayList<HeaderModel> headers;

    @Override
    public ViewGroup viewGroup(@NonNull final Context context) {
        SelectionForm formModel = new SelectionForm(context);
        formModel.setSelectionModels(items);
        if (headers != null) {
            formModel.setHeaderModels(headers);
        }
        return formModel;
    }

    public ViewGroup viewGroup(@NonNull final Context context,
                               SelectionAdapter.SelectionAdapterClickListener listener) {

        SelectionForm selectionForm = (SelectionForm) viewGroup(context);
        selectionForm.setOnSelectionAdapterClickListener(listener);
        return selectionForm;
    }
}
