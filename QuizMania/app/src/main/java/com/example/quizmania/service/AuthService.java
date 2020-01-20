package com.example.quizmania.service;

import com.example.quizmania.model.payload.LoginPayload;
import com.example.quizmania.model.payload.RegisterPayload;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Interface with api auth calls
 */
public interface AuthService {
    /**
     * POST login method
     *
     * @param loginPayload Object with login and password field.
     */
    @POST("/api/auth/signin")
    Call<LoginPayload> login(@Body LoginPayload loginPayload);

    /**
     * POST register method
     *
     * @param registerPayload Object with all required data to register.
     */
    @POST("/api/auth/signup")
    Call<RegisterPayload> register(@Body RegisterPayload registerPayload);
}
