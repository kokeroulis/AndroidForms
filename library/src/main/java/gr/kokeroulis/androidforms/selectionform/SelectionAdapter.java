package gr.kokeroulis.androidforms.selectionform;

import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.kokeroulis.androidforms.R;


public class SelectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<HeaderModel> mHeaders = new ArrayList<>();
    private final List<SelectionModel> mValues = new ArrayList<>();
    public static final int HEADER_TYPE = 999;
    private SelectionAdapterClickListener mListener;
    private int maxSelectionItemCount;
    private SelectionAdapterMaxItemsSelected mMaxItemsListener;
    private final ArrayList<SelectionModel> selectedItemModes = new ArrayList<>();
    private boolean isExpanded;

    public interface SelectionAdapterClickListener {
        void onClick(SelectionModel model);
    }

    public interface SelectionAdapterMaxItemsSelected {
        void onMaxItemsSelected(ArrayList<SelectionModel> selectedItems);
    }

    public void setOnSelectionAdapterMaxItemsSelected(SelectionAdapterMaxItemsSelected listener) {
        mMaxItemsListener = listener;
    }


    public void setOnSelectionAdapterClickListener(SelectionAdapterClickListener listener) {
        mListener = listener;
    }


    public void setSelectionModels(@NonNull final List<SelectionModel> models) {
        mValues.clear();
        mValues.addAll(models);
        notifyDataSetChanged();
    }

    public void setHeaderModels(@NonNull final List<HeaderModel> headers) {
        mHeaders.clear();
        mHeaders.addAll(headers);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout mBackground;
        public final TextView mTitle;
        public final ImageView mChecked;

        public ViewHolder(View itemView) {
            super(itemView);
            mBackground = (FrameLayout) itemView.findViewById(R.id.background);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mChecked = (ImageView) itemView.findViewById(R.id.checked);
        }

        public void bindTo(SelectionModel selectionModel) {
            if (selectionModel.backgroundColor() > 0) {
                mBackground.setBackgroundColor(getColor(selectionModel.backgroundColor()));
            }

            if (selectionModel.textColor() > 0) {
                mTitle.setTextColor(getColor(selectionModel.textColor()));
            }
            mTitle.setText(selectionModel.title());
        }

        private int getColor(@ColorRes int color) {
            return ContextCompat.getColor(itemView.getContext(), color);
        }
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout mBackground;
        public final TextView mTitle;
        public HeaderViewHolder(View itemView) {
            super(itemView);

            mBackground = (FrameLayout) itemView.findViewById(R.id.background);
            mTitle = (TextView) itemView.findViewById(R.id.title);
        }

        public void bindTo(HeaderModel header) {
            if (header.backgroundColor > 0) {
                mBackground.setBackgroundColor(getColor(header.backgroundColor));
            }

            if (header.textColor > 0) {
                mTitle.setTextColor(getColor(header.textColor));
            }
            mTitle.setText(header.title);
        }

        private int getColor(@ColorRes int color) {
            return ContextCompat.getColor(itemView.getContext(), color);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaders.size() > 0
            && position < mHeaders.size()) {
            return HEADER_TYPE;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_TYPE) {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder_selection_form, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof HeaderViewHolder && mHeaders.size() > 0) {
            final HeaderModel header = mHeaders.get(position);
            HeaderViewHolder holder = (HeaderViewHolder) viewHolder;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isExpanded = !isExpanded;
                    notifyDataSetChanged();
                }
            });
            holder.bindTo(header);
        } else if (viewHolder instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) viewHolder;
            final SelectionModel selectionModel = mValues.get(findPosition(position));

            if (selectedItemModes.contains(selectionModel)) {
                holder.mChecked.setVisibility(View.VISIBLE);
            } else {
                holder.mChecked.setVisibility(View.GONE);
            }

            holder.bindTo(selectionModel);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedItemModes.size() >= maxSelectionItemCount) {
                        // our stack is finished. Remove the first item
                        SelectionModel toBeRemoved = selectedItemModes.get(0);
                        selectedItemModes.remove(toBeRemoved);
                    }

                    if (mListener != null) {
                        mListener.onClick(selectionModel);
                    }
                    handleItemSelection(selectionModel);
                    if (maxSelectionItemCount == selectedItemModes.size()
                        && mMaxItemsListener != null) {
                        mMaxItemsListener.onMaxItemsSelected(selectedItemModes);
                    }
                    notifyDataSetChanged();
                }
            });
        }
    }


    private void handleItemSelection(@NonNull final SelectionModel selectionModel) {
        if (selectedItemModes.contains(selectionModel)) {
            selectedItemModes.remove(selectionModel);
        } else {
            selectedItemModes.add(selectionModel);
        }
    }

    private int findPosition(int position) {
        if (mHeaders.size() > 0) {
            return position - mHeaders.size();
        }

        return position;
    }

    public void setMaxSelectionItemCount(int count) {
        maxSelectionItemCount = count;
    }

    public int getMaxSelectionItemCount() {
        return maxSelectionItemCount;
    }

    public void setIsExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public boolean getIsExpanded(boolean isExpanded) {
        return isExpanded;
    }

    @Override
    public int getItemCount() {
        if (!isExpanded) {
            return mHeaders.size();
        } else {
            return mHeaders.size() + mValues.size();
        }
    }
}
