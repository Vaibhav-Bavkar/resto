package com.example.resto.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_details")
public class UserDetails {
    @Id
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private int user_id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_num")
    private double phone_num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
