package com.algos.algosfun.restcontrollers;

import com.algos.algosfun.model.Role;
import com.algos.algosfun.model.User;
import com.algos.algosfun.repositories.RoleRepository;
import com.algos.algosfun.service.RoleService;
import com.algos.algosfun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleService roleService;

    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping(value="/users/save_user",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<User> createNewUser(@RequestBody User user){
        return userService.createNewUser(user);
    }

    @PostMapping(value = "/users/duplicate_email")
    public Boolean checkDuplicateEmail(@RequestParam String email){
        return userService.checkDuplicateEmailExists(email);
    }
    @PostMapping(value = "/users/duplicate_username")
    public Boolean checkDuplicateUsername(@RequestParam String username){
        return userService.checkDuplicateEmailExists(username);
    }

}
