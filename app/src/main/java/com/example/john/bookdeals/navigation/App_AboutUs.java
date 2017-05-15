package com.example.john.bookdeals.navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.john.bookdeals.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class App_AboutUs extends Fragment {


    public App_AboutUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app__about_us, container, false);
    }

}
