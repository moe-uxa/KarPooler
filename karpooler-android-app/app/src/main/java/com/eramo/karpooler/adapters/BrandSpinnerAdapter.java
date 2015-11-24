package com.eramo.karpooler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.eramo.karpooler.R;
import com.eramo.karpooler.models.dtos.BrandDTO;

import java.util.List;


/**
 * Created by Mohamed.Gaber on 10/25/2015.
 */
public class BrandSpinnerAdapter extends ArrayAdapter {

    private List<BrandDTO> brands;
    private Context context;

    public BrandSpinnerAdapter(Context context, int resource, List<BrandDTO> brands) {
        super(context, resource, brands );
        this.brands = brands;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BrandDTO brandDTO = brands.get(0);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_spinner_brand, parent, false);


        ImageView brandImage = (ImageView) view.findViewById(R.id.imgv_brand);
        brandImage.setImageBitmap(brandDTO.getBrandImage());

        return view;
    }
}
