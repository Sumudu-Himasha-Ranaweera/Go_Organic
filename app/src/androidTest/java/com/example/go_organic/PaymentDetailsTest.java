package com.example.go_organic;

import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentDetailsTest {

    @Rule
    public ActivityTestRule<PaymentDetails> mActivityTestRule = new ActivityTestRule<PaymentDetails>(PaymentDetails.class);

    private PaymentDetails mActivity = null;

    @Before
    public void setUp() throws Exception {

        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

      View view = mActivity.findViewById(R.id.Payment_Details_T);

      assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {

        mActivity = null;
    }
}