package com.eramo.karpooler.helpers;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.eramo.karpooler.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohamed.Gaber on 11/2/2015.
 */
public class GeneratePeopleImageHelper {

    public static CircleImageView generateCircleImageView(Bitmap bitmap, Fragment fragment, int imageSizeDimenResource, int rightMarginDimenRes){

        CircleImageView circleImageView = new CircleImageView(fragment.getContext());

        // set src
        circleImageView.setImageBitmap(bitmap);

        // convert width and height from dp to px
        int imageSizeInPx = fragment.getResources().getDimensionPixelSize(imageSizeDimenResource);
        int imageRightMarginInPx = fragment.getResources().getDimensionPixelSize(rightMarginDimenRes);

        // set layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageSizeInPx, imageSizeInPx);
        layoutParams.setMargins(0, 0, imageRightMarginInPx, 0);
        circleImageView.setLayoutParams(layoutParams);

        return circleImageView;
    }

    public static RelativeLayout createMoreButton(Bitmap lastImage, int numberOfMorePassengers, Fragment fragment, View.OnClickListener moreBtnOnClickListener){


        RelativeLayout layout = (RelativeLayout) fragment.getLayoutInflater(null).inflate(R.layout.layout_more_passengers, null);

        // set layout params
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 10, 0);
        layout.setLayoutParams(layoutParams);

        // set last image
        CircleImageView circleImageView = (CircleImageView) layout.findViewById(R.id.imgv_last_image);
        circleImageView.setImageBitmap(lastImage);

        // set number of more friends
        Button moreButton = (Button) layout.findViewById(R.id.btn_more_passengers);
        moreButton.setText(numberOfMorePassengers+"+");

        // set more btn listener
        moreButton.setOnClickListener(moreBtnOnClickListener);

        return layout;
    }

}
