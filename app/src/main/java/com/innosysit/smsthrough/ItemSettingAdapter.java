package com.innosysit.smsthrough;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemSettingAdapter extends RecyclerView.Adapter<ItemSettingAdapter.ViewHolder> {

    private final List<ItemSettingData> mDataList;

    public interface ButtonClickListener {
        void onItemClicked(int position);
    }

    private ButtonClickListener mListener;

    public void setOnClickListener(ButtonClickListener listener) {
        mListener = listener;
    }

    public ItemSettingAdapter(List<ItemSettingData> dataList) {
        mDataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_setting_button, parent, false);
        ItemSettingAdapter.ViewHolder vh = new ItemSettingAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemSettingData item = mDataList.get(position);
        holder.selectButton.setText(item.getSelectButton());

        if(mListener != null) {
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView selectButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            selectButton = itemView.findViewById(R.id.selectButton);
        }
    }
}
