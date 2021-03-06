package com.example.jingjing.blogv6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Blogfragment extends Fragment {
    @Nullable
    private android.support.design.widget.TabLayout mTabs;
    private ViewPager mViewPager;

    private RelativeLayout mTabd;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("jjjj", "onCreate called.");
        return inflater.inflate(R.layout.blog,null);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Here is where we can get the context.
        Log.e("jjjj", "onAttach called.");
        mTabd = new tabd(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.e("jjjj", "onViewCreated called.");


        super.onViewCreated(view, savedInstanceState);
        //Log.e("jjjj", String.valueOf(getView()));
        mTabs = (android.support.design.widget.TabLayout) getView().findViewById(R.id.toptab);
        mViewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
        mTabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }



    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Item " + (position + 1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object view = null;
            switch (position) {
                case 0:
                    //Log.e("jjjj", "0");
                    view = getLayoutInflater().inflate(R.layout.taba, container, false);
                    container.addView((View)view);
                    break;
                case 1:
                    //Log.e("jjjj", "1");
                    view = getLayoutInflater().inflate(R.layout.tabb, container, false);
                    container.addView((View)view);
                    break;
                case 2:
                    //Log.e("jjjj", "2");
                    view = getLayoutInflater().inflate(R.layout.tabc, container, false);
                    container.addView((View)view);
                    break;
                case 3:
                    Log.e("jjjj", "3");
                    view = mTabd;
                    container.addView(mTabd);
                    break;
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
