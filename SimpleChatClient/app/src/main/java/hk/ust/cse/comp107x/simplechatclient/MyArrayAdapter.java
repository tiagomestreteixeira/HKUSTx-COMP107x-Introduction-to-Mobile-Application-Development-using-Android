package hk.ust.cse.comp107x.simplechatclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> messages;

    public MyArrayAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.message, messages);
        this.context = context;
        this.messages = messages;
    }

    // This method constructs the ListItem's view from the data obtained
    // from the Message object. This will be called by ListView while it
    // is being drawn.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View messageView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int messageLayoutToInvoke, messageTextView, timeTextView;

        if (!messages.get(position).fromMe()) {
            messageLayoutToInvoke = R.layout.message;
            messageTextView = R.id.messageTextView;
            timeTextView = R.id.timeTextView;
        } else {
            messageLayoutToInvoke = R.layout.mymessage;
            messageTextView = R.id.mymessageTextView;
            timeTextView = R.id.mytimeTextView;
        }

        messageView = inflater.inflate(messageLayoutToInvoke, parent, false);
        TextView msgView = (TextView) messageView.findViewById(messageTextView);
        msgView.setText(messages.get(position).getMessage());

        TextView timeView = (TextView) messageView.findViewById(timeTextView);
        timeView.setText(messages.get(position).getTime());

        return messageView;
    }
}