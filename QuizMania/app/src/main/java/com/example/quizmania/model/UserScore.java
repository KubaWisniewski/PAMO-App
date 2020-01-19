package com.example.quizmania.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Class containing username and quiz information.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserScore {
    private String username;
    private Integer numberOfDoneQuizes=0;
    private Integer totalScore=0;
}