package gr.kokeroulis.androidforms.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms.base.BaseForm;
import gr.kokeroulis.androidforms.numberform.IntegerFormModel;
import gr.kokeroulis.androidforms.selectionform.HeaderModel;
import gr.kokeroulis.androidforms.selectionform.SelectionAdapter;
import gr.kokeroulis.androidforms.selectionform.SelectionFormModel;
import gr.kokeroulis.androidforms.selectionform.SelectionModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FrameLayout formContainer = (FrameLayout) findViewById(R.id.formContainer);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        TestAdapter testAdapter = new TestAdapter();
        rv.setAdapter(testAdapter);
        populateAdater(testAdapter);


        //formContainer.addView(formModel.viewGroup(this, listener, maxItemsSelected));



    }

    public void populateAdater(TestAdapter testAdapter) {
        List<BaseForm> forms = new ArrayList<>();
        List<SelectionModel> selectionModelList = new ArrayList<>();
        selectionModelList.add(new TestSelectionModel("first row"));
        selectionModelList.add(new TestSelectionModel("second row"));
        selectionModelList.add(new TestSelectionModel("third row"));
        selectionModelList.add(new TestSelectionModel("fourth row"));

        HeaderModel first = new HeaderModel(0, 0, "First Header");
        HeaderModel second = new HeaderModel(0, 0, "Second Header");
        HeaderModel third = new HeaderModel(0, 0, "Third Header");

        List<HeaderModel> headers = new ArrayList<>();
        headers.add(first);
        headers.add(second);
        headers.add(third);


        SelectionFormModel formModel = new SelectionFormModel();
        SelectionAdapter.SelectionAdapterClickListener listener = new SelectionAdapter.SelectionAdapterClickListener() {
            @Override
            public void onClick(SelectionModel model) {
                Toast.makeText(MainActivity.this, "You have clicked " + model.title(), Toast.LENGTH_SHORT).show();
            }
        };

        SelectionAdapter.SelectionAdapterMaxItemsSelected maxItemsSelected = new SelectionAdapter.SelectionAdapterMaxItemsSelected() {
            @Override
            public void onMaxItemsSelected(ArrayList<SelectionModel> selectedItems) {
                String stringHolder = "  ";

                for (SelectionModel item : selectedItems) {
                    stringHolder += item.title();
                }

                Toast.makeText(MainActivity.this, "You have selected " + stringHolder, Toast.LENGTH_SHORT).show();
            }
        };


        formModel.items = (ArrayList<SelectionModel>) selectionModelList;
        formModel.headers = (ArrayList<HeaderModel>) headers;
        formModel.maxSelectionItemCount = 2;

        IntegerFormModel numberFormModel = new IntegerFormModel();
        numberFormModel.description = "Test form";

        forms.add(formModel);
        forms.add(numberFormModel);
        testAdapter.setValues(forms);
    }
}
