package gr.kokeroulis.androidforms2.demo;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms2.adapters.HeaderAdapter;
import gr.kokeroulis.androidforms2.adapters.SelectionAdapter;
import gr.kokeroulis.androidforms2.base.number.FloatFormElement;
import gr.kokeroulis.androidforms2.base.number.IntegerFormElement;
import gr.kokeroulis.androidforms2.base.number.OnNumberValueChangedListener;
import gr.kokeroulis.androidforms2.demo.models.EnumHeaderElement;
import gr.kokeroulis.androidforms2.demo.models.EnumSelectionElement;
import gr.kokeroulis.androidforms2.demo.models.FloatFormModel;
import gr.kokeroulis.androidforms2.demo.models.IntegerFormModel;
import gr.kokeroulis.androidforms2.demo.viewHolderProviders.EnumViewHolderProvider;
import gr.kokeroulis.androidforms2.demo.viewHolderProviders.HeaderViewHolderProvider;
import gr.kokeroulis.androidforms2.demo.viewHolderProviders.NumberVIewHolderProvider;

public class MainActivity extends AppCompatActivity {
    private MainFormsAdapter adapter;
    private List<Object> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        objects = populateAdater();
        final AdapterDelegatesManager<List<Object>> delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new HeaderAdapter(new HeaderViewHolderProvider(), this));
        delegatesManager.addDelegate(new SelectionAdapter(new EnumViewHolderProvider(), this, listener));
        delegatesManager.addDelegate(new FloatAdapter(new NumberVIewHolderProvider(), this, numberListener));
        delegatesManager.addDelegate(new IntegerAdapter(new NumberVIewHolderProvider(), this, integerListener));
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

    private final OnNumberValueChangedListener<Float, FloatFormElement> numberListener = new OnNumberValueChangedListener<Float, FloatFormElement>() {
        @Override
        public void onValueChanged(Float value, FloatFormElement element) {
            Toast.makeText(MainActivity.this, "New Input for float " + value, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable error) {
            new AlertDialog.Builder(MainActivity.this)
                .setTitle("Invalid input")
                .setMessage(error.getMessage())
                .setPositiveButton("Ok", null)
                .show();
        }
    };

    private final OnNumberValueChangedListener<Integer, IntegerFormElement> integerListener = new OnNumberValueChangedListener<Integer, IntegerFormElement>() {
        @Override
        public void onValueChanged(Integer value, IntegerFormElement element) {
            Toast.makeText(MainActivity.this, "New Input for integer " + value, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(Throwable error) {
            new AlertDialog.Builder(MainActivity.this)
                .setTitle("Invalid input")
                .setMessage(error.getMessage())
                .setPositiveButton("Ok", null)
                .show();
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
        adapterItems.add(new FloatFormModel(1, null, "Demo float", 20f, 30f));
        adapterItems.add(new IntegerFormModel(2, null, "Demo INt", 30, 40));

        return adapterItems;
    }
}
