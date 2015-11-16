package com.eramo.karpooler.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.InviteMethodDTO;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/16/2015.
 */
public class InviteMethodsRecyclerViewAdapter  extends RecyclerView.Adapter<InviteMethodsRecyclerViewAdapter.ViewHolder>{

    private List<InviteMethodDTO> inviteMethods;
    private Activity activity;

    public InviteMethodsRecyclerViewAdapter(List<InviteMethodDTO> inviteMethods, Activity activity) {
        this.inviteMethods = inviteMethods;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_invite_method, parent, false);

        InviteMethodsRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get item dto
        InviteMethodDTO inviteMethodDTO = inviteMethods.get(position);

        // bind data
        holder.icon.setImageResource(inviteMethodDTO.getIconResource());
        holder.text.setText(inviteMethodDTO.getName());
        holder.view.setOnClickListener(inviteMethodDTO.getOnClickListener());

    }

    @Override
    public int getItemCount() {
        return inviteMethods.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView icon;
        public TextView text;
        public View view;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
            text = (TextView) view.findViewById(R.id.tv_text);
            icon = (ImageView) view.findViewById(R.id.imgv_icon);
        }
    }
}
