package com.example.project;

import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Main12ActivityTest {
    @Rule
    public ActivityTestRule<Main12Activity> mActivityTestRule= new ActivityTestRule<Main12Activity>(Main12Activity.class);
    private Main12Activity mActivity=null;
    private TextView text;
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
    @Test
    @UiThreadTest
    public void checkbuttonupdate(){
        assertNotNull(mActivity.findViewById(R.id.Set));
        assertNotNull(mActivity.findViewById(R.id.Find));
    }


}
