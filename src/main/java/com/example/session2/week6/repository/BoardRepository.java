package com.example.session2.week6.repository;

import com.example.session2.week6.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // jpa Repository 상속 받아서 정의된 함수
    // 게시글 가져오기 read(=GET)
    Optional<Board> findByBoardId(Long boardId);
    // 게시글 작성하기 create(=POST)
    // void save(); // 이건 명명하지 않고 바로 적어도 자동 지원됨
    // 게시글 삭제하기 delete(=DELETE)
    void deleteByBoardId(Long boardId);
}
