package com.example.mwajeeh.animations.CustomView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by im_yasinashraf started on 23/1/19.
 */
public class ExpandableLayout extends FrameLayout {

    public ExpandableLayout(@NonNull Context context) {
        super(context);
    }

    public ExpandableLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
