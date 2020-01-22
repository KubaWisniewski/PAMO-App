package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    public Button profileButton, rankingButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        profileButton = findViewById(R.id.profile_button);
        rankingButton = findViewById(R.id.ranking_button);
        Button quiz = findViewById(R.id.quiz_button);

        profileButton.setOnClickListener(v -> lanuchProfileActivity());
        rankingButton.setOnClickListener(v -> lanuchRankingActivity());
        quiz.setOnClickListener(v -> lanuchQuizActivity());
    }

    private void lanuchProfileActivity() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void lanuchRankingActivity() {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }

    private void lanuchQuizActivity() {
        Intent intent = new Intent(this, QuizListActivity.class);
        startActivity(intent);
    }
}
