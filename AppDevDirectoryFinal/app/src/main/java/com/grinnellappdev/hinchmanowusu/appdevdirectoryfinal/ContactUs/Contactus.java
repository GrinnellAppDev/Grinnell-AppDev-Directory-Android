package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.ContactUs;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.R;

public class Contactus extends Fragment {

    public Contactus() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.contactus, container, false);

        return rootView;
    }
}// class Contactus