package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.About;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Amanda Hinchman-Dominguez on 1/21/2015.
 *
 * Intended to display the mission statement.  A static page.
 */
public class FragmentHistory extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);

        return rootView;
    } // onCreateView
}//class FragmentHistory
