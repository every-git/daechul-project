package com.saeyan.dto;

import java.sql.Timestamp;

/**
 * BoardVO - 게시글 정보를 담는 Value Object (데이터 전송 객체)
 * 
 * 역할:
 * - 데이터베이스의 board 테이블과 매핑되는 객체
 * - 게시글 정보를 담아 계층 간 데이터 전달에 사용
 * - DAO와 Action, JSP 간 데이터 전달의 중간 역할
 * 
 * 설계 패턴: Value Object (VO) / Data Transfer Object (DTO)
 */
public class BoardVO {
    /** 게시글 번호 (Primary Key, AUTO_INCREMENT) */
    private int seq;
    
    /** 게시글 작성자 아이디 */
    private String writer;
    
    /** 게시글 제목 */
    private String title;
    
    /** 게시글 내용 */
    private String content;
    
    /** 게시글 조회수 (기본값: 0) */
    private int hit;
    
    /** 게시글 작성일시 (자동 생성) */
    private Timestamp regdate;

    /**
     * 기본 생성자
     * - 모든 필드를 기본값으로 초기화
     */
    public BoardVO() {
    }

    /**
     * 게시글 번호 조회
     * @return 게시글 번호
     */
    public int getSeq() {
        return seq;
    }

    /**
     * 게시글 번호 설정
     * @param seq 게시글 번호
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * 작성자 아이디 조회
     * @return 작성자 아이디
     */
    public String getWriter() {
        return writer;
    }

    /**
     * 작성자 아이디 설정
     * @param writer 작성자 아이디
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * 게시글 제목 조회
     * @return 게시글 제목
     */
    public String getTitle() {
        return title;
    }

    /**
     * 게시글 제목 설정
     * @param title 게시글 제목
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 게시글 내용 조회
     * @return 게시글 내용
     */
    public String getContent() {
        return content;
    }

    /**
     * 게시글 내용 설정
     * @param content 게시글 내용
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 조회수 조회
     * @return 조회수
     */
    public int getHit() {
        return hit;
    }

    /**
     * 조회수 설정
     * @param hit 조회수
     */
    public void setHit(int hit) {
        this.hit = hit;
    }

    /**
     * 작성일시 조회
     * @return 작성일시 (Timestamp 객체)
     */
    public Timestamp getRegdate() {
        return regdate;
    }

    /**
     * 작성일시 설정
     * @param regdate 작성일시 (Timestamp 객체)
     */
    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "BoardVO [seq=" + seq + ", writer=" + writer + ", title=" + title +
                ", content=" + content + ", hit=" + hit + ", regdate=" + regdate + "]";
    }
}
