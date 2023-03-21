package com.tel.services.User;

import com.tel.DTO.SignUpRequest;
import com.tel.DTO.UserDto;

public interface UserService {

    Boolean hasUserWithEmail(String email);

    UserDto createUser(SignUpRequest signUpRequest) throws Exception;
}
