package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.About;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.R;

public class About extends Fragment {

    public About(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about, container, false);

        return rootView;
    }
}//class Contactus
