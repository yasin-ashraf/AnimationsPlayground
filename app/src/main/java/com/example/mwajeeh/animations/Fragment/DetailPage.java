package com.example.mwajeeh.animations.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mwajeeh.animations.Adapter.DetailItemAdapter;
import com.example.mwajeeh.animations.Item;
import com.example.mwajeeh.animations.R;

import java.util.ArrayList;

/**
 * Created by im_yasinashraf started on 3/2/19.
 */
public class DetailPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView list = (RecyclerView) view.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new DetailItemAdapter(new ArrayList<Item>() {  // double brace initialization of ArrayList, which is a huge overkill. making an anonymous inner class with an instance initializer.
                                                                        // A sub class is created here for each item added to list just to instantiate that item.
            {
                for (int i = 0; i < 30; i++) {
                    add(new Item("detail:" + i));
                }
            }
        }));
    }
}
