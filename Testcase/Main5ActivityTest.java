package com.example.myapplication;


import android.widget.TextView;

import androidx.test.annotation.UiThreadTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class Main5ActivityTest {

    @Rule
    public ActivityTestRule<Main5Activity> mActivityTestRule= new ActivityTestRule<Main5Activity>(Main5Activity.class);
    private Main5Activity mActivity=null;
    private TextView text;

    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    @UiThreadTest
    public void checkEditTextPrice(){
        assertNotNull(mActivity.findViewById(R.id.editTextPrice));
        text = mActivity.findViewById(R.id.editTextPrice);
        text.setText("4r45gg");
        assertEquals(false,text.getText().toString());

    }

    public void   checklistViewProducts(){
        assertNotNull(mActivity.findViewById(R.id.listViewProducts));
        text = mActivity.findViewById(R.id.listViewProducts);
        text.setText("Product1");
        String tmp = text.getText().toString();
        assertEquals("Product2",tmp);
    }

    public void checkEditTextName(){
        assertNotNull(mActivity.findViewById(R.id.editTextName));
        text = mActivity.findViewById(R.id.editTextName);
        text.setText("Amoxilin");
        String tmp = text.getText().toString();
        assertEquals("qingmeisu",tmp);
    }
    public void checkbuttonupdate(){
        assertNotNull(mActivity.findViewById(R.id.buttonDeleteProduct));
    }





}
