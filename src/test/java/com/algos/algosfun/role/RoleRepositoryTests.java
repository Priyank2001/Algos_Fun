package com.algos.algosfun.role;

import com.algos.algosfun.model.Role;
import com.algos.algosfun.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTests {
    static String VIEW_ARTICLES = "View Articles";
    static String EDIT_ARTICLES = "Edit Articles";
    static String POST_COMMENTS = "Post comments";
    static String BROADCAST_MESSAGE = "Broadcast Announcements and Messages";
    static String MANAGE_USERS = "Manage other users";
    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void testCreateFirstRole(){
        ArrayList<String> adminResponsibilities = new ArrayList<>();
        /**
         * Admin Responsibilities
         */
        adminResponsibilities.add(VIEW_ARTICLES);
        adminResponsibilities.add(EDIT_ARTICLES);
        adminResponsibilities.add(POST_COMMENTS);
        adminResponsibilities.add(BROADCAST_MESSAGE);
        adminResponsibilities.add(MANAGE_USERS);
        Role adminrole = new Role();
        adminrole.setName("Admin");
        adminrole.setDescription(adminResponsibilities.toString());
        Role savedRole = roleRepo.save(adminrole);
        System.out.println(savedRole.toString());
        assertThat(savedRole.getId()).isGreaterThan(0);
    }
}
