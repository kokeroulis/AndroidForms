package gr.kokeroulis.androidforms.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms.selectionform.SelectionAdapter;
import gr.kokeroulis.androidforms.selectionform.SelectionFormModel;
import gr.kokeroulis.androidforms.selectionform.SelectionModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout formContainer = (FrameLayout) findViewById(R.id.formContainer);

        List<SelectionModel> selectionModelList = new ArrayList<>();
        selectionModelList.add(new TestSelectionModel("first row"));
        selectionModelList.add(new TestSelectionModel("second row"));
        selectionModelList.add(new TestSelectionModel("third row"));
        selectionModelList.add(new TestSelectionModel("fourth row"));


        SelectionFormModel formModel = new SelectionFormModel();
        SelectionAdapter.SelectionAdapterClickListener listener = new SelectionAdapter.SelectionAdapterClickListener() {
            @Override
            public void onClick(SelectionModel model) {
                Toast.makeText(MainActivity.this, "You have clicked " + model.title(), Toast.LENGTH_SHORT).show();
            }
        };


        formModel.items = (ArrayList<SelectionModel>) selectionModelList;
        formContainer.addView(formModel.viewGroup(this, listener));
    }
}
