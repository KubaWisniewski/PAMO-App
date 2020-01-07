package com.example.quizmania;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.service.Api;
import com.example.quizmania.model.payload.RegisterPayload;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    public RegisterPayload registerPayload = new RegisterPayload();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        Button registerButton = findViewById(R.id.register_button_id);
        TextView ageLabel = findViewById(R.id.age_id);
        registerPayload.username = "tutor";
        registerPayload.email = "ttt@wp.pl";
        registerPayload.gender = "MALE";
        registerPayload.password = "qwerty";
        registerPayload.dateOfBirth = "1996-05-11";

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api.getInstance().getAuthService().register(registerPayload).enqueue(new Callback<RegisterPayload>() {
                    @Override
                    public void onResponse(Call<RegisterPayload> call, Response<RegisterPayload> response) {
                        System.out.println(response);
                    }

                    @Override
                    public void onFailure(Call<RegisterPayload> call, Throwable t) {
                        System.out.println(t);
                    }
                });
            }
        });
    }
}
