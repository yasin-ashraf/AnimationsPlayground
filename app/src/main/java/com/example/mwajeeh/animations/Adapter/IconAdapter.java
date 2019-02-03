package com.example.mwajeeh.animations.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mwajeeh.animations.Categories;
import com.example.mwajeeh.animations.Fragment.DetailPage;
import com.viewpagerindicator.IconPagerAdapter;

/**
 * Created by im_yasinashraf started on 3/2/19.
 */
public class IconAdapter extends FragmentPagerAdapter implements IconPagerAdapter {

    private Context context;

    public IconAdapter(Context context, FragmentManager manager) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        return DetailPage.instantiate(context,DetailPage.class.getName());
    }

    @Override
    public int getIconResId(int index) {
        return Categories.getCategories().get(index).image;
    }

    @Override
    public int getCount() {
        return Categories.getCategories().size();
    }
}
