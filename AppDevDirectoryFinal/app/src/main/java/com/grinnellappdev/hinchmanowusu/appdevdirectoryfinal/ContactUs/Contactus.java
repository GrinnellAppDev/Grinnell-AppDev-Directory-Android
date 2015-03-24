package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.ContactUs;


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

public class Contactus extends Fragment {

    public static final String TAG = Fragment.class.getSimpleName();
    ContactusPagerAdapter mContactusPagerAdapter;
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
        mContactusPagerAdapter = new ContactusPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mContactusPagerAdapter);

        return v;
    }// onCreateView(LayoutInflater, ViewGroup, Bundle)

    public class ContactusPagerAdapter extends FragmentPagerAdapter {

        public ContactusPagerAdapter(FragmentManager fm) {
            super(fm);
        } // AboutPagerAdapter(FragmentManager)

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ContactusContentFragment();
            Bundle args = new Bundle();
            args.putInt(ContactusContentFragment.ARG_SECTION_NUMBER, position + 1);
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
                    return getString(R.string.title_section1_contact).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2_contact).toUpperCase(l);
            }
            return null;
        }// getPageTitle(int)
    } //class AboutPagerAdapter

    public static class ContactusContentFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER="section_number";

        public ContactusContentFragment() {
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
    }//class ContactusContentFragment
}//class Contactus
