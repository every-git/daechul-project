<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 목록</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
    <div class="container">
        <h2>회원 목록</h2>
        
        <table class="admin-table">
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>권한</th>
                    <th>가입일</th>
                    <th>상세</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${memberList}">
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>${member.role}</td>
                        <td>${member.regdate}</td>
                        <td>
                            <a href="../../AdminServlet?command=member_detail&amp;id=${member.id}">상세보기</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="links">
            <a href="../adminMain.jsp">관리자 메인</a>
        </div>
    </div>
</body>
</html>
