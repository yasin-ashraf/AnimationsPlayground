package com.example.mwajeeh.animations.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mwajeeh.animations.Activity.DetailActivity;
import com.example.mwajeeh.animations.Activity.MainActivity;
import com.example.mwajeeh.animations.Categories;
import com.example.mwajeeh.animations.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by im_yasinashraf started on 25/1/19.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder> {

    private List<Categories.Category> categories;
    private GridLayoutManager layoutManager;
    private Activity activity;
    private RecyclerView recyclerView;

    public ListAdapter(List<Categories.Category> categories,Activity activity) {
        this.categories = categories;
        this.activity = activity;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
        layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
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
            Intent intent = new Intent(view.getContext(), DetailActivity.class);
            intent.putExtra("position",i);
            //shared element transition
            List<Pair<View,String>> pairs = new ArrayList<>();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            for(int j = firstVisibleItemPosition; j < lastVisibleItemPosition; j++) {
                ListItemViewHolder listItemViewHolder1 = (ListItemViewHolder) recyclerView.findViewHolderForAdapterPosition(j);
                pairs.add(Pair.create(listItemViewHolder1.image,"tab_"+j));
            }
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity,pairs.toArray(new Pair[]{})).toBundle();
            view.getContext().startActivity(intent,bundle);

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
