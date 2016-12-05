package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BlockedNotificationsActivity extends AppCompatActivity {

    private Button clearBtn;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_notifications);
        setTitle("Blocked Notifications");

        clearBtn = (Button)findViewById(R.id.clear_btn);
        backBtn = (Button)findViewById(R.id.back_btn);

        backBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BlockedNotificationsActivity.this, HistoryActivity.class);
                startActivity(intent);
                BlockedNotificationsActivity.this.finish();
            }
        });

    }
}
