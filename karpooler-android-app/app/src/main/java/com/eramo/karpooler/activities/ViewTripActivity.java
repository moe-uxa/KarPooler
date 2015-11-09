package com.eramo.karpooler.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.eramo.karpooler.R;
import com.eramo.karpooler.fragments.TripDetailsFragment;
import com.eramo.karpooler.fragments.TripDiscussionFragment;
import com.eramo.karpooler.fragments.TripPeopleFragment;
import com.eramo.karpooler.tabs.SlidingTabLayout;

public class ViewTripActivity extends BaseActivity {

    private ViewPager viewPager;
    private SlidingTabLayout tabs;

    private final int NUMBER_OF_TABS = 3;

    // TABS
    private final int DETAILS_TAB = 0;
    private final int PEOPLE_TAB = 1;
    private final int DISCUSSION_TAB = 2;

    private String[] tabsTitles;
    private MyViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_trip);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // get tabs titles
        tabsTitles = getResources().getStringArray(R.array.view_trip_tabs_titles);

        // set tab title
        setToolBarTitle("Work Trip");

        // prepare tabs
        prepareTabs();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_view_trip, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home){

            NavUtils.navigateUpFromSameTask(this);

        }

        return super.onOptionsItemSelected(item);
    }


    private void setToolBarTitle(String title) {

        // set toolbar title
        getSupportActionBar().setTitle(title);
    }

    private void prepareTabs() {

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());

        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerAdapter);

        // Assigning the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        // set tab custom view
        tabs.setCustomTabView(R.layout.view_trip_tab_custom_view, R.id.tabText);

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabs.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);


    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {

                case DETAILS_TAB:
                    fragment = new TripDetailsFragment();
                    break;
                case PEOPLE_TAB:
                    fragment = new TripPeopleFragment();
                    break;
                case DISCUSSION_TAB:
                    fragment = new TripDiscussionFragment();
                    break;

            }

            return fragment;
        }

        @Override
        public int getCount() {
            return NUMBER_OF_TABS;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return tabsTitles[position];
        }


    }

}
