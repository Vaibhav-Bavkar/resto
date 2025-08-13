package com.example.resto.repository;

import com.example.resto.entity.TableDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table_repo extends JpaRepository<TableDetails,Integer> {
}
