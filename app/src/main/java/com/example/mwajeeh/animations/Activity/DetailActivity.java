package com.example.mwajeeh.animations.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.example.mwajeeh.animations.Adapter.IconAdapter;
import com.example.mwajeeh.animations.R;
import com.viewpagerindicator.PageIndicator;

public class DetailActivity extends AppCompatActivity {

    private PageIndicator indicator;
    private CoordinatorLayout coordinatorLayout;
    private Toolbar toolbar;
    private ViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
        applyWindowInsets();
        setupViewPager();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        pager = findViewById(R.id.pager);
        coordinatorLayout = findViewById(R.id.coordinator);
        indicator = findViewById(R.id.indicator);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void applyWindowInsets() {
        // Since recyclerview is a child of viewpager, window insets cannot applied directly on recycler view, hence remove insets from all view and apply it manually
        // manually on required children
        coordinatorLayout.setOnApplyWindowInsetsListener((view, windowInsets) -> {

            ViewGroup.MarginLayoutParams lpViewPager = (ViewGroup.MarginLayoutParams) pager.getLayoutParams();
            lpViewPager.bottomMargin += windowInsets.getSystemWindowInsetBottom();
            pager.setLayoutParams(lpViewPager);

            ViewGroup.MarginLayoutParams lpToolbar = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
            lpToolbar.topMargin += windowInsets.getSystemWindowInsetTop();
            lpToolbar.leftMargin += windowInsets.getSystemWindowInsetLeft();
            lpToolbar.rightMargin += windowInsets.getSystemWindowInsetRight();

            toolbar.setLayoutParams(lpToolbar);

            // clear this listener so insets aren't re-applied
            coordinatorLayout.setOnApplyWindowInsetsListener(null);
            return windowInsets.consumeSystemWindowInsets();
        });
    }

    private void setupViewPager() {
        pager.setAdapter(new IconAdapter(this, getSupportFragmentManager()));
        indicator.setViewPager(pager);
        pager.setCurrentItem(getIntent().getIntExtra("position", 0), false);
        supportPostponeEnterTransition();
        pager.post(this::supportStartPostponedEnterTransition);
    }
}
