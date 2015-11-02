package com.eramo.karpooler.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.helpers.FontUtil;
import com.eramo.karpooler.models.dtos.MessageDTO;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 11/2/2015.
 */
public class MessagesRecyclerViewAdapter extends RecyclerView.Adapter<MessagesRecyclerViewAdapter.ViewHolder> {

    private List<MessageDTO> messages;
    private Fragment fragment;

    public MessagesRecyclerViewAdapter(List<MessageDTO> messages, Fragment fragment) {
        this.messages = messages;
        this.fragment = fragment;
    }

    @Override
    public MessagesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);

        MessagesRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MessagesRecyclerViewAdapter.ViewHolder holder, int position) {

        // get message dto
        MessageDTO messageDTO = messages.get(position);

        // bind data
        holder.messageOwnerImage.setImageBitmap(messageDTO.getMessageOwner());
        holder.message.setText(messageDTO.getMessage());
        holder.messageTime.setText(messageDTO.getMessageTime());
        holder.messageOwnerName.setText(messageDTO.getMessageOwnerName());

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView messageOwnerImage;
        public TextView message;
        public TextView messageTime;
        public TextView messageOwnerName;

        public ViewHolder(View view) {
            super(view);

            messageOwnerImage = (CircleImageView) view.findViewById(R.id.imgv_message_owner);
            message = (TextView) view.findViewById(R.id.tv_message);
            messageTime = (TextView) view.findViewById(R.id.tv_message_time);
            messageOwnerName = (TextView) view.findViewById(R.id.tv_message_owner);
        }
    }

    public void addMessage(MessageDTO messageDTO){
        messages.add(messageDTO);
        notifyDataSetChanged();
    }

    public void addMessages(List<MessageDTO> addedMessage){
        messages.addAll(addedMessage);
        notifyDataSetChanged();
    }
}
