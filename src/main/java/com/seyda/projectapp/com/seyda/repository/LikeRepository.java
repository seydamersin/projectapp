package com.seyda.projectapp.com.seyda.repository;

import com.seyda.projectapp.com.seyda.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
