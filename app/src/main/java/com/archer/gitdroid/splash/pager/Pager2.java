package com.archer.gitdroid.splash.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.archer.gitdroid.R;

import butterknife.Bind;

/**
 * Author: qixuefeng on 2016/7/26 0026.
 * E-mail: 377289596@qq.com
 */
public class Pager2 extends FrameLayout {

    @Bind(R.id.ivBubble1)
    ImageView ivBubble1;
    @Bind(R.id.ivBubble2)
    ImageView ivBubble2;
    @Bind(R.id.ivBubble3)
    ImageView ivBubble3;

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
