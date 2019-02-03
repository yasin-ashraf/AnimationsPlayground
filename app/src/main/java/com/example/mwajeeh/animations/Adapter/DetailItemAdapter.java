package com.example.mwajeeh.animations.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mwajeeh.animations.Item;
import com.example.mwajeeh.animations.R;

import java.util.List;

/**
 * Created by im_yasinashraf started on 3/2/19.
 */
public class DetailItemAdapter extends RecyclerView.Adapter<DetailItemAdapter.DetailsItemViewHolder> {

    private List<Item> items;

    public DetailItemAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public DetailsItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DetailsItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsItemViewHolder detailsItemViewHolder, int i) {
        detailsItemViewHolder.title.setText(items.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class DetailsItemViewHolder extends RecyclerView.ViewHolder{

        private TextView title;

        DetailsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
