package com.seyda.projectapp.com.seyda.controller;

import com.seyda.projectapp.com.seyda.services.LikeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;
    public LikeController(LikeService likeService){
        this.likeService=likeService;
    }

}
