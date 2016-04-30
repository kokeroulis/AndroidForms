package gr.kokeroulis.androidforms.selectionform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.ArrayList;

import gr.kokeroulis.androidforms.base.BaseForm;

public class SelectionFormModel extends BaseForm {
    public ArrayList<SelectionModel> items;
    public ArrayList<HeaderModel> headers;
    public int maxSelectionItemCount;
    public boolean isExpanded;
    public ArrayList<SelectionModel> currentSelection;

    @Override
    public ViewGroup viewGroup(@NonNull final Context context) {
        SelectionForm formModel = new SelectionForm(context);

        formModel.setOnSelectionAdapterMaxItemsSelected(new SelectionAdapter.SelectionAdapterMaxItemsSelected() {
            @Override
            public void onMaxItemsSelected(ArrayList<SelectionModel> selectedItems) {
                currentSelection = selectedItems;
            }
        });
        return formModel;
    }
}
