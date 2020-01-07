package com.example.quizmania.model.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class to map register payload
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPayload {
    public String username;
    public String email;
    public String password;
    public String gender;
    public String dateOfBirth;
}
