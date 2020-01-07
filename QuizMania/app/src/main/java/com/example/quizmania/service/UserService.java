package com.example.quizmania.service;

import com.example.quizmania.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Interface with api user calls
 */
public interface UserService {
    @GET("/api/user/me")
    Call<User> checkMe(@Header("X-Auth-Token") String authorization);
}
