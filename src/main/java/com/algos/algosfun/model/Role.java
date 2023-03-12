package com.algos.algosfun.model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){return  this.description;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description){this.description = description;}
    public Role() {

    }

    public Role(Integer id) {
        this.id = id;
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
