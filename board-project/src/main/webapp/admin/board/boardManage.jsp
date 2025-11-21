<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 관리</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시판 관리 (전체 게시글)</h2>
        
        <table class="admin-table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>관리</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.seq}</td>
                        <td>${board.title}</td>
                        <td>${board.writer}</td>
                        <td>${board.regdate}</td>
                        <td>${board.hit}</td>
                        <td>
                            <a href="../../BoardServlet?command=board_update_form&amp;seq=${board.seq}">수정</a>
                            <a href="../../AdminServlet?command=board_manage_delete&amp;seq=${board.seq}" 
                               onclick="return confirm('삭제하시겠습니까?')">삭제</a>
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
