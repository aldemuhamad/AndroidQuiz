package com.example.aldemuhamad.androidquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView textScore = (TextView) findViewById(R.id.mTextScore);
        TextView mTextName = (TextView) findViewById(R.id.mTextName);

        String participant = getIntent().getStringExtra("name");
        mTextName.setText(participant);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        textScore.setText("Your Score: " + score);
    }

    public void onClick(View view) {
        Intent intent = new Intent(ScoreActivity.this, ExplainationActivity.class);
        startActivity(intent);
        finish();
    }
}
