package com.tel.services.User;


import com.tel.DTO.SignUpRequest;
import com.tel.DTO.UserDto;
import com.tel.Entity.User;
import com.tel.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired

    private UserRepo userRepo;



    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepo.findFirstByEmail(email) !=null;
    }

    @Transactional
    public UserDto createUser(SignUpRequest signUpRequest) throws Exception {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        user.setName(signUpRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        userRepo.save(user);
        if(user == null)
            return null;
        return user.mapUsertoUserDto();
    }
}
