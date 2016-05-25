package hk.ust.cse.comp107x.simplechatclient;

import android.support.test.espresso.base.MainThread;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.IsAnything.anything;

public class ChatClientTest extends ActivityInstrumentationTestCase2<ChatClient> {

    private ArrayList<Message> messages;
    private MyArrayAdapter listAdapter;

    private String[] incoming = {"Hey, How's it going?",
            "Super! Let's do lunch tomorrow",
            "How about Mexican?",
            "Great, I found this new place around the corner",
            "Ok, see you at 12 then!"};

    public ChatClientTest() {
        super(ChatClient.class);
    }


    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(getInstrumentation());
        messages = new ArrayList<>();
        listAdapter = new MyArrayAdapter(getActivity().getApplicationContext(), messages);
        generateMessages(5);
    }

    public void generateMessages(int numberItems) {
        String[] incoming = {"Hey, How's it going?",
                "Super! Let's do lunch tomorrow",
                "How about Mexican?",
                "Great, I found this new place around the corner",
                "Ok, see you at 12 then!"};

        for(int idx = 0; idx<numberItems;idx++){
            onView(withId(R.id.messageText)).perform(typeText(Integer.toString(idx)));
            onView(withId(R.id.sendButton)).perform(click());
            messages.add(new Message("",Integer.toString(idx),true,new Date()));
            messages.add(new Message("John",incoming[idx],false,new Date()));
            listAdapter.notifyDataSetChanged();
        }
    }

    public void testCountListMessages(){
        assertEquals(messages.size(),listAdapter.getCount());
    }


}