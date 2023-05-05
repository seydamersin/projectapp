package com.seyda.projectapp.controller;

import com.seyda.projectapp.dto.requestdto.CommentCreateRequestDto;
import com.seyda.projectapp.dto.requestdto.CommentUpdateRequestDto;
import com.seyda.projectapp.entity.Comment;
import com.seyda.projectapp.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParam(userId, postId);
    }

    @GetMapping("/{commentid}")
    public Comment getOneComment(@PathVariable Long commentId) {
        return commentService.getOneCommentById(commentId);
    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequestDto commentCreateRequestDto) {
        return commentService.createOneComment(commentCreateRequestDto);
    }

    @PutMapping("/{commentıd}")
    public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
        return commentService.updateCommentById(commentId, requestDto);
    }
    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId){
       commentService.deleteOneCommentById(commentId);
    }

}
