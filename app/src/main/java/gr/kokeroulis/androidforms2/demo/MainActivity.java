package gr.kokeroulis.androidforms2.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms2.adapters.HeaderAdapter;
import gr.kokeroulis.androidforms2.adapters.SelectionAdapter;
import gr.kokeroulis.androidforms2.base.SelectionElement;
import gr.kokeroulis.androidforms2.demo.models.EnumHeaderElement;
import gr.kokeroulis.androidforms2.demo.models.EnumSelectionElement;
import gr.kokeroulis.androidforms2.demo.viewHolderProviders.EnumViewHolderProvider;
import gr.kokeroulis.androidforms2.demo.viewHolderProviders.HeaderViewHolderProvider;

public class MainActivity extends AppCompatActivity {
    private MainFormsAdapter adapter;
    private List<Object> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FrameLayout formContainer = (FrameLayout) findViewById(R.id.formContainer);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        objects = populateAdater();
        final AdapterDelegatesManager<List<Object>> delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new HeaderAdapter(new HeaderViewHolderProvider(), this));
        delegatesManager.addDelegate(new SelectionAdapter(new EnumViewHolderProvider(), this, listener));

        adapter = new MainFormsAdapter(objects, delegatesManager);
        rv.setAdapter(adapter);
    }

    private final SelectionAdapter.OnItemSelectedListener<EnumSelectionElement> listener = new SelectionAdapter.OnItemSelectedListener<EnumSelectionElement>() {
        @Override
        public void onItemSelected(EnumSelectionElement item) {
            final int pos = objects.indexOf(item);
            objects.set(pos, item.withChecked(!item.isSelected()));
            adapter.notifyDataSetChanged();
        }
    };


    public List<Object> populateAdater() {
        List<Object> adapterItems = new ArrayList<>();
        adapterItems.add(new EnumHeaderElement(0, 1, "HEADER ROW 0", null));
        adapterItems.add(new EnumHeaderElement(0, 2, "HEADER ROW 1", null));
        adapterItems.add(new EnumSelectionElement(1, 0, "first Row", false));
        adapterItems.add(new EnumSelectionElement(2, 0, "second Row", false));
        adapterItems.add(new EnumSelectionElement(3, 0, "third Row", false));
        adapterItems.add(new EnumSelectionElement(4, 0, "fourth Row", false));


        return adapterItems;






        /*List<BaseForm> forms = new ArrayList<>();
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
        formModel.maxSelectionItemCount = 1;
        formModel.isExpanded = true;

        FloatFormModel numberFormModel = new FloatFormModel(20.5f, 40f);
        numberFormModel.description = "Test form";

        forms.add(formModel);
        forms.add(numberFormModel);
        adapter.setValues(forms);*/
    }
}
