package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {


    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("3Day Notifications");

        backBtn = (Button)findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HistoryActivity.this, BlockedNotificationsActivity.class);
                startActivity(intent);
                HistoryActivity.this.finish();
            }
        });


    }
}
