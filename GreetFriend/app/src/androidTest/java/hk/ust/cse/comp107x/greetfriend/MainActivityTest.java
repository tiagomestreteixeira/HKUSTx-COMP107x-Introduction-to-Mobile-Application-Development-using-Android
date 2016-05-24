package hk.ust.cse.comp107x.greetfriend;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import org.joda.time.DateTimeUtils;
import org.junit.Before;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static final String TAG = "MainActivityTest";

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(getInstrumentation());
        getActivity();
    }

    void testGreetingHelper(int hour,String greetMessage){
        Log.d(TAG, String.format("Expected in Test: Hour-%s; GreetMessage:%s", Integer.toString(hour), greetMessage));
        Calendar calendar = new GregorianCalendar(2016, 1, 1, hour, 0, 0); // 2016-01-01 hour:00:00
        DateTimeUtils.setCurrentMillisFixed(calendar.getTimeInMillis());
        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText(String.format("%s John!", greetMessage))));
    }

    public void testGoodMorning() {
        testGreetingHelper(11,"Good Morning");// 11 am
    }

    public void testGoodMorningLowerBoundary() {
        testGreetingHelper(6,"Good Morning"); // 6 am
    }

    public void testGoodAfternoon() {
        testGreetingHelper(14,"Good Afternoon"); // 2 pm
    }

    public void testGoodAfternoonLowerBoundary() {
        testGreetingHelper(12,"Good Afternoon"); //12 pm
    }

    public void testGoodEvening() {
        testGreetingHelper(19,"Good Evening"); //7 pm
    }

    public void testGoodEveningLowerBoundary() {
        testGreetingHelper(17,"Good Evening"); //5 pm
    }

    public void testGoodNight() {
        testGreetingHelper(2,"Good Night"); //2 am
    }

    public void testGoodNightLowerBoundary() {
        testGreetingHelper(21,"Good Night"); //9 pm
    }

}