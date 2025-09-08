package com.example.resto.controller;

import com.example.resto.entity.UserDetails;
import com.example.resto.model.RegistrationRequest;
import com.example.resto.model.RegistrationResponse;
import com.example.resto.model.RegistrationUpdateRequest;
import com.example.resto.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/get")
    public List<UserDetails> getUserDetails(){
        return userService.getUserService();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDetails> getUserDetailsPath(@PathVariable(name="id") int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/get/{ownername}/param")
    public ResponseEntity<String> getUserDetailsParam(@PathVariable(name="ownername") String name, @RequestParam("surname") String paramvalue){
        return new ResponseEntity<>("This is a API call for user details from param to " + name +" " + paramvalue, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<RegistrationResponse> createUserRegistration(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<>(this.userService.createUserRegistration(registrationRequest),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUserRegistration(@RequestBody RegistrationUpdateRequest registrationUpdateRequest){
        return new ResponseEntity<>(this.userService.updateUserRegistration(registrationUpdateRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteUserRegistration(@PathVariable String name){
        return new ResponseEntity<>(this.userService.deleteUserRegistration(name),HttpStatus.OK);
    }



}
