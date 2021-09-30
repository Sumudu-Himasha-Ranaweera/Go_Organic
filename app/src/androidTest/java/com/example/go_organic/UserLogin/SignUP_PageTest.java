package com.example.go_organic.UserLogin;

import junit.framework.TestCase;
import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.go_organic.R;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertNotNull;

public class SignUP_PageTest extends TestCase {

    @Rule
    public ActivityTestRule<SignUP_Page> pageActivityTestRule = new ActivityTestRule<SignUP_Page>(SignUP_Page.class);

    private SignUP_Page sign = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(SignIN_Page.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        sign = pageActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch()
    {
        assertNotNull(sign.findViewById(R.id.img_btn_check));
        onView(withId(R.id.img_btn_check)).perform(click());

        Activity SignIN_Page = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(SignIN_Page);
        SignIN_Page.finish();

    }

    @After
    public void tearDown() throws Exception {
        sign = null;
    }
}