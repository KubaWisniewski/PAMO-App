package com.example.quizmania.service;

import com.example.quizmania.model.User;
import com.example.quizmania.model.UserScore;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Interface with api user calls
 */
public interface UserService {
    /**
     * GET checkMe method
     *
     * @param authorization It's a token required to authorization.
     * @return User class
     */
    @GET("/api/user/me")
    Call<User> checkMe(@Header("X-Auth-Token") String authorization);

    /**
     * GET getRanking method
     *
     * @param authorization It's a token required to authorization.
     * @return List of UserScore class
     */
    @GET("/api/quiz/ranking")
    Call<ArrayList<UserScore>> getRanking(@Header("X-Auth-Token") String authorization);
}
