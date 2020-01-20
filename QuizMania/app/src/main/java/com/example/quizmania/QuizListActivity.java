package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizmania.adapter.OnItemClickListener;
import com.example.quizmania.adapter.QuizListAdapter;
import com.example.quizmania.model.Quiz;
import com.example.quizmania.service.Api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.quizmania.LoginActivity.token;

public class QuizListActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView mRecyclerView;
    private QuizListAdapter quizListAdapter;
    private List<Quiz> quizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
        this.mRecyclerView = findViewById(R.id.quizListView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Api.getInstance().getQuizService().getQuizs(token).enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                quizList = response.body();
                quizListAdapter = new QuizListAdapter(QuizListActivity.this, quizList);
                mRecyclerView.setAdapter(quizListAdapter);
                quizListAdapter.setOnItemClickListener(QuizListActivity.this);
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, QuizActivity.class);
        Quiz clickedItem = quizList.get(position);

        detailIntent.putExtra("QUIZ_ID", clickedItem.getId().toString());
        startActivity(detailIntent);
    }
}
