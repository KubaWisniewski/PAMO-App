package com.example.quizmania.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class with retrofit instance using singleton design pattern
 */
public class Api {
    private static final String BASE_URL = "http://192.168.0.24:8081/";
    private static Api instance = null;
    private UserService userService;
    private AuthService authService;

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }

        return instance;
    }

    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.userService = retrofit.create(UserService.class);
        this.authService = retrofit.create(AuthService.class);
    }

    public UserService getUserService() {
        return userService;
    }

    public AuthService getAuthService() {
        return authService;
    }
}
