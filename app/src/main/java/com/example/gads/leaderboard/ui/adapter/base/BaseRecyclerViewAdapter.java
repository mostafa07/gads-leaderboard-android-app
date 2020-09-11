package com.example.gads.leaderboard.ui.adapter.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T>
        extends RecyclerView.Adapter<BaseRecyclerViewAdapter<T>.BaseViewHolder> {

    private static final String LOG_TAG = BaseRecyclerViewAdapter.class.getSimpleName();
    public static final int ZERO_POSITION = 0;

    private List<T> mDataList;
    private OnItemClickListener<T> mOnItemClickListener;

    // Constructors

    public BaseRecyclerViewAdapter() {
        mDataList = new ArrayList<>();
    }

    public BaseRecyclerViewAdapter(final OnItemClickListener<T> onItemClickListener) {
        mDataList = new ArrayList<>();
        mOnItemClickListener = onItemClickListener;
    }

    public BaseRecyclerViewAdapter(final OnItemClickListener<T> onItemClickListener, final List<T> dataList) {
        mDataList = new ArrayList<>(dataList);
        mOnItemClickListener = onItemClickListener;
    }


    // Recycler View Adapter Overridden Methods

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new BaseViewHolder(viewDataBinding, getViewBindingVariableId());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList != null ? mDataList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        final int itemLayoutId = getItemLayoutId();
        return itemLayoutId != 0 ? itemLayoutId : super.getItemViewType(position);
    }


    // Abstract methods to be overridden by inheriting children classes

    @LayoutRes
    protected abstract int getItemLayoutId();

    protected abstract int getViewBindingVariableId();


    // Getters and Setters

    public List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(final List<T> dataList) {
        mDataList = dataList;
        notifyDataSetChanged();
    }


    // Other Helper Methods

    public T getItemAtPosition(final int position) {
        if (mDataList != null && position >= ZERO_POSITION && position < mDataList.size()) {
            return mDataList.get(position);
        }
        return null;
    }

    public void addItem(final T item) {
        if (mDataList != null) {
            mDataList.add(ZERO_POSITION, item);
            notifyItemInserted(ZERO_POSITION);
        }
    }

    public void addItemList(final List<T> itemList) {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        mDataList.addAll(itemList);
        final int itemListSize = itemList.size();
        notifyItemRangeInserted(mDataList.size() - itemListSize, itemListSize);
    }

    public void updateItemAtPosition(final T item, final int position) {
        if (mDataList != null && position >= ZERO_POSITION && position < mDataList.size()) {
            mDataList.set(position, item);
            notifyItemChanged(position);
        }
    }

    public void removeItemAtPosition(final int position) {
        if (mDataList != null && position >= ZERO_POSITION && position < mDataList.size()) {
            mDataList.remove(position);
            notifyItemRemoved(position);
        }
    }


    // Base View Holder Class
    public class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ViewDataBinding mViewDataBinding;
        private int mViewBindingVariableId;

        public BaseViewHolder(final ViewDataBinding viewDataBinding, final int viewBindingVariableId) {
            super(viewDataBinding.getRoot());
            mViewDataBinding = viewDataBinding;
            mViewBindingVariableId = viewBindingVariableId;
            mViewDataBinding.getRoot().setOnClickListener(BaseViewHolder.this);
        }

        public void bind(final T item) {
            mViewDataBinding.setVariable(mViewBindingVariableId, item);
            mViewDataBinding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            mOnItemClickListener.onItemClick(mDataList.get(getAdapterPosition()));
        }
    }


    // On Item Click Listener Interface
    public interface OnItemClickListener<T> {

        void onItemClick(final T dataItem);
    }
}