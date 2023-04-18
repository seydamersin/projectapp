package com.seyda.projectapp.com.seyda.controller;

import com.seyda.projectapp.com.seyda.entity.Post;
import com.seyda.projectapp.com.seyda.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostService postService;
    public PostController(PostService postService){
        this.postService=postService;
    }
    @GetMapping
    public List<Post>getAllPosts(@RequestParam Optional<Long>userId){
        return postService.getAllPosts(userId);

    }
    @PostMapping
    public Post createOnePost(@RequestBody Post newPost){
        return postService.crateOnePost(newPost);
    }
    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){
        return postService.getOnePostById(postId);
    }

}
