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
public class Main14ActivityTest {
    @Rule
    public ActivityTestRule<Main14Activity> mActivityTestRule= new ActivityTestRule<Main14Activity>(Main14Activity.class);
    private Main14Activity mActivity=null;
    private TextView text;

    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    @UiThreadTest
    public void checkEditTextyear(){
        assertNotNull(mActivity.findViewById(R.id.year));
        text = mActivity.findViewById(R.id.year);
        text.setText("7");
        assertNotEquals("10",text.getText().toString());

    }

    public void   checkhour(){
        assertNotNull(mActivity.findViewById(R.id.hour));
        text = mActivity.findViewById(R.id.hour);
        text.setText("10");
        assertNotEquals("9",text.getText().toString());
    }

    public void checkmonth(){
        assertNotNull(mActivity.findViewById(R.id.month));
        text = mActivity.findViewById(R.id.month);
        text.setText("1");
        String tmp = text.getText().toString();
        assertNotEquals("1",tmp);
    }
    public void checkbuttonupdate(){
        assertNotNull(mActivity.findViewById(R.id.submit));
    }


}
