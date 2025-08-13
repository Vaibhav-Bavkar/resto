package com.example.resto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class TableDetails {
    @Id
    private int table_id;
    private int rest_id;
    private int seats;
}
