<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시판</h2>
        
        <div class="board-header">
            <a href="../BoardServlet?command=board_write_form">글쓰기</a>
        </div>
        
        <table class="board-table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${boardList}">
                    <tr>
                        <td>${board.seq}</td>
                        <td>
                            <a href="../BoardServlet?command=board_view&seq=${board.seq}">
                                ${board.title}
                            </a>
                        </td>
                        <td>${board.writer}</td>
                        <td>${board.regdate}</td>
                        <td>${board.hit}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="links">
            <a href="../member/main.jsp">메인으로</a>
            <a href="../MemberServlet?command=logout">로그아웃</a>
        </div>
    </div>
</body>
</html>
