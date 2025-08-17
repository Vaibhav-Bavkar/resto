package com.example.resto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="table_details")
public class TableDetails {
    @Id
    private int table_id;
    @Column(name = "rest_id")
    private int rest_id;
    @Column(name = "seats")
    private int seats;
}
