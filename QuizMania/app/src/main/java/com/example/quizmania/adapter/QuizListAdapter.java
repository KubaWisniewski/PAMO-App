package com.example.quizmania.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmania.R;
import com.example.quizmania.model.Quiz;

import java.util.List;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;
    private List<Quiz> quizList;

    public QuizListAdapter(Context context, List<Quiz> quizList) {
        this.mContext = context;
        this.quizList = quizList;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.quiz_item, parent, false);
        return new QuizViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        Quiz quiz = quizList.get(position);
        holder.mTextViewQuizName.setText(quiz.getName());
        holder.mTextViewQuizDescription.setText(quiz.getDescription());
    }

    @Override
    public int getItemCount() {
        return quizList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView mTextViewQuizName;
        TextView mTextViewQuizDescription;

        QuizViewHolder(View itemView) {
            super(itemView);
            mTextViewQuizName = itemView.findViewById(R.id.quizNameTextView);
            mTextViewQuizDescription = itemView.findViewById(R.id.quizDescriptionTextView);

            itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
