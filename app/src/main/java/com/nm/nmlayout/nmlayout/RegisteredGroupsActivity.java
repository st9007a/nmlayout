package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisteredGroupsActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tabs;

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_groups);
        setupActionBar();

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);

        backBtn = (Button)findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(RegisteredGroupsActivity.this, BlockedNotificationsActivity.class);
                startActivity(intent);
                RegisteredGroupsActivity.this.finish();
            }
        });
    }

    //custom action bar
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);

        ActionBar.LayoutParams lp1 = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        View customNav = LayoutInflater.from(this).inflate(R.layout.component_dropdown_action_bar, null);

        ((TextView)customNav.findViewById(R.id.action_bar_title)).setText("Registered Groups");
        Spinner spinner = (Spinner)customNav.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> dropdownList = ArrayAdapter.createFromResource(RegisteredGroupsActivity.this,
                R.array.registered_groups_dropdown,
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dropdownList);
        actionBar.setCustomView(customNav, lp1);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final String[] tabTitles = { "App", "Notification" };

        public ViewPagerAdapter(FragmentManager fm) { super(fm); }

        @Override
        public CharSequence getPageTitle(int position) { return tabTitles[position]; }

        @Override
        public int getCount() { return tabTitles.length; }

        @Override
        public Fragment getItem(int position) { return EditListFragment.newInstance(position); }
    }

}
