package gr.kokeroulis.androidforms2.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import gr.kokeroulis.androidforms2.adapters.NumberAdapter;
import gr.kokeroulis.androidforms2.base.number.FloatFormElement;
import gr.kokeroulis.androidforms2.base.number.OnNumberValueChangedListener;

public class FloatAdapter extends NumberAdapter<Object, Float, FloatFormElement> {
    public FloatAdapter(NumberViewHolderUiProvider viewHolderUiProvider, Context context, @Nullable OnNumberValueChangedListener<Float, FloatFormElement> listener) {
        super(viewHolderUiProvider, context, listener);
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof FloatFormElement;
    }
}
