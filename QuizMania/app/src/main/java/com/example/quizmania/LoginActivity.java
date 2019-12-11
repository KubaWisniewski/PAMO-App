package com.example.quizmania;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.service.LoginPayload;
import com.example.quizmania.service.UserService;

import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    Button login;
    LoginPayload loginPayload = new LoginPayload();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        login = findViewById(R.id.button_login_id);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.107:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        loginPayload.email = "admin@test.com";
        loginPayload.password = "123";
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserService userService = retrofit.create(UserService.class);
                Call<LoginPayload> call = userService.login(loginPayload);
                call.enqueue(new Callback<LoginPayload>() {
                    @Override
                    public void onResponse(Call<LoginPayload> call, Response<LoginPayload> response) {
                        System.out.println(response.headers().get("X-Auth-Token"));
                    }

                    @Override
                    public void onFailure(Call<LoginPayload> call, Throwable t) {
                        System.out.println(t);
                    }
                });
            }
        });
    }
}
