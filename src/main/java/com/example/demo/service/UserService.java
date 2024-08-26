package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.TbUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder paasPasswordEncoder;

    public TbUser registerNewUser(RegisterRequest registerRequest) {
        TbUser user = new TbUser();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEnabled(true);
        user.setAuthString(registerRequest.getAuthor());

        return userRepository.save(user);


    }

}
