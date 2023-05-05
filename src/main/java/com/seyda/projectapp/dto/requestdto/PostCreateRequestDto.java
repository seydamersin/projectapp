package com.seyda.projectapp.dto.requestdto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostCreateRequestDto {


    Long id;
    String text;
    String title;
    Long userId;
}
