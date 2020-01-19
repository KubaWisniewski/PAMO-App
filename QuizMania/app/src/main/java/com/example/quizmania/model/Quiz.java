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
public class Quiz {
    private Long id;
    private String name;
    private String description;
    private Object startDate;
    private Object endDate;
    private String imgUrl;
    @SerializedName("questionDtoList")
    @Expose
    private List<Question> questions  = new ArrayList<>();
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
}
