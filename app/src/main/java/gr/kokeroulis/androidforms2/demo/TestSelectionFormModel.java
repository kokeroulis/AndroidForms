package gr.kokeroulis.androidforms2.demo;

import android.content.Context;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.ArrayList;

import gr.kokeroulis.androidforms2.selectionform.SelectionAdapter;
import gr.kokeroulis.androidforms2.selectionform.SelectionForm;
import gr.kokeroulis.androidforms2.selectionform.SelectionFormModel;
import gr.kokeroulis.androidforms2.selectionform.SelectionModel;

public class TestSelectionFormModel extends SelectionFormModel {
    public ArrayList<TestSelectionModel> items;
    public ArrayList<TestSelectionModel> currentItems;

    public TestSelectionFormModel() {}


    @Override
    public ViewGroup viewGroup(@NonNull Context context) {
        SelectionForm selectionForm = new TestSelectionForm(context);
        selectionForm.setOnSelectionAdapterMaxItemsSelected(new SelectionAdapter.SelectionAdapterMaxItemsSelected() {
            @Override
            public void onMaxItemsSelected(ArrayList<SelectionModel> selectedItems) {
                if (currentItems == null) {
                    currentItems = new ArrayList<>();
                }

                currentItems.clear();
                for (SelectionModel selectedItem : selectedItems) {
                    currentItems.add((TestSelectionModel) selectedItem);
                }
            }
        });

        return selectionForm;
    }

    protected TestSelectionFormModel(Parcel in) {
        items = in.createTypedArrayList(TestSelectionModel.CREATOR);
        currentItems = in.createTypedArrayList(TestSelectionModel.CREATOR);
    }

    public static final Creator<TestSelectionFormModel> CREATOR = new Creator<TestSelectionFormModel>() {
        @Override
        public TestSelectionFormModel createFromParcel(Parcel in) {
            return new TestSelectionFormModel(in);
        }

        @Override
        public TestSelectionFormModel[] newArray(int size) {
            return new TestSelectionFormModel[size];
        }
    };

    @Override
    public ArrayList<? extends SelectionModel> getItems() {
        return items;
    }

    @Override
    public ArrayList<? extends SelectionModel> getCurrentSelection() {
        return currentItems;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
        dest.writeTypedList(currentItems);
    }
}
