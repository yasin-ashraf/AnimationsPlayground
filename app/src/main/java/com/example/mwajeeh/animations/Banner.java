package com.example.mwajeeh.animations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mwajeeh.animations.Activity.CardExpandActivity;

/**
 * Created by im_yasinashraf started on 23/1/19.
 */
public class Banner extends Fragment {

    private CardView card;
    private ImageView cardBg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_banner, container, false);
        card = view.findViewById(R.id.card);
        cardBg = view.findViewById(R.id.bg);
        cardBg.setBackgroundDrawable(ContextCompat.getDrawable(getContext(), getArguments().getInt("bg")));

        view.setOnClickListener(view1 -> {
            if(getArguments().getBoolean("clickable")){
                Intent intent = new Intent(getActivity(),CardExpandActivity.class);
                intent.putExtra("ClickedPosition",getArguments().getInt("position"));
                startActivity(intent);
            }
        });
        return view;
    }

}
