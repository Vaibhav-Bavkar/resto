package com.example.resto.repository;

import com.example.resto.entity.RestaurantDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Restaurant_repo extends JpaRepository<RestaurantDetails,Integer> {
}
