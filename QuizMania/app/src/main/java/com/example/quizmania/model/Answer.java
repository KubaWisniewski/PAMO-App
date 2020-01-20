package com.example.quizmania.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Long id;
    private String text;
    private String imgUrl;
    @SerializedName("correct")
    @Expose
    private Boolean correct;
}
