package hk.ust.cse.comp107x.greetfriend;

import android.test.ActivityInstrumentationTestCase2;
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

    private MainActivity mainActivity;
    private static final String TAG = "MainActivityTest";
    private Calendar cal;

    public MainActivityTest() {
        super(MainActivity.class);
    }


    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(getInstrumentation());
        mainActivity = getActivity();
        cal = Calendar.getInstance();
    }

    public void testGoodMorning() {
        cal.set(2016,5,23,11,0,0); //11 am

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Morning John!")));
    }

    public void testGoodMorningLowerBoundary() {
        cal.set(2016,5,23,6,0,0); //6 am

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Morning John!")));
    }

    public void testGoodAfternoon() {
        cal.set(2016,5,23,14,0,0); //2 pm

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Afternoon John!")));
    }

    public void testGoodAfternoonLowerBoundary() {
        cal.set(2016,5,23,12,0,0); //12 am
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Afternoon John!")));
    }

    public void testGoodEvening() {
        cal.set(2016,5,23,19,0,0); //7 pm

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Evening John!")));
    }
    public void testGoodEveningLowerBoundary() {
        cal.set(2016,5,23,17,0,0); //5 pm

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Evening John!")));
    }

    public void testGoodNight() {
        cal.set(2016,5,23,2,0,0); //2 am

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Night John!")));
    }

    public void testGoodNightLowerBoundary() {
        cal.set(2016,5,23,21,0,0); //9 pm

        // Type text and then press the button.
        onView(withId(R.id.editFriendName))
                .perform(typeText("John"), closeSoftKeyboard());
        onView(withId(R.id.greetButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textMessage)).check(matches(withText("Good Night John!")));
    }

}