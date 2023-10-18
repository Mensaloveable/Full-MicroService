package com.loveable.restfulwebservices.services.posts;

import com.loveable.restfulwebservices.models.Post;
import org.springframework.data.domain.Page;

public interface PostServices {

    Post savePost(Post post);

    Post getPost(Long id);

    Page<Post> getInstancePosts(String instanceEmail, Integer page, Integer pagesize, String sortField);

    Page<Post> getAllPosts(Integer page, Integer pagesize, String sortField);
}
