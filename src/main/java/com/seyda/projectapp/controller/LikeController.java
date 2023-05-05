package com.seyda.projectapp.controller;

import com.seyda.projectapp.services.LikeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;
    public LikeController(LikeService likeService){
        this.likeService=likeService;
    }

}
