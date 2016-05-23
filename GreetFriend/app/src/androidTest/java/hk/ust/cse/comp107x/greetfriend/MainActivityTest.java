package hk.ust.cse.comp107x.greetfriend;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import org.junit.Before;

import java.util.Calendar;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static final String TAG = "MainActivityTest";
    private Calendar cal;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(getInstrumentation());
        cal = Calendar.getInstance();
        getActivity();
    }

    public void testGoodMorning() {
        cal.set(Calendar.HOUR_OF_DAY, 11); //11 am
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Morning John!")));
    }

    public void testGoodMorningLowerBoundary() {
        cal.set(Calendar.HOUR_OF_DAY, 6); //6 am
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Morning John!")));
    }

    public void testGoodAfternoon() {
        cal.set(Calendar.HOUR_OF_DAY, 14); //2 pm
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Afternoon John!")));
    }

    public void testGoodAfternoonLowerBoundary() {
        cal.set(Calendar.HOUR_OF_DAY, 12); //12 am
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Afternoon John!")));
    }

    public void testGoodEvening() {
        cal.set(Calendar.HOUR_OF_DAY, 19); //7 pm
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Evening John!")));
    }

    public void testGoodEveningLowerBoundary() {
        cal.set(Calendar.HOUR_OF_DAY, 17); //5 pm
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Evening John!")));
    }

    public void testGoodNight() {
        cal.set(Calendar.HOUR_OF_DAY, 12); //2 am
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Night John!")));
    }

    public void testGoodNightLowerBoundary() {
        cal.set(Calendar.HOUR_OF_DAY, 21); //9 pm
        Log.d(TAG, Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Night John!")));
    }

}