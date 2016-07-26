package com.archer.gitdroid.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private ViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ViewPagerAdapter(getContext());
        indicator = new CircleIndicator(getContext());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(pagerColorListener);
        viewPager.addOnPageChangeListener(pagerPhoneListener);

    }

    private ViewPager.OnPageChangeListener pagerColorListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

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
