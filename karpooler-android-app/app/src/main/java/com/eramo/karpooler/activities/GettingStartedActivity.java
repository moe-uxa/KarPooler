package com.eramo.karpooler.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.eramo.karpooler.R;
import com.eramo.karpooler.fragments.IntroFragment;
import com.eramo.karpooler.models.dtos.IntroDTO;

public class GettingStartedActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 5;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private String [] titles;
    private String [] descriptions;
    private int [] imageResources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_started);

        // get titles
        titles = getResources().getStringArray(R.array.get_started_titles);

        // get descriptions
        descriptions = getResources().getStringArray(R.array.get_started_descriptions);

        // get image resources
        imageResources = getImageResources();

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {

            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            // create intro dto
            IntroDTO introDTO = new IntroDTO();
            introDTO.setOrderNumber(position);
            introDTO.setTitle(titles[position]);
            introDTO.setDescription(descriptions[position]);
            introDTO.setImageResource(imageResources[position]);

            IntroFragment fragment = new IntroFragment();
            fragment.setIntroDTO(introDTO);

            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    private int [] getImageResources(){

        int [] resources = new int[5];

        for (int i=0; i<resources.length; i++){

            switch (i){
                case 0:
                    resources[i] = R.drawable.ic_saving_money;
                    break;
                case 1:
                    resources[i] = R.drawable.ic_saving_gasoline;
                    break;
                case 2:
                    resources[i] = R.drawable.ic_making_new_friends;
                    break;
                case 3:
                    resources[i] = R.drawable.ic_decreasing_traffic;
                    break;
                case 4:
                    resources[i] = R.drawable.ic_decreasing_pollution;
                    break;
            }

        }

        return resources;
    }

}
