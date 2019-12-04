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
public class MainBookCheckActivityTest {
    @Rule
    public ActivityTestRule<MainBookCheckActivity> mActivityTestRule= new ActivityTestRule<MainBookCheckActivity>(MainBookCheckActivity.class);
    private MainBookCheckActivity mActivity=null;
    private TextView text;

    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();
    }

    @Test
    @UiThreadTest
    public void checkEditTextclinicname(){
        assertNotNull(mActivity.findViewById(R.id.editText6));
        text = mActivity.findViewById(R.id.editText6);
        text.setText("awsome");
        assertNotEquals("good",text.getText().toString());

    }

    public void   checkcomment(){
        assertNotNull(mActivity.findViewById(R.id.editText4));
        text = mActivity.findViewById(R.id.editText4);
        text.setText("great");
        assertNotEquals("good",text.getText().toString());
    }

    public void checkrate(){
        assertNotNull(mActivity.findViewById(R.id.editText5));
        text = mActivity.findViewById(R.id.editText5);
        text.setText("5");
        String tmp = text.getText().toString();
        assertNotEquals("1",tmp);
    }
    public void checkbuttonupdate(){
        assertNotNull(mActivity.findViewById(R.id.button13));
    }
}
