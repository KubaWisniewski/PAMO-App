package com.example.quizmania.service;

import com.example.quizmania.model.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Interface with api quiz calls
 */
public interface QuizService {
    /**
     * GET getQuiz method
     * @param authorization It's a token required to authorization.
     * @return Quiz object from api.
     */
    @GET("/api/quiz/{id}")
    Call<Quiz> getQuiz(@Header("X-Auth-Token") String authorization, @Path("id") Long id);

    /**
     * GET getQuizs method
     * @param authorization It's a token required to authorization.
     * @return List of quiz objects from api.
     */
    @GET("/api/quiz")
    Call<List<Quiz>> getQuizs(@Header("X-Auth-Token") String authorization);

    /**
     * POST voteOnAnswer method
     * @param authorization It's a token required to authorization.
     * @param id of answer.
     */
    @POST("/api/voteOnAnswer/{answerId}")
    Call<Void> voteOnAnswer(@Header("X-Auth-Token") String authorization, @Path("answerId") Long id);
}
