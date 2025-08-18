package com.example.resto.service;

import com.example.resto.repository.TableRepo;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    private TableRepo tableRepo;

    TableService(TableRepo tableRepo){
        this.tableRepo = tableRepo;
    }
}
