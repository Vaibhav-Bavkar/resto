package com.example.resto.service;

import com.example.resto.entity.UserDetails;
import com.example.resto.model.RegistrationRequest;
import com.example.resto.model.RegistrationUpdateRequest;
import com.example.resto.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private UserRepo userrepo;

    UserService(UserRepo userrepo){
        this.userrepo = userrepo;
    }

    public String createuserregistration(RegistrationRequest createrequest) {
        log.info("Resgistration request {}",createrequest);

//        UserDetails userDetails=new UserDetails();
//        userDetails.setName(createrequest.getName());
//        userDetails.setEmail(createrequest.getEmail());
//        userDetails.setPassword(createrequest.getPassword());
//        userDetails.setPhone_num(createrequest.getPhonenumber());

        UserDetails userDetails=UserDetails.builder()
                .name(createrequest.getName())
                .email((createrequest.getEmail()))
                .password(createrequest.getPassword())
                .phone_num(createrequest.getPhonenumber())
                .build();



        userrepo.save(userDetails);
        return "User Registered";
    }

    public String updateuserregistration(RegistrationUpdateRequest updaterequest) {
        log.warn("Registration update request {}", updaterequest);

        UserDetails userDetails=userrepo.findByName(updaterequest.getName());

        userDetails.setEmail(updaterequest.getEmail());
        userDetails.setName(updaterequest.getName());

        userrepo.save(userDetails);
        return "User updated";
    }

    public String deleteuserregistration(String name) {
        log.error("Delete user {}", name);
        UserDetails userDetails = userrepo.findByName(name);
        userrepo.delete(userDetails);

        return "user Deleted";
    }
}
