package com.loveable.restfulwebservices.services.posts;

import com.loveable.restfulwebservices.exception.PostNotFoundException;
import com.loveable.restfulwebservices.models.Post;
import com.loveable.restfulwebservices.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServicesImpl implements PostServices {

    private final PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isEmpty()) {
            throw new PostNotFoundException("Post not found");
        }

        return optionalPost.get();
    }

    @Override
    public Page<Post> getInstancePosts(String instanceEmail, Integer page, Integer pagesize, String sortField) {

        Pageable pageable = PageRequest.of(page, pagesize, Sort.by(Sort.Order.desc(sortField)));

        return postRepository.findInstancePosts(instanceEmail, pageable);
    }

    @Override
    public Page<Post> getAllPosts(Integer page, Integer pagesize, String sortField) {

        Pageable pageable = PageRequest.of(page, pagesize, Sort.by(Sort.Order.desc(sortField)));

        return postRepository.findAll(pageable);
    }
}
