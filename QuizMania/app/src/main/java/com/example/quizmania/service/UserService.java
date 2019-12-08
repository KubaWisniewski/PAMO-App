package com.example.quizmania.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("users/new")
    Call login(@Body LoginPayload loginPayload);
}
