package com.example.quizmania.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class with retrofit instance using singleton design pattern
 */
public class Api {
    private static final String BASE_URL = "http://172.17.16.152:8081/";
    private static Api instance = null;
    private UserService userService;
    private AuthService authService;
    private QuizService quizService;

    /**
     * Getter for Api instance
     *
     * @return Api
     */

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }

        return instance;
    }

    /**
     * No arg constructor
     */
    private Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.userService = retrofit.create(UserService.class);
        this.authService = retrofit.create(AuthService.class);
        this.quizService = retrofit.create(QuizService.class);
    }

    /**
     * Getter for UserService
     *
     * @return UserService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Getter for AuthService
     *
     * @return AuthService
     */
    public AuthService getAuthService() {
        return authService;
    }

    /**
     * Getter for QuizService
     *
     * @return QuizService
     */
    public QuizService getQuizService() {
        return quizService;
    }
}
