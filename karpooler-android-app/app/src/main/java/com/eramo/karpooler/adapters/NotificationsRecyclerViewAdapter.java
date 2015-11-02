package com.eramo.karpooler.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.MessageDTO;
import com.eramo.karpooler.models.dtos.NotificationDTO;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 11/3/2015.
 */
public class NotificationsRecyclerViewAdapter extends RecyclerView.Adapter<NotificationsRecyclerViewAdapter.ViewHolder> {

    private List<NotificationDTO> notifications;
    private Fragment fragment;

    public NotificationsRecyclerViewAdapter(List<NotificationDTO> notifications, Fragment fragment) {
        this.notifications = notifications;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notification, parent, false);

        NotificationsRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get notification dto
        NotificationDTO notificationDTO = notifications.get(position);

        // bind data
        holder.notifyOwnerImage.setImageBitmap(notificationDTO.getNotifyOwnerImage());
        holder.notifyOwnerName.setText(notificationDTO.getNotifyOwnerName());
        holder.notifyText.setText(notificationDTO.getNotifyText());
        holder.notifyTime.setText(notificationDTO.getNotifyTime());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView notifyOwnerImage;
        public TextView notifyText;
        public TextView notifyTime;
        public TextView notifyOwnerName;

        public ViewHolder(View view) {
            super(view);

            notifyOwnerImage = (CircleImageView) view.findViewById(R.id.imgv_notify_owner);
            notifyText = (TextView) view.findViewById(R.id.tv_notify);
            notifyTime = (TextView) view.findViewById(R.id.tv_notify_time);
            notifyOwnerName = (TextView) view.findViewById(R.id.tv_notify_owner);
        }
    }

    public void addNotification(NotificationDTO notificationDTO){
        notifications.add(notificationDTO);
        notifyDataSetChanged();
    }

    public void addNotifications(List<NotificationDTO> addedNotifications){
        notifications.addAll(addedNotifications);
        notifyDataSetChanged();
    }
}
