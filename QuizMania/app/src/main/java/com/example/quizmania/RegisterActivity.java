package com.example.quizmania;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.service.LoginPayload;
import com.example.quizmania.service.RegisterPayload;
import com.example.quizmania.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    public RegisterPayload registerPayload = new RegisterPayload();
    private Button registerButton;
    private TextView ageLabel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        registerButton = findViewById(R.id.register_button_id);
        ageLabel = findViewById(R.id.age_id);
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.107:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        registerPayload.username = "tutor";
        registerPayload.email = "ttt@wp.pl";
        registerPayload.gender = "MALE";
        registerPayload.password = "qwerty";
        registerPayload.dateOfBirth = "1996-05-11";

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService userService = retrofit.create(UserService.class);
                Call<RegisterPayload> call = userService.register(registerPayload);
                call.enqueue(new Callback<RegisterPayload>() {
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
