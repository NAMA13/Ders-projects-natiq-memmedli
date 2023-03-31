package com.developia.CourseM.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Size(min = 1,message = "Username must not be least 1!")
    @Size(max = 30, message = "Username must not be more than 30!")
    @NotEmpty(message = "Not empty")
    private String username;
    @Size(min = 1,message = "Password must not be least 1!")
    @Size(max = 30, message = "Password must not be more than 30!")
    @NotEmpty(message = "Not empty")
    private String password;
}