package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Class for dashboard view activity
 */
public class DashboardActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        Button profileButton = findViewById(R.id.profile_button);
        Button rankingButton = findViewById(R.id.ranking_button);
        Button quiz = findViewById(R.id.quiz_button);
        Button quizCreator = findViewById(R.id.create_quiz_button);

        profileButton.setOnClickListener(v -> lanuchProfileActivity());
        rankingButton.setOnClickListener(v -> lanuchRankingActivity());
        quiz.setOnClickListener(v -> lanuchQuizActivity());
        quizCreator.setOnClickListener(v -> lanuchQuizCreator());
    }

    /**
     * Method to launch profile view
     */
    private void lanuchProfileActivity() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    /**
     * Method to launch ranking view
     */
    private void lanuchRankingActivity() {
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }

    /**
     * Method to launch quiz view
     */
    private void lanuchQuizActivity() {
        Intent intent = new Intent(this, QuizListActivity.class);
        startActivity(intent);
    }

    private void lanuchQuizCreator() {
        Intent intent = new Intent(this, QuizCreatorActivity.class);
        startActivity(intent);
    }


}
