package com.eramo.karpooler.helpers;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.ChatMessageDTO;
import com.eramo.karpooler.models.dtos.SentChatMessageDTO;

/**
 * Created by Mohamed.Gaber on 11/8/2015.
 */
public class GenerateMessageShapeHelper {

    public static RelativeLayout generateReceivedMessageShape(Activity activity, ChatMessageDTO chatMessageDTO){

        // inflate layout
        RelativeLayout messageShapeLayout = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.layout_received_message, null);

        // convert padding from dp to px
        int paddingInPx = activity.getResources().getDimensionPixelSize(R.dimen.chat_message_layout_padding);

        // set layout params and padding
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        messageShapeLayout.setLayoutParams(layoutParams);
        messageShapeLayout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

        // set sender image
        ImageView messageSenderImage = (ImageView) messageShapeLayout.findViewById(R.id.imgv_sender_image);
        messageSenderImage.setImageBitmap(chatMessageDTO.getMessageOwnerImage());

        // set message text
        TextView messageText = (TextView) messageShapeLayout.findViewById(R.id.tv_message_text);
        messageText.setText(chatMessageDTO.getMessage());

        // set message Time
        TextView messageTime = (TextView) messageShapeLayout.findViewById(R.id.tv_message_time);
        messageTime.setText(chatMessageDTO.getMessageTime());

        return messageShapeLayout;

    }

    public static RelativeLayout generateSentMessageShape(Activity activity, SentChatMessageDTO chatMessageDTO){

        // inflate layout
        RelativeLayout messageShapeLayout = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.layout_sent_message, null);

        // convert padding from dp to px
        int paddingInPx = activity.getResources().getDimensionPixelSize(R.dimen.chat_message_layout_padding);

        // set layout params and padding
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        messageShapeLayout.setLayoutParams(layoutParams);
        messageShapeLayout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

        // set user image
        ImageView messageUserImage = (ImageView) messageShapeLayout.findViewById(R.id.imgv_trip_owner_image);
        messageUserImage.setImageBitmap(chatMessageDTO.getMessageOwnerImage());

        // set message text
        TextView messageText = (TextView) messageShapeLayout.findViewById(R.id.tv_message_text);
        messageText.setText(chatMessageDTO.getMessage());

        // set message Time
        TextView messageTime = (TextView) messageShapeLayout.findViewById(R.id.tv_message_time);
        messageTime.setText(chatMessageDTO.getMessageTime());

        // set message State
        TextView messageState = (TextView) messageShapeLayout.findViewById(R.id.tv_message_state);
        messageState.setText(chatMessageDTO.getMessageState());

        return messageShapeLayout;

    }


}
