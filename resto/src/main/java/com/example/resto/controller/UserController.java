package com.example.resto.controller;

import com.example.resto.model.RegistrationRequest;
import com.example.resto.model.RegistrationUpdateRequest;
import com.example.resto.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/test")
    public ResponseEntity<String> getuserdetails(){
        return new ResponseEntity<>("This is a API response for user details", HttpStatus.OK);
    }

    @GetMapping("/test/{ownername}")
    public ResponseEntity<String> getuserdetailspath(@PathVariable(name="ownername") String name){
        return new ResponseEntity<>("This is a API response for user details from path for "+ name, HttpStatus.OK);
    }

    @GetMapping("/test/{ownername}/param")
    public ResponseEntity<String> getuserdetailsparam(@PathVariable(name="ownername") String name, @RequestParam("surname") String paramvalue){
        return new ResponseEntity<>("This is a API call for user details from param to " + name +" " + paramvalue, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createuserregistration(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<>(this.userService.createuserregistration(registrationRequest),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateuserregistration(@RequestBody RegistrationUpdateRequest registrationUpdateRequest){
        return new ResponseEntity<>(this.userService.updateuserregistration(registrationUpdateRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteuserregistration(@PathVariable String name){
        return new ResponseEntity<>(this.userService.deleteuserregistration(name),HttpStatus.OK);
    }



}
