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
import com.eramo.karpooler.tabs.SlidingTabLayout;

public class HomeActivity extends BaseActivity {

    private ViewPager viewPager;
    private SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // setup tool bar
        setupToolBar();

        // set toolbar title
        getSupportActionBar().setTitle("Feed");

        // view pager and tabs
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tabs.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));
        tabs.setViewPager(viewPager);


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

    private class MyViewPagerAdapter extends FragmentPagerAdapter{

        private int [] icons = {R.drawable.ic_feed, R.drawable.ic_trip, R.drawable.ic_inbox, R.drawable.ic_notif, R.drawable.ic_more};

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return new FeedFragment();
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
}
