package com.algos.algosfun.restcontrollers;

import com.algos.algosfun.model.Role;
import com.algos.algosfun.repositories.RoleRepository;
import com.algos.algosfun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RoleRestController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleRepository roleRepository;
    @GetMapping("/roles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }
    @PostMapping(value = "/save_role",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Role> saveNewRole(@RequestBody Role role){
        try {
            Role saveRole = roleRepository.save(new Role(role.getName(), role.getDescription()));
            return new ResponseEntity<>(saveRole, HttpStatus.CREATED);
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
        }

    }
}
