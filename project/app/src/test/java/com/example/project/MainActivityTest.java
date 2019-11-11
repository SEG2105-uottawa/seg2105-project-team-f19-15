package com.example.myapplication;


import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class MainActivityTest {
	@Rule
    public ActivityTestRule<MainActivity> mActivityTestRule= new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;
    private TextView text;
    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }
    private TextView text;

    @Test
    @UiThreadTest
    public void checkEditTextUsername(){
        assertNotNull(mActivity.findViewById(R.id.etUsername));
        text = mActivity.findViewById(R.id.etUsername);
        text.setText("abcdefg");
        assertEquals("abcdefg",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditTextPassword1(){
        assertNotNull(mActivity.findViewById(R.id.etpassword_1));
        text = mActivity.findViewById(R.id.etpassword_1);
        text.setText("123456789");
        assertEquals("123456789",text.getText().toString());

    }
    @Test
    @UiThreadTest
    public void checkEditTextPassword2(){
        assertNotNull(mActivity.findViewById(R.id.etpassword_1));
        text = mActivity.findViewById(R.id.etpassword_1);
        text.setText("abcdefghj");
        assertEquals("abcdefghj",text.getText().toString());

    }


    @Test
    @UiThreadTest
    public void checkEditTextPassword3(){
        assertNotNull(mActivity.findViewById(R.id.etpassword_1));
        text = mActivity.findViewById(R.id.etpassword_1);
        text.setText("123321abcdefg");
        assertEquals("123321abcdefg",text.getText().toString());

    }
}
