package com.example.codefellowship.Repos;

import com.example.codefellowship.Models.ApplicationUser;
import com.example.codefellowship.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllByUser(Optional<ApplicationUser> applicationUser);

}
