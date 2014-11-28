package com.idevmob.initproj.custom_widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.idevmob.initproj.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.title_with_subtitle)
public class TitleWithSubtitle  extends RelativeLayout {
    @ViewById
    protected TextView title, subtitle;

    public TitleWithSubtitle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTexts(String titleText, String subTitleText) {
        title.setText(titleText);
        subtitle.setText(subTitleText);
    }
}