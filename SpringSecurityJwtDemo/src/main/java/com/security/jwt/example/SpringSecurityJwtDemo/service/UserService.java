package com.security.jwt.example.SpringSecurityJwtDemo.service;

import com.security.jwt.example.SpringSecurityJwtDemo.models.Users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<Users> store = new ArrayList<>();

    public UserService(){
        store.add(new Users(UUID.randomUUID().toString(), "Prakhar", "prakhar@gmail.com"));
        store.add(new Users(UUID.randomUUID().toString(), "Srasti", "srasti@gmail.com"));
        store.add(new Users(UUID.randomUUID().toString(), "Dhriti", "dhriti@gmail.com"));
    }

    public List<Users> getUsers(){
        return this.store;
    }
}
