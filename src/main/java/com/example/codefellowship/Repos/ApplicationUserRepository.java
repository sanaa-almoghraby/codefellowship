package com.example.codefellowship.Repos;

import com.example.codefellowship.Models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Integer> {
     ApplicationUser findByUsername(String username);
}
