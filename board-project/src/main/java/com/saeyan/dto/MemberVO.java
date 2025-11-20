package com.saeyan.dto;

import java.sql.Timestamp;

/**
 * MemberVO - 회원 정보를 담는 Value Object
 */
public class MemberVO {
    private String id;
    private String password;
    private String name;
    private String email;
    private String role; // MEMBER 또는 ADMIN
    private String phone;
    private Timestamp regdate;

    // 기본 생성자
    public MemberVO() {
    }

    // Getter/Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "MemberVO [id=" + id + ", name=" + name + ", email=" + email +
                ", role=" + role + ", phone=" + phone + ", regdate=" + regdate + "]";
    }
}
