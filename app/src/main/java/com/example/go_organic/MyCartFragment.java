package com.example.go_organic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyCartFragment extends Fragment {

    Button btnmycart;


    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_my_cart, container, false);


        btnmycart = root.findViewById(R.id.btn_my_cart);

        btnmycart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent i = new Intent();
                        i.setClass(getActivity(), CartActivity.class);
                        startActivity(i);

                    }
                });




        return  root;

    }


}