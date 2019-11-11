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
    @Test
   //case 1: the 2 password is match
    public void checkPassword throws Exception{
    	assertNotNull(mActivity.findViewById(R.id.et2Password));
    	assertNotNull(mActivity.findViewById(R.id.et2comfirmPassword));
    	
        text1 = mActivity.findViewById(R.id.et2Password);
        text2 = mActivity.findViewById(R.id.et2comfirmPassword);
        
        text1.setText("sdfijo");
        text2.setText("sdfijo")
        assertEquals(text1.getText().toString(), text2.getText().toString());
    	
    }
    @Test
    //case 2: the 2 password is not match
    public void checkPassword throws Exception{
    	assertNotNull(mActivity.findViewById(R.id.et2Password));
    	assertNotNull(mActivity.findViewById(R.id.et2comfirmPassword));
    	
        text1 = mActivity.findViewById(R.id.et2Password);
        text2 = mActivity.findViewById(R.id.et2comfirmPassword);
        
        text1.setText("123sdfijo");
        text2.setText("000sdfijo")
        assertNotEquals(text1.getText().toString(), text2.getText().toString());
    	
    }
}
