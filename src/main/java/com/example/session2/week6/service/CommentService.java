package com.example.session2.week6.service;

import com.example.session2.week6.dto.CommentDTO;
import com.example.session2.week6.entity.Board;
import com.example.session2.week6.entity.Comment;
import com.example.session2.week6.repository.BoardRepository;
import com.example.session2.week6.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 조회
    public Optional<Comment> getComment(Long commentId) {
        return commentRepository.findById(commentId);
    }

    // 댓글 작성
    public void postComment(CommentDTO commentDTO) {

        Board board = boardRepository.findById(commentDTO.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        Comment comment = Comment.builder()
                .content(commentDTO.getContent())
                .writer(commentDTO.getWriter())
                .board(board)
                .build();

        commentRepository.save(comment);
    }

    // 댓글 수정
    @Transactional
    public void putComment(CommentDTO commentDTO) {
        Board board = boardRepository.findById(commentDTO.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));

        Comment comment = Comment.builder()
                .commentId(commentDTO.getCommentId())
                .content(commentDTO.getContent())
                .writer(commentDTO.getWriter())
                .commentDate(LocalDate.now())
                .board(board)
                .build();

        commentRepository.save(comment);
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
