package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.service.Api;
import com.example.quizmania.model.payload.LoginPayload;
import com.example.quizmania.utils.TextValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class for login view activity
 */
public class LoginActivity extends AppCompatActivity {
    private Button login;
    private TextView emailField, passwordField;
    public static String token = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        login = findViewById(R.id.button_login_id);
        emailField = findViewById(R.id.email_edit_text);
        passwordField = findViewById(R.id.password_edit_text);
        final Intent intent = new Intent(this, DashboardActivity.class);
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
                        if (response.code() == 200) {

                            token = response.headers().get("X-Auth-Token");
                            startActivity(intent);
                        } else {
                            emailField.setError("Błąd logowania!");
                        }
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
                    String regex = "[^@]+@[^.]+\\..+";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(text);
                    if (matcher.matches()) {
                        login.setEnabled(true);
                    } else {
                        emailField.setError("To chyba nie email :(");
                    }
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
}
