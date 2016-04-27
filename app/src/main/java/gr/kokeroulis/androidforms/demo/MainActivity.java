package gr.kokeroulis.androidforms.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms.selectionform.SelectionForm;
import gr.kokeroulis.androidforms.selectionform.SelectionModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SelectionForm selectionForm = (SelectionForm) findViewById(R.id.selection_form);
        List<SelectionModel> selectionModelList = new ArrayList<>();
        selectionModelList.add(new TestSelectionModel("first row"));
        selectionModelList.add(new TestSelectionModel("second row"));
        selectionModelList.add(new TestSelectionModel("third row"));
        selectionModelList.add(new TestSelectionModel("fourth row"));

        selectionForm.setSelectionModels(selectionModelList);
    }
}
