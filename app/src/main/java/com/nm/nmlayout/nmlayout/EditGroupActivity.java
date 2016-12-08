package com.nm.nmlayout.nmlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditGroupActivity extends AppCompatActivity {

    private Button cancelBtn;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);
        setTitle("New/Edit Group");

        cancelBtn = (Button)findViewById(R.id.cancel_btn);
        saveBtn = (Button)findViewById(R.id.save_btn);

        cancelBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EditGroupActivity.this, RegisteredGroupsActivity.class);
                startActivity(intent);
                EditGroupActivity.this.finish();
            }
        });

        saveBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(EditGroupActivity.this, RegisteredGroupsActivity.class);
                startActivity(intent);
                EditGroupActivity.this.finish();
            }
        });
    }
}
