package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.NumberViewHolder> {

    private List<BeerList> beers;


    public NumbersAdapter(List<BeerList> beers){
        this.beers = beers;
    }



    @Override
    public NumberViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_list, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder( NumberViewHolder holder, int position) {
        holder.tv_id.setText(beers.get(position).getId());
        holder.tv_name.setText(beers.get(position).getName());
        holder.tv_volume.setText(beers.get(position).getMethod());


    }

    @Override
    public int getItemCount() {
        return beers.size();
    }

    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name, tv_volume;

        public NumberViewHolder(View itemView){
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_volume = itemView.findViewById(R.id.tv_volume);
        }
    }
}
