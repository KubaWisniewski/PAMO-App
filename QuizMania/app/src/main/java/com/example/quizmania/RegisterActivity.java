package com.example.quizmania;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmania.model.payload.RegisterPayload;
import com.example.quizmania.service.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class for register view activity
 */
public class RegisterActivity extends AppCompatActivity {
    public RegisterPayload registerPayload = new RegisterPayload();
    private TextView login, email, password;
    private RadioGroup gender;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        final Button registerButton = findViewById(R.id.register_button_id);
        login = findViewById(R.id.usernameEditText_id);
        email = findViewById(R.id.registerEmail_id);
        gender = findViewById(R.id.gender_group_id);
        password = findViewById(R.id.registerPassword_id);
        registerPayload.dateOfBirth = "1996-05-11";

        gender.setOnCheckedChangeListener((group, checkedId) -> {
            View radioButton = gender.findViewById(checkedId);
            int index = gender.indexOfChild(radioButton);
            switch (index) {
                case 0:
                    registerPayload.gender = "Mezczyzna";
                    System.out.println(index);
                    break;
                case 1:
                    registerPayload.gender = "Kobieta";
                    System.out.println(index);
                    break;
            }
        });

        final Intent intent = new Intent(this, LoginActivity.class);
        registerButton.setOnClickListener(v -> {
            registerPayload.username = login.getText().toString();
            registerPayload.email = email.getText().toString();
            registerPayload.password = password.getText().toString();

            Api.getInstance().getAuthService().register(registerPayload).enqueue(new Callback<RegisterPayload>() {
                @Override
                public void onResponse(Call<RegisterPayload> call, Response<RegisterPayload> response) {
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<RegisterPayload> call, Throwable t) {
                    System.out.println(t);
                }
            });
        });
    }
}
