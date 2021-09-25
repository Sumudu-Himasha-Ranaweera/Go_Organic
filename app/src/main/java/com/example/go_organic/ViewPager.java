package com.example.go_organic;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.go_organic.OnBoard.OnBoardingFragment1;
import com.example.go_organic.OnBoard.OnBoardingFragment2;
import com.example.go_organic.OnBoard.OnBoardingFragment3;


public class ViewPager extends FragmentPagerAdapter {
    public ViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0: return new OnBoardingFragment1();
            case 1: return new OnBoardingFragment2();
            case 2: return new OnBoardingFragment3();
        }

        return null;
    }

    @Override
    public int getCount() {

        return 3;
    }
}
