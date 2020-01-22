package com.example.quizmania;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.model.User;
import com.example.quizmania.model.UserScore;
import com.example.quizmania.service.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.quizmania.LoginActivity.token;

/**
 * Class for profile view activity
 */
public class ProfileActivity extends AppCompatActivity {
    public User user;
    private TextView username, email, point, doneQuiz;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        username = findViewById(R.id.profile_username_text_view);
        email = findViewById(R.id.profile_email_text_view);
        point = findViewById(R.id.profile_points_text_view);
        doneQuiz = findViewById(R.id.profile_quiz_done_text_view);

        Api.getInstance().getUserService().checkMe(token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                username.setText(user.getUsername());
                email.setText(user.getEmail());
                Api.getInstance().getUserService().getRanking(token).enqueue(new Callback<ArrayList<UserScore>>() {
                    @Override
                    public void onResponse(Call<ArrayList<UserScore>> call, Response<ArrayList<UserScore>> response) {
                        ArrayList<UserScore> userScores = response.body();
                        UserScore u = userScores.stream().filter(userScore -> userScore.getUsername().equals(user.getUsername())).findFirst().orElseThrow(NullPointerException::new);
                        point.setText(u.getTotalScore().toString());
                        doneQuiz.setText(u.getNumberOfDoneQuizes().toString());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<UserScore>> call, Throwable t) {
                        System.out.println(t);
                    }
                });
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}

