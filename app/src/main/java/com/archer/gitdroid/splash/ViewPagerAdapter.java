package com.archer.gitdroid.splash;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.archer.gitdroid.splash.pager.Pager0;
import com.archer.gitdroid.splash.pager.Pager1;
import com.archer.gitdroid.splash.pager.Pager2;

/**
 * Author: qixuefeng on 2016/7/26 0026.
 * E-mail: 377289596@qq.com
 */
public class ViewPagerAdapter extends PagerAdapter {

    private View[] views = new View[3];

    public ViewPagerAdapter(Context context) {
        views[0] = new Pager0(context);
        views[1] = new Pager1(context);
        views[2] = new Pager2(context);
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views[position]);
        return views[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views[position]);
    }
}
