package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {
    private static int viewHolderCount;
    private int numbersItem;
    public NumbersAdapter(int numbersOfItem){
        numbersItem = numbersOfItem;
        viewHolderCount = 0;
    }

    @Override
    public NumberViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.viewHolderIndex.setText("View Holder Index " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( NumberViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return numbersItem;
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;
        TextView viewHolderIndex;

        public NumberViewHolder(View itemView){
            super(itemView);

            listItemNumberView = itemView.findViewById(R.id.rv_numbers);
            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);
        }

        void bind(int listIndex){
            listItemNumberView.setText(String.valueOf(listIndex));
        }

    }
}
