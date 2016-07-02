package gr.kokeroulis.androidforms2.demo;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates2.AdapterDelegatesManager;

import java.util.List;


public class MainFormsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final AdapterDelegatesManager<List<Object>> delegatesManager;
    public final List<Object> items;

    public MainFormsAdapter(List<Object> items, AdapterDelegatesManager<List<Object>> delegatesManager) {
        this.delegatesManager = delegatesManager;
        this.items = items;
    }

    @Override public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
