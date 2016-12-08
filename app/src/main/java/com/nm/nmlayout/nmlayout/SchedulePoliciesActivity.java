package com.nm.nmlayout.nmlayout;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SchedulePoliciesActivity extends AppCompatActivity {

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_policies);
        setupActionBar();

        backBtn = (Button)findViewById(R.id.back_btn);

        backBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SchedulePoliciesActivity.this, BlockedNotificationsActivity.class);
                startActivity(intent);
                SchedulePoliciesActivity.this.finish();
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
        View customNav = LayoutInflater.from(this).inflate(R.layout.component_button_action_bar, null);

        ((TextView)customNav.findViewById(R.id.action_bar_title)).setText("Schedule Policies");
        ((Button)customNav.findViewById(R.id.add_btn)).setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SchedulePoliciesActivity.this, EditScheduleActivity.class);
                startActivity(intent);
                SchedulePoliciesActivity.this.finish();
            }
        });

        actionBar.setCustomView(customNav, lp1);
    }
}
