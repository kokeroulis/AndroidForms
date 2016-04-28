package gr.kokeroulis.androidforms.selectionform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.List;

import gr.kokeroulis.androidforms.R;


public class SelectionForm extends FrameLayout {
    private RecyclerView recyclerView;
    private SelectionAdapter selectionAdapter;
    private List<SelectionModel> selectionModels;
    private List<HeaderModel> headerModels;

    public SelectionForm(Context context) {
        super(context);
    }

    public SelectionForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void bindViews() {
        LayoutInflater.from(getContext())
            .inflate(R.layout.selection_form, this, true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        selectionAdapter = new SelectionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(selectionAdapter);
        if (selectionModels != null) {
            setSelectionModels(selectionModels);
        }

        if (headerModels != null) {
            setHeaderModels(headerModels);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bindViews();
    }

    public void setSelectionModels(@NonNull final List<SelectionModel> selectionModels) {
        if (selectionAdapter == null) {
            this.selectionModels = selectionModels;
        } else {
            selectionAdapter.setSelectionModels(selectionModels);
        }
    }

    public void setHeaderModels(@NonNull final List<HeaderModel> headerModels) {
        if (selectionAdapter == null) {
            this.headerModels = headerModels;
        } else {
            selectionAdapter.setHeaderModels(headerModels);
        }
    }
}
