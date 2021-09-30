package com.example.go_organic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.go_organic.UserLogin.SignIN_Page;
import com.example.go_organic.UserLogin.SignUP_Page;

public class JoinFarmerFragment extends Fragment {

    ImageButton btngo;

    public JoinFarmerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_join_farmer, container, false);

        btngo = root.findViewById(R.id.img_btn);

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getActivity(), JoinAsFarmerActivity.class);
                startActivity(i);
            }
        });

        return root;
    }
}