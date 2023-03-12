package com.algos.algosfun.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name",length = 60)
    private String fullName;

    @Column(name = "email",nullable = false,length = 70)
    private String email;
    @Column(name = "username",nullable = false,length = 40)
    private String username;
    @Column(name = "password",nullable = false,length = 40)
    private String password;

    @ManyToMany
    @JoinTable(
            name="users_role",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roleSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public User(){

    }
    public User(String fullName, String email, String username, String password, Set<Role> roleSet) {
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleSet = roleSet;
    }
}
