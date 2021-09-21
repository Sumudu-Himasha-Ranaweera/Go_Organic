package com.example.go_organic.OnBoard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.go_organic.R;
import com.example.go_organic.UserLogin.SignIN_Page;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OnBoardingFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnBoardingFragment3 extends Fragment {

    Activity context;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public OnBoardingFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OnBoardingFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static OnBoardingFragment3 newInstance(String param1, String param2) {
        OnBoardingFragment3 fragment = new OnBoardingFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        context = getActivity();

        return inflater.inflate(R.layout.fragment_on_boarding3, container, false);
    }


    public void onStart() {

        super.onStart();
        Button btn = (Button) context.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SignIN_Page.class);
                startActivity(intent);
            }
        });

    }

}