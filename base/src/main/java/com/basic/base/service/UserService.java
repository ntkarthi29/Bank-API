package com.basic.base.service;

import com.basic.base.model.User;
import com.basic.base.repository.UserRepository;
import com.basic.base.enums.AccountType;
import com.basic.base.enums.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;

    public User registerUser(String userName, String email, String password, Gender gender, String phoneNumber, AccountType accType) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setPhoneNumber(phoneNumber);
        user.setAccountType(accType);
        return UserRepository.save(user);
    }

    public User LoginUser(String username,String password) {
        User user = UserRepository.findByUserName(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
