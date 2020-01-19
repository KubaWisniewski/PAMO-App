package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.model.User;
import com.example.quizmania.service.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.quizmania.LoginActivity.token;

public class DashboardActivity extends AppCompatActivity {
    public User user;
    public Button profileButton, rankingButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);
        profileButton = findViewById(R.id.button_profile);
        rankingButton = findViewById(R.id.ranking_button_id);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanuchProfileActivity();
            }
        });
        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanuchRankingActivity();
            }
        });
        Api.getInstance().getUserService().checkMe(token).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                System.out.println(user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
    private void lanuchProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void lanuchRankingActivity(){
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);
    }
}
