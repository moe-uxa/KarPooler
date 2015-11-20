package com.eramo.karpooler.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.eramo.karpooler.R;
import com.eramo.karpooler.fragments.FeedFragment;
import com.eramo.karpooler.fragments.InboxFragment;
import com.eramo.karpooler.fragments.MoreFragment;
import com.eramo.karpooler.fragments.MyTripFragment;
import com.eramo.karpooler.fragments.NotificationFragment;
import com.eramo.karpooler.tabs.SlidingTabLayout;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class HomeActivity extends BaseActivity {

    private ViewPager viewPager;
    private SlidingTabLayout tabs;
    private int[] icons;

    // TABS
    private final int FEED_TAB = 0;
    private final int MY_TRIP_TAB = 1;
    private final int INBOX_TAB = 2;
    private final int NOTIFICATION_TAB = 3;
    private final int MORE_TAB = 4;

    private String[] tabsTitles;
    private int selectedTabPosition;
    private MyViewPagerAdapter viewPagerAdapter;
    private FloatingActionMenu floatingActionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // setup tool bar
        setupToolBar();

        // get tabs titles
        tabsTitles = getResources().getStringArray(R.array.home_tabs_titles);

        // set tab title
        setToolBarTitle(tabsTitles[selectedTabPosition]);

        // prepare tabs
        prepareTabs();

        // prepare FAB button menu
        prepareFabButtonMenu();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_home, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

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
        tabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabs.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));

        // set on tab pag change listener
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                floatingActionMenu.showMenuButton(true);

            }

            @Override
            public void onPageSelected(int position) {

                // save selected tab position
                selectedTabPosition = position;

                // set tab title
                setToolBarTitle(tabsTitles[position]);


                if (floatingActionMenu.isOpened())
                    floatingActionMenu.close(true);
                else
                    floatingActionMenu.hideMenuButton(true);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);


    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        //icons = {R.drawable.ic_feed, R.drawable.ic_trip, R.drawable.ic_inbox, R.drawable.ic_notif, R.drawable.ic_more};

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);

            prepareTabsIcons();
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position) {

                case FEED_TAB:
                    fragment = new FeedFragment();
                    break;
                case MY_TRIP_TAB:
                    fragment = new MyTripFragment();
                    break;
                case INBOX_TAB:
                    fragment = new InboxFragment();
                    break;
                case NOTIFICATION_TAB:
                    fragment = new NotificationFragment();
                    break;
                case MORE_TAB:
                    fragment = new MoreFragment();
                    break;

            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            int iconSizeInPx = getResources().getDimensionPixelSize(R.dimen.home_tabs_icon_size);

            Drawable drawable = getResources().getDrawable(icons[position]);
            drawable.setBounds(0, 0, iconSizeInPx, iconSizeInPx);

            ImageSpan imageSpan = new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return spannableString;
        }


    }

    private void setToolBarTitle(String title) {

        // set toolbar title
        getSupportActionBar().setTitle(title);
    }

    private void prepareTabsIcons() {
        icons = new int[5];
        icons[FEED_TAB] = R.drawable.ic_feed;
        icons[MY_TRIP_TAB] = R.drawable.ic_trip;
        icons[INBOX_TAB] = R.drawable.ic_inbox;
        icons[NOTIFICATION_TAB] = R.drawable.ic_notif;
        icons[MORE_TAB] = R.drawable.ic_more;
    }

    private void prepareFabButtonMenu() {

        // menu button
        floatingActionMenu = (FloatingActionMenu) findViewById(R.id.fab_menu);

        // Status Button
        FloatingActionButton statusBtn = (FloatingActionButton) findViewById(R.id.menu_item_status);
        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Status", Toast.LENGTH_SHORT).show();
            }
        });

        // Ride Now Button
        FloatingActionButton rideNowBtn = (FloatingActionButton) findViewById(R.id.menu_item_ride_now);
        rideNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // open ride now activity
                startActivity(new Intent(HomeActivity.this, RideNowActivity.class));
            }
        });

        // Create Car Pooling Button
        FloatingActionButton createCarPoolingBtn = (FloatingActionButton) findViewById(R.id.menu_item_create_car_pooling);
        createCarPoolingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Create Car Pooling", Toast.LENGTH_SHORT).show();

            }
        });

        // Create Group Button
        FloatingActionButton createGroupBtn = (FloatingActionButton) findViewById(R.id.menu_item_create_group);
        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this, "Create Group", Toast.LENGTH_SHORT).show();
            }
        });

        // Finds Group Button
        FloatingActionButton findGroupBtn = (FloatingActionButton) findViewById(R.id.menu_item_find_group);
        findGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // start find group activity
                startActivity(new Intent(HomeActivity.this, FindGroupActivity.class));
            }
        });

    }
}
