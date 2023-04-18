package com.seyda.projectapp.com.seyda.repository;

import com.seyda.projectapp.com.seyda.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}