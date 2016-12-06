package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BlockedNotificationsActivity extends AppCompatActivity {

    private Button historyBtn;
    private Button groupBtn;
    private Button scheduleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_notifications);
        setTitle("Blocked Notifications");

        historyBtn = (Button)findViewById(R.id.history_btn);
        groupBtn = (Button)findViewById(R.id.group_btn);
        scheduleBtn = (Button)findViewById(R.id.schedule_btn);

        historyBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BlockedNotificationsActivity.this, HistoryActivity.class);
                startActivity(intent);
                BlockedNotificationsActivity.this.finish();
            }
        });

        scheduleBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BlockedNotificationsActivity.this, SchedulePoliciesActivity.class);
                startActivity(intent);
                BlockedNotificationsActivity.this.finish();
            }
        });


    }
}
