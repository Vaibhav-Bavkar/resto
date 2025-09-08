package com.example.resto.repository;

import com.example.resto.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails,Integer> {
    UserDetails findByName(String name);

    @Query(value = "Select u from user_details  u where u.email =:email",nativeQuery = true)
    Optional<Object> findByEmail(String email);
}
