package com.example.resto.service;

import com.example.resto.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userrepo;

    UserService(UserRepo userrepo){
        this.userrepo = userrepo;
    }
}
