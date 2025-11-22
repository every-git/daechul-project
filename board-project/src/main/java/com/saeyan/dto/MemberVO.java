package com.saeyan.dto;

import java.sql.Timestamp;

/**
 * MemberVO - 회원 정보를 담는 Value Object (데이터 전송 객체)
 * 
 * 역할:
 * - 데이터베이스의 members 테이블과 매핑되는 객체
 * - 회원 정보를 담아 계층 간 데이터 전달에 사용
 * - DAO와 Action, JSP 간 데이터 전달의 중간 역할
 * 
 * 설계 패턴: Value Object (VO) / Data Transfer Object (DTO)
 */
public class MemberVO {
    /** 회원 아이디 (Primary Key) */
    private String id;
    
    /** 회원 비밀번호 (암호화되지 않은 평문) */
    private String password;
    
    /** 회원 이름 */
    private String name;
    
    /** 회원 이메일 */
    private String email;
    
    /** 회원 권한 (MEMBER: 일반회원, ADMIN: 관리자) */
    private String role;
    
    /** 회원 전화번호 */
    private String phone;
    
    /** 회원 가입일시 (자동 생성) */
    private Timestamp regdate;

    /**
     * 기본 생성자
     * - 모든 필드를 기본값으로 초기화
     */
    public MemberVO() {
    }

    /**
     * 회원 아이디 조회
     * @return 회원 아이디
     */
    public String getId() {
        return id;
    }

    /**
     * 회원 아이디 설정
     * @param id 회원 아이디
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 비밀번호 조회
     * @return 비밀번호
     */
    public String getPassword() {
        return password;
    }

    /**
     * 비밀번호 설정
     * @param password 비밀번호
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 회원 이름 조회
     * @return 회원 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 회원 이름 설정
     * @param name 회원 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 이메일 조회
     * @return 이메일
     */
    public String getEmail() {
        return email;
    }

    /**
     * 이메일 설정
     * @param email 이메일
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 회원 권한 조회
     * @return 회원 권한 (MEMBER 또는 ADMIN)
     */
    public String getRole() {
        return role;
    }

    /**
     * 회원 권한 설정
     * @param role 회원 권한 (MEMBER: 일반회원, ADMIN: 관리자)
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 전화번호 조회
     * @return 전화번호
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 전화번호 설정
     * @param phone 전화번호
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 가입일시 조회
     * @return 가입일시 (Timestamp 객체)
     */
    public Timestamp getRegdate() {
        return regdate;
    }

    /**
     * 가입일시 설정
     * @param regdate 가입일시 (Timestamp 객체)
     */
    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "MemberVO [id=" + id + ", name=" + name + ", email=" + email +
                ", role=" + role + ", phone=" + phone + ", regdate=" + regdate + "]";
    }
}
