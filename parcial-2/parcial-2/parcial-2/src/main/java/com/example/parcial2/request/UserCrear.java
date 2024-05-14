package com.example.parcial2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCrear {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
    private String tipo;
}
