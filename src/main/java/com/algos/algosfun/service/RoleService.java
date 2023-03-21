package com.algos.algosfun.service;

import com.algos.algosfun.model.Role;
import com.algos.algosfun.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles(){
        List<Role> list = (List<Role>)roleRepository.findAll();
        return list;
    }
    public Role getRoleByName(String name){
        return roleRepository.getRoleByName(name);
    }
}
