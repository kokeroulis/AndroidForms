package gr.kokeroulis.androidforms.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import gr.kokeroulis.androidforms.selectionform.SelectionForm;
import gr.kokeroulis.androidforms.selectionform.SimpleViewHolderUiProvider;

public class TestSelectionForm extends SelectionForm<SimpleViewHolderUiProvider> {

    public TestSelectionForm(Context context) {
        super(context);
    }

    public TestSelectionForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestSelectionForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @NonNull
    @Override
    protected SimpleViewHolderUiProvider createViewHolderUiProvider() {
        return new SimpleViewHolderUiProvider();
    }
}
