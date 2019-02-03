package com.example.mwajeeh.animations.CustomView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.LinearLayout;

/**
 * Created by im_yasinashraf started on 2/2/19.
 */
public class InsetLinearLayout extends LinearLayout {

    public InsetLinearLayout(Context context) {
        super(context);
    }

    public InsetLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InsetLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        int childCount = getChildCount();
        for (int index = 0; index < childCount; ++index) {
            if (index == 0) {
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
                layoutParams.topMargin += insets.getSystemWindowInsetTop();

                getChildAt(0).setLayoutParams(layoutParams);
            }else {
                getChildAt(index).dispatchApplyWindowInsets(insets);
            }
        }
        return insets;
    }
}
