package com.example.mwajeeh.animations.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mwajeeh.animations.Categories;
import com.example.mwajeeh.animations.R;

import java.util.List;

/**
 * Created by im_yasinashraf started on 25/1/19.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<Categories.Category> categories;

    public ListAdapter(List<Categories.Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder listItemViewHolder, int i) {
        Categories.Category category = categories.get(i);
        listItemViewHolder.image.setImageResource(category.getImage());
        listItemViewHolder.title.setText(category.getTitle());
        listItemViewHolder.itemView.setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ListItemViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;

        ListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
        }
    }
}
