package com.security.jwt.example.SpringSecurityJwtDemo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private String userId;
    private String name;
    private String email;
}
