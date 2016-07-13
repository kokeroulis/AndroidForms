package gr.kokeroulis.androidforms2.demo.viewHolderProviders;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import gr.kokeroulis.androidforms2.adapters.NumberAdapter;
import gr.kokeroulis.androidforms2.demo.R;

public class NumberVIewHolderProvider implements NumberAdapter.NumberViewHolderUiProvider {

    @Override
    public int getLayout() {
        return R.layout.number_form_layout;
    }

    public TextView getTextView(View itemView) {
        return (TextView) itemView.findViewById(R.id.android_forms_number_description);
    }

    public EditText getEditTextView(View itemView) {
        return (EditText) itemView.findViewById(R.id.android_forms_number_value);
    }
}
