package com.example.quizmania;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.service.Api;
import com.example.quizmania.model.payload.LoginPayload;
import com.example.quizmania.utils.TextValidator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private TextView emailField, passwordField;
    public static String token = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        login = findViewById(R.id.button_login_id);
        emailField = findViewById(R.id.login_act_email_id);
        passwordField = findViewById(R.id.login_actv_password_id);
        final Intent intent = new Intent(this, DashboardActivity.class);

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();

        login.setEnabled(false);
        validateEmail();
        validatePassword();

        login.setOnClickListener(v -> Api
                .getInstance()
                .getAuthService()
                .login(LoginPayload.builder()
                        .email(emailField.getText().toString())
                        .password(passwordField.getText().toString()).build())
                .enqueue(new Callback<LoginPayload>() {
                    @Override
                    public void onResponse(Call<LoginPayload> call, Response<LoginPayload> response) {
                        System.out.println(response.headers().get("X-Auth-Token"));
                        token = response.headers().get("X-Auth-Token");
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<LoginPayload> call, Throwable t) {
                        System.out.println(t);
                    }
                }));
    }

    private void validateEmail() {
        emailField.addTextChangedListener(new TextValidator(emailField) {
            @Override
            public void validate(TextView textView, String text) {
                String emailValue = emailField.getText().toString();
                if (emailValue.isEmpty()) {
                    emailField.setError("To pole nie może być puste");
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
                }
            }
        });
    }

    private void validatePassword() {
        passwordField.addTextChangedListener(new TextValidator(passwordField) {
            @Override
            public void validate(TextView textView, String text) {
                String emailValue = passwordField.getText().toString();
                if (emailValue.isEmpty()) {
                    passwordField.setError("To pole nie może być puste");
                    login.setEnabled(false);
                } else {
                    login.setEnabled(true);
                }
            }
        });
    }

    private void validate() {
        if (passwordField.getText().toString().isEmpty() && emailField.getText().toString().isEmpty()) {
            login.setEnabled(true);
        }
    }
}
