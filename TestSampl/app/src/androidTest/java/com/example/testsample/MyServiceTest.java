package com.example.testsample;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class MyServiceTest {

    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    // test for a service which is started with startService
    @Test
    public void testWithStartedService() {
        try {
            mServiceRule.
            startService(new Intent(InstrumentationRegistry.getTargetContext(),
                    MyService.class));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        // test code
    }

    @Test
 // test for a service which is started with bindService
    public void testWithBoundService() {
        /*IBinder binder = null;
        try {
            binder = mServiceRule.
                    bindService(new Intent(InstrumentationRegistry.getTargetContext(),
                            MyService.class));
            MyService service = ((MyService.LocalBinder) binder).getService();
            assertTrue("True wasn't returned", service.doSomethingToReturnTrue());
        } catch (TimeoutException e) {
            e.printStackTrace();
        }*/
    }
}
