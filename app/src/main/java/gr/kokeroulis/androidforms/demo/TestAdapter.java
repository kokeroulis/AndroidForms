package gr.kokeroulis.androidforms.demo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms.base.BaseForm;
import gr.kokeroulis.androidforms.base.BaseFormLayout;
import gr.kokeroulis.androidforms.base.FormLayout;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private final List<BaseForm> mValues = new ArrayList<>();


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.holder_test, parent, false);
        FormLayout formLayout = (FormLayout) view;
        BaseForm baseForm = mValues.get(position);
        ViewGroup group = baseForm.viewGroup(parent.getContext());

        formLayout.addBaseForm((BaseFormLayout) group);
        return new ViewHolder(formLayout);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final BaseForm form = mValues.get(position);
        holder.formLayout.getBaseFormLayout().bindTo(form);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void setValues(@NonNull final List<BaseForm> values) {
        mValues.clear();
        mValues.addAll(values);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final FormLayout formLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            formLayout = (FormLayout) itemView.findViewById(R.id.formLayout);
        }
    }
}
