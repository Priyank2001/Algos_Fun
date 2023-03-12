package com.algos.algosfun.restcontrollers;

import com.algos.algosfun.model.Role;
import com.algos.algosfun.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@CrossOrigin
public class RoleRestController {
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping("/roles")
    public String getRoles(){
        Role role = roleRepository.findById(1).get();
        return role.toString();
    }
    @PostMapping(value = "/save_role",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Role> saveNewRole(@RequestBody Role role){
        try {
            Role saveRole = roleRepository.save(new Role(role.getName(), role.getDescription()));
            return new ResponseEntity<>(saveRole,HttpStatus.CREATED);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
        }

    }

}
