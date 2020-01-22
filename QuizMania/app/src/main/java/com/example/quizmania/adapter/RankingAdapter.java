package com.example.quizmania.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmania.R;
import com.example.quizmania.model.UserScore;

import java.util.ArrayList;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder> {
    private Context mContext;
    private ArrayList<UserScore> muserScores;

    public RankingAdapter(Context context, ArrayList<UserScore> userScores) {
        mContext = context;
        muserScores = userScores;
    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.ranking_element, parent, false);
        return new RankingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder holder, int position) {
        UserScore currentItem = muserScores.get(position);
        String username = currentItem.getUsername();
        Integer points = currentItem.getTotalScore();
        holder.username.setText(username);
        holder.points.setText("Punkty: " + points);
    }

    @Override
    public int getItemCount() {
        return muserScores.size();
    }

    class RankingViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView points;

        RankingViewHolder(View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.text_view_username);
            points = itemView.findViewById(R.id.text_view_points);
        }
    }
}
