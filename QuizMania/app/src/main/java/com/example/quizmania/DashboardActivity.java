package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.model.User;
import com.example.quizmania.service.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.quizmania.LoginActivity.token;

public class DashboardActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        Button quiz = findViewById(R.id.quiz_button);
        quiz.setOnClickListener(v -> lanuchQuizActivity());

        Api.getInstance().getUserService().checkMe(token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    private void lanuchQuizActivity() {
        Intent intent = new Intent(this, QuizListActivity.class);
        startActivity(intent);
    }
}
