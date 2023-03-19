package com.algos.algosfun.repositories;

import com.algos.algosfun.model.Role;
import com.algos.algosfun.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Test
    public void createFirstUser(){
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.getRoleByName("Admin"));
        User user = new User("Priyank","priyank@gmail.com","priyank_2k","priyank123",roleSet);
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
    }
}
