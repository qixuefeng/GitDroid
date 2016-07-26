package com.archer.gitdroid.splash;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.archer.gitdroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Author: qixuefeng on 2016/7/26 0026.
 * E-mail: 377289596@qq.com
 */
public class SplashFragment extends Fragment {

    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.layoutPhone)
    FrameLayout layoutPhone;
    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.ivPhoneFont)
    ImageView ivPhoneFont;

    private ViewPagerAdapter adapter;

    private int colorGreen;
    private int colorRed;
    private ArgbEvaluator argbEvaluator;

    private int widthScreen = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        widthScreen = wm.getDefaultDisplay().getWidth();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ViewPagerAdapter(getContext());
        indicator = new CircleIndicator(getContext());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        argbEvaluator = new ArgbEvaluator();

        colorGreen = getResources().getColor(R.color.colorGreen);
        colorRed = getResources().getColor(R.color.colorRed);

        viewPager.addOnPageChangeListener(pagerColorListener);
        viewPager.addOnPageChangeListener(pagerPhoneListener);

    }

    private ViewPager.OnPageChangeListener pagerColorListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            if (position == 0) {
                int color = (int) argbEvaluator.evaluate(positionOffset, colorGreen, colorRed);
                content.setBackgroundColor(color);
                ivPhoneFont.setAlpha(positionOffset);
            } else {
                content.setBackgroundColor(colorRed);
            }

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private ViewPager.OnPageChangeListener pagerPhoneListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            if (position == 0) {

                float scale = 0.3f + (positionOffset * 0.7f);
                layoutPhone.setScaleX(scale);
                layoutPhone.setScaleY(scale);

                float x = -360 + (360 * positionOffset);
                layoutPhone.setTranslationX(x);

            }

            if (position == 1) {
                layoutPhone.setTranslationX(widthScreen * -positionOffset);
            }


        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
