package com.seyda.projectapp.services;

import com.seyda.projectapp.dto.requestdto.PostCreateRequestDto;
import com.seyda.projectapp.dto.requestdto.PostUpdateRequestDto;
import com.seyda.projectapp.entity.Post;
import com.seyda.projectapp.entity.User;
import com.seyda.projectapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository repository;
    private UserService userService;

    public PostService(PostRepository repository, UserService userService) {

        this.repository = repository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return repository.findByUserId(userId.get());
        return repository.findAll();

    }

    public Post getOnePostById(Long postId) {
        return repository.findById(postId).orElse(null);
    }

    public Post crateOnePost(PostCreateRequestDto newPostRequestDto) {
        User user = userService.getOneUserById(newPostRequestDto.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequestDto.getId());
        toSave.setText(newPostRequestDto.getText());
        toSave.setTitle(newPostRequestDto.getTitle());
        toSave.setUser(user);

        return repository.save(toSave);

    }

    public Post updateOnePost(Long postId, PostUpdateRequestDto postUpdateRequestDto) {
        Optional<Post> post = repository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(postUpdateRequestDto.getText());
            toUpdate.setTitle(postUpdateRequestDto.getTitle());
            repository.save(toUpdate);
            return toUpdate;
        }

        return null;

    }

    public void deleteOnePostById(Long postId) {
        repository.deleteById(postId);
    }
}
