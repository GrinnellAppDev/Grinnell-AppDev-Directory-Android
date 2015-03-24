package com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.ContactUs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grinnellappdev.hinchmanowusu.appdevdirectoryfinal.R;

/**
 * Created by Amanda Hinchman-Dominguez on 3/24/2015.
 * Creates a parse form request for a yung hunny
 */
public class FragmentAppReq {
    public FragmentAppReq(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_trainee_req, container, false);

        return rootView;
    }
}
