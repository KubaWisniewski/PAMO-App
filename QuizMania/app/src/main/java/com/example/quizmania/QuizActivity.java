package com.example.quizmania;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizmania.model.Answer;
import com.example.quizmania.model.Question;
import com.example.quizmania.model.Quiz;

import com.example.quizmania.service.Api;

import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.quizmania.LoginActivity.token;

/**
 * Class for quiz view activity
 */
public class QuizActivity extends AppCompatActivity {
    private Button answer1, answer2, answer3, answer4;
    private TextView question;
    private String mCorrectAnswer;
    private List<Question> questions = new ArrayList<>();
    private Integer questionNumber;
    private Integer mScore;
    private Handler handlerUI = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);
        Api.getInstance().getQuizService().joinQuiz(token, Long.parseLong(Objects.requireNonNull(getIntent().getStringExtra("QUIZ_ID")))).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println(t);
            }
        });

        Api.getInstance().getQuizService().getQuiz(token, Long.parseLong(Objects.requireNonNull(getIntent().getStringExtra("QUIZ_ID")))).enqueue(new Callback<Quiz>() {
            @Override
            public void onResponse(Call<Quiz> call, Response<Quiz> response) {
                Quiz quiz = response.body();
                if (quiz != null) {
                    questionNumber = 0;
                    mScore = 0;
                    questions = quiz.getQuestions();
                    updateQuestion(questionNumber);
                }
            }

            @Override
            public void onFailure(Call<Quiz> call, Throwable t) {
                System.out.println(t);
            }
        });

        answer1 = findViewById(R.id.answer_1_button);
        answer2 = findViewById(R.id.answer_2_button);
        answer3 = findViewById(R.id.answer_3_button);
        answer4 = findViewById(R.id.answer_4_button);
        question = findViewById(R.id.question_text_view);

        answer1.setOnClickListener(view -> {
            setButtonClickable(false);
            if (answer1.getText() == mCorrectAnswer) {
                mScore++;
                answer1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                answer1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
            voteOnAnswer(questions.get(questionNumber).getAnswers().get(0).getId());
            handlerUI.postDelayed(() -> updateQuestion(questionNumber), 1000);

        });

        answer2.setOnClickListener(view -> {
            setButtonClickable(false);
            if (answer2.getText() == mCorrectAnswer) {
                mScore++;
                answer2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                answer2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
            voteOnAnswer(questions.get(questionNumber).getAnswers().get(1).getId());
            handlerUI.postDelayed(() -> updateQuestion(questionNumber), 1000);

        });

        answer3.setOnClickListener(view -> {
            setButtonClickable(false);
            if (answer3.getText() == mCorrectAnswer) {
                mScore++;
                answer3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                answer3.setBackgroundColor(getResources().getColor(R.color.colorAccent));

            }
            voteOnAnswer(questions.get(questionNumber).getAnswers().get(2).getId());
            handlerUI.postDelayed(() -> updateQuestion(questionNumber), 1000);

        });

        answer4.setOnClickListener(view -> {
            setButtonClickable(false);
            if (answer4.getText() == mCorrectAnswer) {
                mScore++;
                answer4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            } else {
                answer4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
            voteOnAnswer(questions.get(questionNumber).getAnswers().get(3).getId());
            handlerUI.postDelayed(() -> updateQuestion(questionNumber), 1000);
        });
    }

    private void updateQuestion(int num) {
        if (num >= questions.size()) {
            endTheGame();
        } else {
            question.setText(questions.get(num).getText());
            answer1.setText(questions.get(num).getAnswers().get(0).getText());
            answer2.setText(questions.get(num).getAnswers().get(1).getText());
            answer3.setText(questions.get(num).getAnswers().get(2).getText());
            answer4.setText(questions.get(num).getAnswers().get(3).getText());
            mCorrectAnswer = questions.get(num).getAnswers().stream().filter(Answer::getCorrect).findFirst().get().getText();
            resetButtons();

        }
    }

    private void endTheGame() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage("Punkty: " + mScore)
                .setCancelable(false)
                .setNegativeButton(getString(R.string.exit_quiz),
                        (dialogInterface, i) -> {
                            Toast.makeText(QuizActivity.this, "", Toast.LENGTH_LONG).show();
                            finish();
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void voteOnAnswer(Long answerId) {
        Api.getInstance().getQuizService().voteOnAnswer(token, answerId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                questionNumber++;
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    private void setButtonClickable(Boolean clickable) {
        answer1.setClickable(clickable);
        answer2.setClickable(clickable);
        answer3.setClickable(clickable);
        answer4.setClickable(clickable);
    }

    private void resetButtons() {
        setButtonClickable(true);
        answer1.setBackgroundColor(getResources().getColor(R.color.colorButtonBackground));
        answer2.setBackgroundColor(getResources().getColor(R.color.colorButtonBackground));
        answer3.setBackgroundColor(getResources().getColor(R.color.colorButtonBackground));
        answer4.setBackgroundColor(getResources().getColor(R.color.colorButtonBackground));
    }
}
