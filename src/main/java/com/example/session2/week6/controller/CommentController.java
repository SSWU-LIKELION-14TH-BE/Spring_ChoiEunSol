package com.example.session2.week6.controller;

import com.example.session2.week6.dto.CommentDTO;
import com.example.session2.week6.entity.Comment;
import com.example.session2.week6.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 조회
    @GetMapping("/getComment")
    public Optional<Comment> getComment(
            @RequestParam(name = "commentId") Long commentId) {

        return commentService.getComment(commentId);
    }

    // 댓글 작성
    @PostMapping("/postComment")
    public void postComment(@RequestBody CommentDTO commentDTO) {
        commentService.postComment(commentDTO);
    }

    // 댓글 수정
    @PutMapping("/putComment")
    public void putComment(@RequestBody CommentDTO commentDTO) {

        commentService.putComment(commentDTO);
    }

    // 댓글 삭제
    @DeleteMapping("/deleteComment/{commentId}")
    public void deleteComment(
            @PathVariable(name = "commentId") Long commentId) {

        commentService.deleteComment(commentId);
    }
}
