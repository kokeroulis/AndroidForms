package gr.kokeroulis.androidforms.selectionform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.ArrayList;

import gr.kokeroulis.androidforms.base.BaseForm;

public abstract class SelectionFormModel extends BaseForm {
    public ArrayList<HeaderModel> headers = new ArrayList<>();
    public int maxSelectionItemCount;
    public boolean isExpanded;

    public abstract ArrayList<? extends SelectionModel> getItems();

    public abstract ArrayList<? extends SelectionModel> getCurrentSelection();

    @Override
    public abstract ViewGroup viewGroup(@NonNull final Context context);
}
