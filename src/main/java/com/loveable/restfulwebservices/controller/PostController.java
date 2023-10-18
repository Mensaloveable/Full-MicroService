package com.loveable.restfulwebservices.controller;

import com.loveable.restfulwebservices.models.Post;
import com.loveable.restfulwebservices.services.posts.PostServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostServices postServices;

    @PostMapping("/api/v1/post")
    public ResponseEntity<Post> create(@Valid @RequestBody Post post) {
        return ResponseEntity.ok(postServices.savePost(post));
    }

    @GetMapping("/api/v1/post")
    public ResponseEntity<Post> viewPost(@RequestParam Long postId) {
        return ResponseEntity.ok(postServices.getPost(postId));
    }

    @GetMapping("/api/v1/posts")
    public ResponseEntity<Page<Post>> viewInstancePosts(
            @RequestParam String instanceEmail,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int pageSize,
            @RequestParam(defaultValue = "id") String sortField
    ) {
        return ResponseEntity.ok(postServices.getInstancePosts(instanceEmail, page, pageSize, sortField));
    }

    @GetMapping("/api/v1/all-posts")
    public ResponseEntity<Page<Post>> viewAllPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int pageSize,
            @RequestParam(defaultValue = "id") String sortField
    ) {
        return ResponseEntity.ok(postServices.getAllPosts(page, pageSize, sortField));
    }
}
