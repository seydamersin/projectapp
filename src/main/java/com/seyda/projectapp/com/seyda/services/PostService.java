package com.seyda.projectapp.com.seyda.services;

import com.seyda.projectapp.com.seyda.entity.Post;
import com.seyda.projectapp.com.seyda.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
            return repository.findByUserId(userId.get());
        return repository.findAll();

    }

    public Post getOnePostById(Long postId) {
        return repository.findById(postId).orElse(null);
    }

    public Post crateOnePost(Post newPost) {
        return repository.save(newPost);
    }
}
