package com.eramo.karpooler.activities;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eramo.karpooler.R;
import com.eramo.karpooler.fragments.FeedFragment;
import com.eramo.karpooler.fragments.InboxFragment;
import com.eramo.karpooler.fragments.MoreFragment;
import com.eramo.karpooler.fragments.MyTripFragment;
import com.eramo.karpooler.fragments.NotificationFragment;
import com.eramo.karpooler.tabs.SlidingTabLayout;

public class HomeActivity extends BaseActivity {

    private ViewPager viewPager;
    private SlidingTabLayout tabs;

    // TABS
    private final int FEED_TAB = 0;
    private final int MY_TRIP_TAB = 1;
    private final int INBOX_TAB = 2;
    private final int NOTIFICATION_TAB = 3;
    private final int MORE_TAB = 4;

    private String [] tabsTitles;
    private int selectedTabPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // setup tool bar
        setupToolBar();

        // get tabs titles
        tabsTitles = getResources().getStringArray(R.array.tabs_titles);

        // set tab title
        setToolBarTitle(tabsTitles[selectedTabPosition]);

        prepareTabs();

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

    private void prepareTabs(){

        // view pager and tabs
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabs.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));

        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // save selected tab position
                selectedTabPosition = position;

                // set tab title
                setToolBarTitle(tabsTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabs.setViewPager(viewPager);


    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter{

        private int [] icons = {R.drawable.ic_feed, R.drawable.ic_trip, R.drawable.ic_inbox, R.drawable.ic_notif, R.drawable.ic_more};

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            switch (position){

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

            Drawable drawable = getResources().getDrawable(icons[position]);
            drawable.setBounds(0, 0, 100, 100);

            ImageSpan imageSpan = new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return spannableString;
        }

    }

    private void setToolBarTitle(String title){

        // set toolbar title
        getSupportActionBar().setTitle(title);

    }
}
