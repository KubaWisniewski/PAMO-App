package com.example.quizmania.model.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class to map login payload
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginPayload {
    public String email;
    public String password;
}
