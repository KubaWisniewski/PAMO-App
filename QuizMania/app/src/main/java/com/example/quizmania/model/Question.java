package com.example.quizmania.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;
    private String text;
    private String imgUrl;
    @SerializedName("answerDtoList")
    @Expose
    private List<Answer> answers = new ArrayList<>();
}
