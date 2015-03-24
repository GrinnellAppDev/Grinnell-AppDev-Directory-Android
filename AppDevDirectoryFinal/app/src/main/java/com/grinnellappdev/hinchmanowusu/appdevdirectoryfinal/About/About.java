package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.About;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.R;

import java.util.Locale;

public class About extends Fragment {

    public static final String TAG = Fragment.class.getSimpleName();
    AboutPagerAdapter mAboutPagerAdapter;
    ViewPager mViewPager;

    public static Fragment newInstance() {
        return new Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about, container, false);
        mAboutPagerAdapter = new AboutPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mAboutPagerAdapter);

        return v;
    }// onCreateView(LayoutInflater, ViewGroup, Bundle)

    public class AboutPagerAdapter extends FragmentPagerAdapter {

        public AboutPagerAdapter(FragmentManager fm) {
            super(fm);
        } // AboutPagerAdapter(FragmentManager)

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new AboutContentFragment();
            Bundle args = new Bundle();
            args.putInt(AboutContentFragment.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
        }// getItem(int)

        @Override
        public int getCount() {
            return 2;
        }// getCount()

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch(position) {
                case 0:
                    return getString(R.string.title_section1_about).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2_about).toUpperCase(l);
            }
            return null;
        }// getPageTitle(int)
    } //class AboutPagerAdapter

    public static class AboutContentFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER="section_number";

        public AboutContentFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.about_content, container, false);
            TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label_about);
            dummyTextView.setText(Integer.toString(getArguments().getInt(
                    ARG_SECTION_NUMBER)));
            return rootView;
        }// onCreateView(LayoutInflater, ViewGroup, Bundle)
    }//class AboutContentFragment
}//class About
