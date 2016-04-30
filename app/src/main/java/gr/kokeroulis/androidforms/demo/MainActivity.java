package gr.kokeroulis.androidforms.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms.base.BaseForm;
import gr.kokeroulis.androidforms.numberform.IntegerFormModel;
import gr.kokeroulis.androidforms.selectionform.HeaderModel;

public class MainActivity extends AppCompatActivity {
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FrameLayout formContainer = (FrameLayout) findViewById(R.id.formContainer);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TestAdapter();
        rv.setAdapter(adapter);

        if (savedInstanceState == null) {
            populateAdater();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("adapter_items",adapter.getValues());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (adapter == null) {
            adapter = new TestAdapter();
        }

        adapter.setValues(savedInstanceState.<BaseForm>getParcelableArrayList("adapter_items"));
    }

    public void populateAdater() {
        List<BaseForm> forms = new ArrayList<>();
        ArrayList<TestSelectionModel> selectionModelList = new ArrayList<>();
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


        TestSelectionFormModel formModel = new TestSelectionFormModel();

        formModel.items =  selectionModelList;
        formModel.headers = (ArrayList<HeaderModel>) headers;
        formModel.maxSelectionItemCount = 2;
        formModel.isExpanded = true;

        IntegerFormModel numberFormModel = new IntegerFormModel();
        numberFormModel.description = "Test form";

        forms.add(formModel);
        forms.add(numberFormModel);
        adapter.setValues(forms);
    }
}
