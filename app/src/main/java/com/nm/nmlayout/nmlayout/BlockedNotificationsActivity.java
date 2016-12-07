package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BlockedNotificationsActivity extends AppCompatActivity
    implements NotificationListFragment.handleFragmentUI {

    private Button historyBtn;
    private Button groupBtn;
    private Button scheduleBtn;

    @Override
    public void setAppendBtnVisible(boolean b) {
        NotificationListFragment frag = (NotificationListFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_list_view);

        if (frag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            frag.updateView(false);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            NotificationListFragment newFragment = new NotificationListFragment();
            Bundle args = new Bundle();
            args.putBoolean(NotificationListFragment.APPEND_BUTTON_VISIBLE, false);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_list_view, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_notifications);

        setAppendBtnVisible(false);

        //initial UI
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

        groupBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BlockedNotificationsActivity.this, RegisteredGroupsActivity.class);
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
