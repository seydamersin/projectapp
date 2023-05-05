package com.seyda.projectapp.services;

import com.seyda.projectapp.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeRepository repository;

    public LikeService(LikeRepository repository) {
        this.repository = repository;
    }
}
