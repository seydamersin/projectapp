package com.seyda.projectapp.services;

import com.seyda.projectapp.dto.requestdto.CommentCreateRequestDto;
import com.seyda.projectapp.dto.requestdto.CommentUpdateRequestDto;
import com.seyda.projectapp.entity.Comment;
import com.seyda.projectapp.entity.Post;
import com.seyda.projectapp.entity.User;
import com.seyda.projectapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {

        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());

        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());

        } else
            return commentRepository.findAll();

    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }



/*
    public Comment createOneComment(CommentCreateRequestDto commentCreateRequestDto) {
        User user = userService.getOneUserById(commentCreateRequestDto.getUserId());
        Post post = postService.getOnePostById(commentCreateRequestDto.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = Comment.builder()
                    .id(commentCreateRequestDto.getId())
                    .text(commentCreateRequestDto.getText())
                    .post(post)
                    .user(user)
                    .build();
            commentRepository.save(commentToSave);
        }
        return null;

    }

 */

    public Comment createOneComment(CommentCreateRequestDto commentCreateRequestDto) {
        User user = userService.getOneUserById(commentCreateRequestDto.getUserId());
        Post post = postService.getOnePostById(commentCreateRequestDto.getPostId());
        if (user != null && post != null) {
            Comment commentToSave = new Comment();
            commentToSave.setId(commentCreateRequestDto.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setText(commentCreateRequestDto.getText());
            return commentRepository.save(commentToSave);

        } else
            return null;

    }

    public Comment updateCommentById(Long commentId, CommentUpdateRequestDto requestDto) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            Comment commentToUpdate=comment.get();
            commentToUpdate.setText(requestDto.getText());
            return commentRepository.save(commentToUpdate);
        } else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
