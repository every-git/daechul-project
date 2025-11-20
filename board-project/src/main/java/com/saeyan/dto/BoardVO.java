package com.saeyan.dto;

import java.sql.Timestamp;

/**
 * BoardVO - 게시글 정보를 담는 Value Object
 */
public class BoardVO {
    private int seq;
    private String writer;
    private String title;
    private String content;
    private int hit;
    private Timestamp regdate;

    // 기본 생성자
    public BoardVO() {
    }

    // Getter/Setter
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "BoardVO [seq=" + seq + ", writer=" + writer + ", title=" + title +
                ", content=" + content + ", hit=" + hit + ", regdate=" + regdate + "]";
    }
}
