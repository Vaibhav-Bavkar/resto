package com.example.resto.repository;

import com.example.resto.entity.UserDetails;
import com.example.resto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_repo extends JpaRepository<UserDetails,Integer> {
}
