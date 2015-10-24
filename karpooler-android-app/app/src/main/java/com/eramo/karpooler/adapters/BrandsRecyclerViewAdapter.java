package com.eramo.karpooler.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.CarSelectionActivity;
import com.eramo.karpooler.models.dtos.BrandDTO;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class BrandsRecyclerViewAdapter extends RecyclerView.Adapter<BrandsRecyclerViewAdapter.ViewHolder> {

    private List<BrandDTO> brands;
    private CarSelectionActivity activity;

    public BrandsRecyclerViewAdapter(List<BrandDTO> brands, CarSelectionActivity activity) {
        this.brands = brands;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_brand, parent, false);

        ViewHolder vh = new ViewHolder(v, activity);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // get brand dto
        BrandDTO brandDTO = brands.get(position);

        holder.brandLabel.setText(brandDTO.getBrandName());
        holder.brandImageView.setImageBitmap(brandDTO.getBrandImage());

    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public ImageView brandImageView;
        public TextView brandLabel;

        public ViewHolder(View v, final CarSelectionActivity activity) {
            super(v);

            brandImageView = (ImageView) v.findViewById(R.id.imgv_brand);
            brandLabel  = (TextView) v.findViewById(R.id.label_brand);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.getFragmentManager().popBackStack();
                }
            });

        }
    }



    public void setBrands(List<BrandDTO> brands) {
        this.brands = brands;
    }

}
