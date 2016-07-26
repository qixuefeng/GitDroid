package com.archer.gitdroid.splash.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.archer.gitdroid.R;

/**
 * Author: qixuefeng on 2016/7/26 0026.
 * E-mail: 377289596@qq.com
 */
public class Pager2 extends FrameLayout {

    public Pager2(Context context) {
        super(context);
        init(context);
    }

    public Pager2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Pager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.content_pager_2, this, true);
    }



}
