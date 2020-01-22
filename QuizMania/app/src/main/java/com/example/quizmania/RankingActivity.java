package com.example.quizmania;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmania.adapter.RankingAdapter;
import com.example.quizmania.model.UserScore;
import com.example.quizmania.service.Api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.quizmania.LoginActivity.token;

public class RankingActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RankingAdapter rankingAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_activity);

        Api.getInstance().getUserService().getRanking(token).enqueue(new Callback<ArrayList<UserScore>>() {
            @Override
            public void onResponse(Call<ArrayList<UserScore>> call, Response<ArrayList<UserScore>> response) {
                showData(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<UserScore>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    private void showData(ArrayList<UserScore> userScores) {
        userScores = userScores.stream().sorted(Comparator.comparing(UserScore::getTotalScore).reversed()).collect(Collectors.toCollection(ArrayList::new));
        recyclerView = findViewById(R.id.ranking_recycler_view);
        rankingAdapter = new RankingAdapter(this, userScores);
        recyclerView.setAdapter(rankingAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
