package com.example.resto.service;

import com.example.resto.entity.UserDetails;
import com.example.resto.model.RegistrationRequest;
import com.example.resto.model.RegistrationResponse;
import com.example.resto.model.RegistrationUpdateRequest;
import com.example.resto.model.UserAlreadyExistsException;
import com.example.resto.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private UserRepo userrepo;

    UserService(UserRepo userrepo){
        this.userrepo = userrepo;
    }

    public List<UserDetails> getUserService() {
        log.info("Fetching all users");
        return userrepo.findAll();
    }

    public UserDetails getUserById(int id) {
        log.info("Fetching user by Id {}",id);
        return userrepo.findById(id).get();
    }

    public RegistrationResponse createUserRegistration(RegistrationRequest createrequest) {
        log.info("Resgistration request {}",createrequest);

        if (userrepo.findByEmail(createrequest.getEmail()).isPresent()) {
            throw new RuntimeException ("User already exists with email: " + createrequest.getEmail());
        }

        UserDetails userDetails=UserDetails.builder()
                .name(createrequest.getName())
                .email((createrequest.getEmail()))
                .password(createrequest.getPassword())
                .phoneNumber(createrequest.getPhoneNumber())
                .build();



        userrepo.save(userDetails);
        return new RegistrationResponse(userDetails.getUserId(),"User Created");
    }

    public String updateUserRegistration(RegistrationUpdateRequest updaterequest) {
        log.warn("Registration update request {}", updaterequest);

        UserDetails userDetails=userrepo.findByName(updaterequest.getName());

        userDetails.setEmail(updaterequest.getEmail());
        userDetails.setName(updaterequest.getName());

        userrepo.save(userDetails);
        return "User updated";
    }

    public String deleteUserRegistration(String name) {
        log.error("Delete user {}", name);
        UserDetails userDetails = userrepo.findByName(name);
        userrepo.delete(userDetails);

        return "user Deleted";
    }
}
