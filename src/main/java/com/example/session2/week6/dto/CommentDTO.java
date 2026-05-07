package com.example.session2.week6.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CommentDTO {
    private Long commentId;
    private String content;
    private String writer;
    private LocalDate commentDate;
    private Long boardId;
}
