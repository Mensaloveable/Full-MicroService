package com.loveable.restfulwebservices.repository;

import com.loveable.restfulwebservices.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p.* FROM Post p " +
            "JOIN Instance i ON p.instance_id = i.id " +
            "WHERE i.email = :email", nativeQuery = true)
    Page<Post> findInstancePosts(@Param("email") String instanceEmail, Pageable pageable);
}
