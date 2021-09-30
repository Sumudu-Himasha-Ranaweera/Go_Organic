package com.example.go_organic.UserLogin;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.go_organic.HomePage;
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

public class SignIN_PageTest {

    @Rule
    public ActivityTestRule<SignIN_Page> pageActivityTestRule = new ActivityTestRule<SignIN_Page>(SignIN_Page.class);

    private SignIN_Page sign = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(HomePage.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        sign = pageActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch()
    {
        assertNotNull(sign.findViewById(R.id.img_btn));
        onView(withId(R.id.img_btn)).perform(click());

        Activity HomePage = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(HomePage);
        HomePage.finish();

    }

    @After
    public void tearDown() throws Exception {
        sign = null;
    }
}