<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시글 상세보기</h2>
        
        <div class="board-view">
            <div class="view-row">
                <label>제목:</label>
                <span>${board.title}</span>
            </div>
            
            <div class="view-row">
                <label>작성자:</label>
                <span>${board.writer}</span>
            </div>
            
            <div class="view-row">
                <label>작성일:</label>
                <span>${board.regdate}</span>
            </div>
            
            <div class="view-row">
                <label>조회수:</label>
                <span>${board.hit}</span>
            </div>
            
            <div class="view-content">
                <label>내용:</label>
                <pre>${board.content}</pre>
            </div>
        </div>
        
        <div class="button-group">
            <c:if test="${sessionScope.userId == board.writer || sessionScope.userRole == 'ADMIN'}">
                <a href="../BoardServlet?command=board_update_form&amp;seq=${board.seq}">수정</a>
                <a href="../BoardServlet?command=board_delete&amp;seq=${board.seq}" 
                   onclick="return confirm('삭제하시겠습니까?')">삭제</a>
            </c:if>
            <a href="../BoardServlet?command=board_list">목록</a>
        </div>
    </div>
</body>
</html>
