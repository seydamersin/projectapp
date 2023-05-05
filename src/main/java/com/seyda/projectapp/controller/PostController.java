package com.seyda.projectapp.controller;

import com.seyda.projectapp.dto.requestdto.PostCreateRequestDto;
import com.seyda.projectapp.dto.requestdto.PostUpdateRequestDto;
import com.seyda.projectapp.entity.Post;
import com.seyda.projectapp.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);

    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequestDto newPostRequestDto) {
        return postService.crateOnePost(newPostRequestDto);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId , @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.updateOnePost(postId, postUpdateRequestDto);
    }
        @DeleteMapping("/{postId}")
        public void deleteOnePost (@PathVariable Long postId){
            postService.deleteOnePostById(postId);

    }
}
