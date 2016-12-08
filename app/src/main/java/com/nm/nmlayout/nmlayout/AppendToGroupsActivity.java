package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppendToGroupsActivity extends AppCompatActivity {

    private Button cancelBtn;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_append_to_groups);
        setupActionBar();

        cancelBtn = (Button)findViewById(R.id.cancel_btn);
        saveBtn = (Button)findViewById(R.id.save_btn);

        cancelBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AppendToGroupsActivity.this, HistoryActivity.class);
                startActivity(intent);
                AppendToGroupsActivity.this.finish();
            }
        });

        saveBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AppendToGroupsActivity.this, HistoryActivity.class);
                startActivity(intent);
                AppendToGroupsActivity.this.finish();
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

        LayoutParams lp1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View customNav = LayoutInflater.from(this).inflate(R.layout.component_button_action_bar, null);

        ((TextView)customNav.findViewById(R.id.action_bar_title)).setText("Select Group");

        actionBar.setCustomView(customNav, lp1);
    }


}
