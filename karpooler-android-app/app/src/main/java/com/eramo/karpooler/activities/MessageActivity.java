package com.eramo.karpooler.activities;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.helpers.GenerateMessageShapeHelper;
import com.eramo.karpooler.models.dtos.ChatMessageDTO;
import com.eramo.karpooler.models.dtos.SentChatMessageDTO;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MessageActivity extends BaseActivity {

    private LinearLayout messageArea;
    private ScrollView scrollView;
    private EditText textBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // prepare messages area
        prepareMessagesArea();

        // prepare text box
        prepareTextBox();

        // add test data
        addTestData();

        // set title
        getSupportActionBar().setTitle("Johny");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_messages, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    private void prepareMessagesArea(){

        messageArea = (LinearLayout) findViewById(R.id.layout_messages_area);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

    }

    private void prepareTextBox(){

        textBox = (EditText) findViewById(R.id.edt_text_box);

        Button sendButton = (Button) findViewById(R.id.btn_send);
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
            messageShapeLayout = GenerateMessageShapeHelper.generateSentMessageShape(this, (SentChatMessageDTO) chatMessageDTO);
        else
            messageShapeLayout = GenerateMessageShapeHelper.generateReceivedMessageShape(this, chatMessageDTO);

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
