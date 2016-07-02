package gr.kokeroulis.androidforms2.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import gr.kokeroulis.androidforms2.adapters.NumberAdapter;
import gr.kokeroulis.androidforms2.base.number.IntegerFormElement;
import gr.kokeroulis.androidforms2.base.number.OnNumberValueChangedListener;

public class IntegerAdapter extends NumberAdapter<Integer, IntegerFormElement> {

    public IntegerAdapter(NumberViewHolderUiProvider viewHolderUiProvider, Context context, @Nullable OnNumberValueChangedListener<Integer, IntegerFormElement> listener) {
        super(viewHolderUiProvider, context, listener);
    }

    @Override
    public boolean isForViewType(@NonNull List<Object> items, int position) {
        return items.get(position) instanceof IntegerFormElement;
    }
}
