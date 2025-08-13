package com.example.resto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserDetails {
    @Id
    private int user_id;
    private String name;
    private String email;
    private String password;
    private double phone_num;
}
