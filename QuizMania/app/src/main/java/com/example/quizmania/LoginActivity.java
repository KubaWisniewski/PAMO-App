package com.example.quizmania;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button login;
/*
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("localhost:8081/api/auth")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        login = findViewById(R.id.button_login_id);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
