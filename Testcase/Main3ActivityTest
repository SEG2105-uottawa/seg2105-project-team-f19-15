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

public class Main3ActivityTest {
    @Rule
    public ActivityTestRule<Main3Activity> mActivityTestRule= new ActivityTestRule<Main3Activity>(Main3Activity.class);
    private Main3Activity mActivity=null;
    
    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }
    @Test
    //test email case 1: all number
    public void checkEmail1() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.etEmail));
        text = mActivity.findViewById(R.id.etEmail);
        text.setText("1234567890");
        assertEquals(false, text.getText().toString().isEmail());
    }
     @Test
     //test email case 2: all letter
    public void checkEmail2() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.etEmail));
        text = mActivity.findViewById(R.id.etEmail);
        text.setText("abcdefghijk");
        assertEquals(false, text.getText().toString().isEmail());
    }

     @Test
     //test email case 3: half number half letter
    public void checkEmail2() throws Exception {
        assertNotNull(mActivity.findViewById(R.id.etEmail));
        text = mActivity.findViewById(R.id.etEmail);
        text.setText("a12345defghijk");
        assertEquals(false, text.getText().toString().isEmail());
    }

    public void checkPassword {
    	///
    }
}
