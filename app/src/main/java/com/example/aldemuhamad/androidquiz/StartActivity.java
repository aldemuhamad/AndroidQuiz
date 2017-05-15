package com.example.aldemuhamad.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final EditText insertName = (EditText) findViewById(R.id.mEdInsertName);

        Button BtnStart = (Button) findViewById(R.id.mBtnStart);

        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(StartActivity.this, MainActivity.class);
                start.putExtra("name", insertName.getText().toString());
                startActivity(start);
                finish();
            }
        });
    }
}
