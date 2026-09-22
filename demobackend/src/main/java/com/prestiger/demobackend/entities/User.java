package com.prestiger.demobackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long phone;
    public User() {
    }

    public User(Long id, String name, Long phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

}
