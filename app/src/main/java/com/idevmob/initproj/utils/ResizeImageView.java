package com.idevmob.initproj.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ResizeImageView extends ImageView {
    public int newWith;
    public int newHeight;

    public ResizeImageView(Context context) {
        super(context);
    }

    public ResizeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResizeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        newWith = widthMeasureSpec;
        newHeight = heightMeasureSpec;
        Drawable drawable = getDrawable();

        if(drawable != null) {
            int diw = drawable.getIntrinsicWidth();
            if (diw > 0) {
                newWith = MeasureSpec.getSize(widthMeasureSpec);
                newHeight = newWith * drawable.getIntrinsicHeight() / diw;
                setMeasuredDimension(newWith, newHeight);
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

}
