package gr.kokeroulis.androidforms.selectionform;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import java.util.List;

import gr.kokeroulis.androidforms.R;
import gr.kokeroulis.androidforms.base.BaseForm;
import gr.kokeroulis.androidforms.base.BaseFormLayout;


public class SelectionForm extends BaseFormLayout {
    private RecyclerView recyclerView;
    private SelectionAdapter selectionAdapter;
    private List<SelectionModel> selectionModels;
    private List<HeaderModel> headerModels;
    private SelectionAdapter.SelectionAdapterClickListener listener;
    private SelectionAdapter.SelectionAdapterMaxItemsSelected maxItemsSelectedListener;
    public int maxSelectionItemCount;
    public boolean isExpanded;

    public SelectionForm(Context context) {
        super(context);
    }

    public SelectionForm(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionForm(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void bindTo(BaseForm baseForm) {
        final SelectionFormModel formModel = (SelectionFormModel) baseForm;
        if (formModel.items != null && formModel.items.size() > 0) {
            setSelectionModels(formModel.items);
        }

        if (formModel.headers != null && formModel.headers.size() > 0) {
            setHeaderModels(formModel.headers);
        }

        setIsExpanded(formModel.isExpanded);
        setMaxSelectionItemCount(formModel.maxSelectionItemCount);
    }

    private void bindViews() {
        LayoutInflater.from(getContext())
            .inflate(R.layout.selection_form, this, true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        selectionAdapter = new SelectionAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(selectionAdapter);

        setIsExpanded(isExpanded);
        if (selectionModels != null) {
            setSelectionModels(selectionModels);
        }

        if (headerModels != null) {
            setHeaderModels(headerModels);
        }

        setOnSelectionAdapterClickListener(listener);
        setOnSelectionAdapterMaxItemsSelected(maxItemsSelectedListener);
        setMaxSelectionItemCount(maxSelectionItemCount);
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

    public void setOnSelectionAdapterClickListener(SelectionAdapter.SelectionAdapterClickListener listener) {
        if (selectionAdapter == null) {
            this.listener = listener;
        } else {
            selectionAdapter.setOnSelectionAdapterClickListener(listener);
        }
    }

    public void setOnSelectionAdapterMaxItemsSelected(SelectionAdapter.SelectionAdapterMaxItemsSelected maxItemsSelectedListener) {
        if (selectionAdapter == null) {
            this.maxItemsSelectedListener = maxItemsSelectedListener;
        } else {
            selectionAdapter.setOnSelectionAdapterMaxItemsSelected(maxItemsSelectedListener);
        }
    }

    public void setMaxSelectionItemCount(int count) {
        maxSelectionItemCount = count;

        if (selectionAdapter != null) {
            selectionAdapter.setMaxSelectionItemCount(count);
        }
    }

    public int getMaxSelectionItemCount() {
        if (selectionAdapter == null) {
            return maxSelectionItemCount;
        } else {
            return selectionAdapter.getMaxSelectionItemCount();
        }
    }

    public void setIsExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
        if (selectionAdapter != null) {
            selectionAdapter.setIsExpanded(isExpanded);
        }
    }

    public boolean getIsExpanded(boolean isExpanded) {
        return isExpanded;
    }

    public void updateExpansion() {
        if (selectionAdapter != null) {
            selectionAdapter.notifyDataSetChanged();
        }
    }
}
