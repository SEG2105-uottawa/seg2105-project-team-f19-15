package com.example.myapplication;

import org.junit.Test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.widget.TextView;
import static org.junit.Assert.*;
import org.junit.After;



import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Main12ActivityTest {
	@Rule
    public ActivityTestRule<Main3Activity> mActivityTestRule= new ActivityTestRule<Main3Activity>(Main3Activity.class);
    private Main12Activity mActivity=null;
    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }
    @Test
    @UiThreadTest
    public void checkEditStartHour1(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("12");
        assertEquals("12",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditStartHour2(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("24");
        assertNotEquals("24",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditStartHour3(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("abc");
        assertNotEquals("abc",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkStarrtingMinute1(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("50");
        assertEquals("50",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkStarrtingMinute2(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("61");
        assertNotEquals("61",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkStarrtingMinute3(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("abc");
        assertNotEquals("abc",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditEndHour1(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("12");
        assertEquals("12",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditEndHour2(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("64");
        assertNotEquals("64",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditEndHour3(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("abc");
        assertNotEquals("abc",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEndMinute1(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("50");
        assertEquals("50",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEndMinute2(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("61");
        assertNotEquals("61",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEndMinute3(){
        assertNotNull(mActivity.findViewById(R.id.StartHours));
        text = mActivity.findViewById(R.id.StartHours);
        text.setText("abc");
        assertNotEquals("abc",text.getText().toString());

    }
    public void checkbuttonupdate(){
        assertNotNull(mActivity.findViewById(R.id.Set));
        ssertNotNull(mActivity.findViewById(R.id.Find);
    }


}
