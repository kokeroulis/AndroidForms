package gr.kokeroulis.androidforms2.numberform;

import android.widget.EditText;
import android.widget.TextView;

public interface NumberFormDelegate {
    TextView getDescriptionView();

    EditText getEditView();
}
