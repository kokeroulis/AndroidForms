package gr.kokeroulis.androidforms.numberform;

import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public interface NumberFormDelegate {
    TextView getDescriptionView();

    EditText getEditView();
}
