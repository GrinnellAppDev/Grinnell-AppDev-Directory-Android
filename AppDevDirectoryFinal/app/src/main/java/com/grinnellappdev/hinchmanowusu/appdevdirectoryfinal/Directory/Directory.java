package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.Directory;

import android.app.ActionBar;
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

//www.paulusworld.com/techincal/android-navigationdrawer-sliding-tabs

public class Directory extends Fragment{

    public final static String TAG = Directory.class.getSimpleName();
    private ViewPager viewPager;
    private DirectoryTabsPagerAdapter mAdapter;

    public static Directory newInstance() {
        return new Directory();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }//onCreate(Bundle)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.directory, container, false);
        mAdapter = new DirectoryTabsPagerAdapter(getChildFragmentManager());

        viewPager = (ViewPager) v.findViewById(R.id.pager);
        viewPager.setAdapter(mAdapter);

        return v;
    }//onCreateView(Layout, ViewGroup, Bundle)

    public class DirectoryTabsPagerAdapter extends FragmentPagerAdapter {
        public DirectoryTabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new Directory();
            Bundle args = new Bundle();
            args.putInt(DirectoryContent.ARG_SECTION_NUMBER, position + 1);
            fragment.setArguments(args);
            return fragment;
        }//Fragment(int)

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int index) {
            Locale l = Locale.getDefault();
            switch(index) {
                case 0:
                    return getString(R.string.title_section1_directory).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2_directory).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3_directory).toUpperCase(l);
                case 3:
                    return getString(R.string.title_section4_directory).toUpperCase(l);
                case 4:
                    return getString(R.string.title_section5_directory).toUpperCase(l);
            }
            return null;
        }//getPageTitle(int)
    }//class DirectoryTabsPagerAdapter

    public static class DirectoryContent extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        public DirectoryContent() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.directory_content, container, false);
            TextView dummyTextView = (TextView)rootView.findViewById(R.id.section_label_directory);
            dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

    }//class DirectoryContent

}//class Directory
