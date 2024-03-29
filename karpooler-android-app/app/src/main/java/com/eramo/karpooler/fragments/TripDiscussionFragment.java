package com.eramo.karpooler.fragments;


import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.ViewTripActivity;
import com.eramo.karpooler.helpers.GenerateMessageShapeHelper;
import com.eramo.karpooler.models.dtos.ChatMessageDTO;
import com.eramo.karpooler.models.dtos.SentChatMessageDTO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class TripDiscussionFragment extends Fragment {

    private ViewTripActivity activity;
    private LinearLayout messageArea;
    private ScrollView scrollView;

    private EditText textBox;

    public TripDiscussionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip_discussion, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get activity instance
        activity = (ViewTripActivity) getActivity();

        // prepare messages area
        prepareMessagesArea();

        // prepare text box
        prepareTextBox();

        // add test data
        addTestData();
    }

    private void prepareMessagesArea(){

        messageArea = (LinearLayout) activity.findViewById(R.id.layout_messages_area);
        scrollView = (ScrollView) activity.findViewById(R.id.scrollView);

    }

    private void prepareTextBox(){

        textBox = (EditText) activity.findViewById(R.id.edt_text_box);

        Button sendButton = (Button) activity.findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               testSendMessage();

                // scroll down
                scrollView.post(new Runnable() {

                    @Override
                    public void run() {
                        scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                    }
                });

                // empty text box
                textBox.setText("");
            }
        });

    }


    private void addMessageToMessageArea(ChatMessageDTO chatMessageDTO){

        RelativeLayout messageShapeLayout = null;

        // generate message shape bases on message dto type
        if (chatMessageDTO instanceof SentChatMessageDTO)
            messageShapeLayout = GenerateMessageShapeHelper.generateSentMessageShape(activity, (SentChatMessageDTO) chatMessageDTO);
        else
            messageShapeLayout = GenerateMessageShapeHelper.generateReceivedMessageShape(activity, chatMessageDTO);

        // add message shape to message area
        messageArea.addView(messageShapeLayout);

    }

    private void addTestData(){

        // message 1 ( received)
        ChatMessageDTO chatMessageDTO1 = new ChatMessageDTO();
        chatMessageDTO1.setMessage("Hello");
        chatMessageDTO1.setMessageOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        chatMessageDTO1.setMessageTime("09:30");
        addMessageToMessageArea(chatMessageDTO1);

        // message 2 (sent)
        SentChatMessageDTO chatMessageDTO2 = new SentChatMessageDTO();
        chatMessageDTO2.setMessage("Hello");
        chatMessageDTO2.setMessageOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        chatMessageDTO2.setMessageTime("09:32");
        chatMessageDTO2.setMessageState("Sent");
        addMessageToMessageArea(chatMessageDTO2);

        // message 3 ( received)
        ChatMessageDTO chatMessageDTO3 = new ChatMessageDTO();
        chatMessageDTO3.setMessage("It's been a long day without you my friend And I'll tell you all about it when I see you again We've come a long way from");
        chatMessageDTO3.setMessageOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person2)).getBitmap());
        chatMessageDTO3.setMessageTime("10:00");
        addMessageToMessageArea(chatMessageDTO3);

        // message 4 (sent)
        SentChatMessageDTO chatMessageDTO4 = new SentChatMessageDTO();
        chatMessageDTO4.setMessage("It's been a long day without you my friend And I'll ask.");
        chatMessageDTO4.setMessageOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        chatMessageDTO4.setMessageTime("10:02");
        chatMessageDTO4.setMessageState("Read");
        addMessageToMessageArea(chatMessageDTO4);

    }

    private void testSendMessage(){

        // test send button
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        SentChatMessageDTO sentChatMessageDTO = new SentChatMessageDTO();
        sentChatMessageDTO.setMessage(textBox.getText().toString());
        sentChatMessageDTO.setMessageTime("" + format.format(Calendar.getInstance().getTime()));
        sentChatMessageDTO.setMessageState("Sent");
        sentChatMessageDTO.setMessageOwnerImage(((BitmapDrawable) getResources().getDrawable(R.drawable.person3)).getBitmap());
        addMessageToMessageArea(sentChatMessageDTO);

    }

}
