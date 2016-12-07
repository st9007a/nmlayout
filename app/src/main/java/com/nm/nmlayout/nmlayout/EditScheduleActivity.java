package com.nm.nmlayout.nmlayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EditScheduleActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_schedule);
        setTitle("New Schedule");

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new EditScheduleActivity.ViewPagerAdapter(getSupportFragmentManager()));
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final String[] tabTitles = { "Groups", "Times" };

        public ViewPagerAdapter(FragmentManager fm) { super(fm); }

        @Override
        public CharSequence getPageTitle(int position) { return tabTitles[position]; }

        @Override
        public int getCount() { return tabTitles.length; }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    SelectGroupFragment tab1 = new SelectGroupFragment();
                    return tab1;
                case 1:
                    SelectTimeFragment tab2 = new SelectTimeFragment();
                    return tab2;
                default:
                    return null;
            }
        }
    }
}
