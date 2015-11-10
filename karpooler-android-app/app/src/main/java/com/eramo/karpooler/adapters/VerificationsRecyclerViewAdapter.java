package com.eramo.karpooler.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.VerificationDTO;

import java.util.List;


/**
 * Created by Mohamed.Gaber on 11/10/2015.
 */
public class VerificationsRecyclerViewAdapter extends RecyclerView.Adapter<VerificationsRecyclerViewAdapter.ViewHolder> {

    private List<VerificationDTO> verifications;
    private Activity activity;

    public VerificationsRecyclerViewAdapter(List<VerificationDTO> verifications, Activity activity) {
        this.verifications = verifications;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_verification_behaviour, parent, false);

        VerificationsRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get verification dto
        VerificationDTO verificationDTO = verifications.get(position);

        // bind data
        holder.icon.setImageBitmap(verificationDTO.getIcon());
        holder.text.setText(verificationDTO.getText());

    }

    @Override
    public int getItemCount() {
        return verifications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView icon;
        public TextView text;

        public ViewHolder(View view) {
            super(view);

            icon = (ImageView) view.findViewById(R.id.imgv_icon);
            text = (TextView) view.findViewById(R.id.tv_text);
        }
    }

    public void addVerificationsList(List<VerificationDTO> verificationsList){
        verifications.addAll(verificationsList);
        notifyDataSetChanged();
    }
}
