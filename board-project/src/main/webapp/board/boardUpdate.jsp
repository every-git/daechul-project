<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시글 수정</h2>
        
        <form action="../BoardServlet?command=board_update" method="post">
            <input type="hidden" name="seq" value="${board.seq}">
            
            <div class="form-group">
                <label>작성자:</label>
                <input type="text" name="writer" value="${board.writer}" readonly>
            </div>
            
            <div class="form-group">
                <label>제목:</label>
                <input type="text" name="title" value="${board.title}" required>
            </div>
            
            <div class="form-group">
                <label>내용:</label>
                <textarea name="content" rows="10" required>${board.content}</textarea>
            </div>
            
            <div class="form-group">
                <button type="submit">수정</button>
                <button type="button" onclick="history.back()">취소</button>
                <button type="button" onclick="location.href='../BoardServlet?command=board_list'">목록</button>
            </div>
        </form>
    </div>
</body>
</html>
