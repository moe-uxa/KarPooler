package com.eramo.karpooler.adapters;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.MenuItemDTO;
import java.util.List;

/**
 * Created by Mohamed.Gaber on 11/4/2015.
 */
public class MoreMenuRecyclerViewAdapter extends RecyclerView.Adapter<MoreMenuRecyclerViewAdapter.ViewHolder> {

    private List<MenuItemDTO> items;
    private Fragment fragment;

    public MoreMenuRecyclerViewAdapter(List<MenuItemDTO> items, Fragment fragment) {
        this.items = items;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);

        MoreMenuRecyclerViewAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get item dto
        MenuItemDTO menuItemDTO = items.get(position);

        // bind data
        holder.icon.setImageResource(menuItemDTO.getIconResource());
        holder.text.setText(menuItemDTO.getText());
        holder.view.setOnClickListener(menuItemDTO.getOnClickListener());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView icon;
        public View view;
        public TextView text;

        public ViewHolder(View view) {
            super(view);

            this.view = view;
            text = (TextView) view.findViewById(R.id.tv_text);
            icon = (ImageView) view.findViewById(R.id.imgv_icon);
        }
    }

}
