package com.seyda.projectapp.dto.requestdto;

import lombok.Data;

@Data
public class CommentCreateRequestDto {
    Long id;
    Long userId;
    Long postId;
    String text;

}
