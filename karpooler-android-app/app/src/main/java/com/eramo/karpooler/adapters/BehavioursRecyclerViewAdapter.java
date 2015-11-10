package com.eramo.karpooler.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.BehaviourDTO;
import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/10/2015.
 */
public class BehavioursRecyclerViewAdapter extends RecyclerView.Adapter<BehavioursRecyclerViewAdapter.ViewHolder> {

    private List<BehaviourDTO> behaviours;
    private Activity activity;

    public BehavioursRecyclerViewAdapter(List<BehaviourDTO> behaviours, Activity activity) {
        this.behaviours = behaviours;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_verification_behaviour, parent, false);

        BehavioursRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get behaviour dto
        BehaviourDTO behaviourDTO = behaviours.get(position);

        // bind data
        holder.icon.setImageBitmap(behaviourDTO.getIcon());
        holder.text.setText(behaviourDTO.getText());

    }

    @Override
    public int getItemCount() {
        return behaviours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView text;

        public ViewHolder(View view) {
            super(view);

            icon = (ImageView) view.findViewById(R.id.imgv_icon);
            text = (TextView) view.findViewById(R.id.tv_text);
        }
    }

    public void addBehavioursList(List<BehaviourDTO> behavioursList) {
        behaviours.addAll(behavioursList);
        notifyDataSetChanged();
    }
}
