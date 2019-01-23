package com.example.mwajeeh.animations.Activity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionListenerAdapter;
import android.util.TypedValue;

import com.example.mwajeeh.animations.BannerFragment;
import com.example.mwajeeh.animations.CustomView.ExpandableLayoutOg;
import com.example.mwajeeh.animations.R;

/**
 * Created by im_yasinashraf started on 23/1/19.
 */
public class CardExpandActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ExpandableLayoutOg expandableLayoutOg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_expand);
        initViews();
    }

    private void initViews() {
        viewPager = findViewById(R.id.pager);
        expandableLayoutOg = findViewById(R.id.expandable_layout);

        setupViewPager();
        viewPager.setCurrentItem(getIntent().getExtras().getInt("ClickedPosition"));

        Transition sharedElementEnterTransition = getWindow().getSharedElementEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            sharedElementEnterTransition.addListener(new TransitionListenerAdapter() {
                @Override
                public void onTransitionEnd(Transition transition) {
                    expandableLayoutOg.expand(true);
                    super.onTransitionEnd(transition);
                }
            });
        }else {
            expandableLayoutOg.expand(true);
        }

    }

    private void setupViewPager() {
        viewPager.setPageMargin((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics()));
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Bundle args = new Bundle();
                switch (position) {
                    case 0:
                        args.putInt("bg", R.drawable.bg_red);
                        args.putBoolean("clickable", false);
                        break;
                    case 1:
                        args.putInt("bg", R.drawable.bg_blue);
                        args.putBoolean("clickable", false);
                        break;
                    case 2:
                        args.putInt("bg", R.drawable.bg_yellow);
                        args.putBoolean("clickable", false);
                        break;
                }
                return BannerFragment.instantiate(CardExpandActivity.this, BannerFragment.class.getName(), args);
            }

            @Override
            public int getCount() {
                return 3;
            }

        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_SETTLING){
                    expandableLayoutOg.collapse(true);
                }else if(state == ViewPager.SCROLL_STATE_IDLE){
                    expandableLayoutOg.expand(true);
                }
            }
        });

        viewPager.setClickable(false);
    }

    public void collapseCard() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if(expandableLayoutOg.isExpanded()){
            expandableLayoutOg.setDuration(200);
            expandableLayoutOg.collapse(true);
            new Handler().postDelayed(() -> super.onBackPressed(),200);
        }

    }

}
