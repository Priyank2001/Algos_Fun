package com.algos.algosfun.service;

import com.algos.algosfun.model.User;
import com.algos.algosfun.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUsers(){
        return (List<User>)userRepository.findAll();
    }

    public Boolean checkDuplicateUsernameExists(String username){
        User user = userRepository.getUserByUsername(username);
        return user != null;
    }
    public Boolean checkDuplicateEmailExists(String email){
        User user = userRepository.getUserByEmail(email);
        return user != null;
    }
    public ResponseEntity<User> createNewUser(User user){
        if(checkDuplicateEmailExists(user.getEmail()) || checkDuplicateUsernameExists(user.getUsername())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
