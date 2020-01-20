package com.example.quizmania.model;


import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for user
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private Gender gender;
    private String email;
    private List<Role> rolesDto = new LinkedList<>();
    private Double balance;
    private Object dateOfBirth;
}
