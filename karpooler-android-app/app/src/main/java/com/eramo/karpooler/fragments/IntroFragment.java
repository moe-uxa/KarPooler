package com.eramo.karpooler.fragments;


import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eramo.karpooler.R;
import com.eramo.karpooler.activities.LoginActivity;
import com.eramo.karpooler.models.dtos.IntroDTO;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

    private IntroDTO introDTO;

    public IntroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intro, container, false);

        // prepare view pager indicator
        prepareViewPagerIndicator(view);

        // view title
        TextView title = (TextView) view.findViewById(R.id.tv_text);
        title.setText(introDTO.getTitle());

        // view description
        TextView description = (TextView) view.findViewById(R.id.tv_description);
        description.setText(introDTO.getDescription());

        // view image
        ImageView introImageView = (ImageView) view.findViewById(R.id.iv_intro_image);
        introImageView.setImageResource(introDTO.getImageResource());

        // get started button -> set on click listener
        Button getStartedButton = (Button) view.findViewById(R.id.btn_getting_start);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // go to login activity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void setIntroDTO(IntroDTO introDTO) {
        this.introDTO = introDTO;
    }

    private void prepareViewPagerIndicator(View view){

        LinearLayout viewPagerIndicator = (LinearLayout) view.findViewById(R.id.view_pager_indicator);

        for (int i = 0; i < 5; i++) {

            // default dot
            int imageResource = R.drawable.ic_dot;

            // selected dot
            if (i == introDTO.getOrderNumber())
                imageResource = R.drawable.ic_selected_dot;

            // create image view
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(0, 0, 15, 0);
            imageView.setImageResource(imageResource);

            // add image view to view pager indicator layout
            viewPagerIndicator.addView(imageView);
        }

    }
}
