package com.example.caculator2;

import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class RobotiumTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Context context;
    private Solo solo;

    @Before
    public void setUp() throws Exception {
        //setUp() is run before a test case is started.'8/
        //This is where the solo object is created.
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), activityTestRule.getActivity());
        context = InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }

    @After
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }

    @Test
    public void testPlus() throws Exception {
        solo.clickOnView(solo.getView(R.id.btn2));
        solo.clickOnView(solo.getView(R.id.btnPlus));
        solo.clickOnView(solo.getView(R.id.btn5));
        solo.clickOnView(solo.getView(R.id.btnEqual));

        TextView textResult = (TextView) solo.getView(R.id.txtResult);

        String actualResult = textResult.getText().toString();

        String expectedResult = "7.0";

        assertEquals(expectedResult, actualResult);

        solo.clickOnView(solo.getView(R.id.btnC));
    }

    @Test
    public void testMinus() throws Exception {
        solo.clickOnView(solo.getView(R.id.btn2));
        solo.clickOnView(solo.getView(R.id.btn7));
        solo.clickOnView(solo.getView(R.id.btnMinus));
        solo.clickOnView(solo.getView(R.id.btn7));
        solo.clickOnView(solo.getView(R.id.btnEqual));

        TextView textResult = (TextView) solo.getView(R.id.txtResult);

        String actualResult = textResult.getText().toString();

        String expectedResult = "20.0";

        assertEquals(expectedResult, actualResult);

        solo.clickOnView(solo.getView(R.id.btnC));
    }

    @Test
    public void testDivide() throws Exception {
        solo.clickOnView(solo.getView(R.id.btn1));
        solo.clickOnView(solo.getView(R.id.btn5));
        solo.clickOnView(solo.getView(R.id.btnDivide));
        solo.clickOnView(solo.getView(R.id.btn2));
        solo.clickOnView(solo.getView(R.id.btnEqual));

        TextView textResult = (TextView) solo.getView(R.id.txtResult);

        String actualResult = textResult.getText().toString();

        String expectedResult = "7.5";

        assertEquals(expectedResult, actualResult);

        solo.clickOnView(solo.getView(R.id.btnC));
    }

    @Test
    public void testMulti() throws Exception {
        solo.clickOnView(solo.getView(R.id.btn2));
        solo.clickOnView(solo.getView(R.id.btnMulti));
        solo.clickOnView(solo.getView(R.id.btn9));
        solo.clickOnView(solo.getView(R.id.btnEqual));

        TextView textResult = (TextView) solo.getView(R.id.txtResult);

        String actualResult = textResult.getText().toString();

        String expectedResult = "18.0";

        assertEquals(expectedResult, actualResult);

        solo.clickOnView(solo.getView(R.id.btnC));
    }

    @Test
    public void testPolynomial() throws Exception {
        solo.clickOnView(solo.getView(R.id.btnOpenBracket));
        solo.clickOnView(solo.getView(R.id.btn2));
        solo.clickOnView(solo.getView(R.id.btnPlus));
        solo.clickOnView(solo.getView(R.id.btn8));
        solo.clickOnView(solo.getView(R.id.btnCloseBracket));
        solo.clickOnView(solo.getView(R.id.btnMulti));
        solo.clickOnView(solo.getView(R.id.btn5));
        solo.clickOnView(solo.getView(R.id.btnEqual));

        TextView textResult = (TextView) solo.getView(R.id.txtResult);

        String actualResult = textResult.getText().toString();

        String expectedResult = "50.0";

        assertEquals(expectedResult, actualResult);

        solo.clickOnView(solo.getView(R.id.btnC));
    }
}
