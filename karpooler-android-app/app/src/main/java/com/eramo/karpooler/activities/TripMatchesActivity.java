package com.eramo.karpooler.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.eramo.karpooler.R;
import com.eramo.karpooler.fragments.TripMatchesFragment;
import com.eramo.karpooler.tabs.SlidingTabLayout;

public class TripMatchesActivity extends BaseActivity{

    private ViewPager viewPager;
    private SlidingTabLayout tabs;

    private final int NUMBER_OF_TABS = 7;

    private MyViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_matches);

        // setup tool bar
        setupToolBar();

        // enable home button
        enableUpButton();

        // set title
        getSupportActionBar().setTitle(getResources().getString(R.string.trip_matches));

        // prepare tabs
        prepareTabs();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_trip_matches, menu);

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

        private String[] tabsTitles;

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);

            tabsTitles = getResources().getStringArray(R.array.trip_matches_tabs_titles);

        }

        @Override
        public Fragment getItem(int position) {

            TripMatchesFragment tripMatchesFragment = new TripMatchesFragment();
            tripMatchesFragment.setDayOffset(position);

            return tripMatchesFragment;
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
