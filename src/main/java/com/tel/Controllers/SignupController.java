package com.tel.Controllers;

import com.tel.DTO.SignUpRequest;
import com.tel.DTO.UserDto;
import com.tel.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SignupController {

    @Autowired
    UserService userService;
    

    @PostMapping({"/sign-up"})
    public ResponseEntity<?> signupUser(@RequestBody(required = true)@Valid SignUpRequest signupRequest) throws Exception{

        if (userService.hasUserWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);

        UserDto createdUser = userService.createUser(signupRequest);
        if(createdUser == null)
            return new ResponseEntity<>("User not created , Try agian", HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }


}
