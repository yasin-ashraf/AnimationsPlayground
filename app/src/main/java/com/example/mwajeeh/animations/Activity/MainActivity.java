package com.example.mwajeeh.animations.Activity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mwajeeh.animations.Adapter.ListAdapter;
import com.example.mwajeeh.animations.BannerFragment;
import com.example.mwajeeh.animations.Categories;
import com.example.mwajeeh.animations.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridLayoutManager layoutManager;
    private RecyclerView list;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        pager = findViewById(R.id.pager);
        list = findViewById(R.id.list);

        setupViewPager();
        layoutManager = new GridLayoutManager(this, 3);
        list.setLayoutManager(layoutManager);
        list.setAdapter(new ListAdapter(Categories.getCategories(),MainActivity.this));
    }

    private void setupViewPager() {
        pager.setPageMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Bundle args = new Bundle();
                switch (position) {
                    case 0:
                        args.putInt("bg", R.drawable.bg_red);
                        args.putInt("position", position);
                        args.putBoolean("clickable", true);
                        break;
                    case 1:
                        args.putInt("bg", R.drawable.bg_blue);
                        args.putInt("position", position);
                        args.putBoolean("clickable", true);
                        break;
                    case 2:
                        args.putInt("bg", R.drawable.bg_yellow);
                        args.putInt("position", position);
                        args.putBoolean("clickable", true);
                        break;
                }
                return BannerFragment.instantiate(MainActivity.this, BannerFragment.class.getName(), args);
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    public void startCardExpandActivity(int position) {
        Intent intent = new Intent(MainActivity.this,CardExpandActivity.class);
        intent.putExtra("ClickedPosition",position);

        View sharedView = pager;
        String transitionName = getString(R.string.card_transition);

        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, sharedView, transitionName);
        startActivity(intent, transitionActivityOptions.toBundle());
    }
}
