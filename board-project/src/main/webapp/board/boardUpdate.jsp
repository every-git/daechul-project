<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 로그인 체크 --%>
<%@ include file="../common/checkLogin.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시글 수정</h2>
        
        <form action="<%= request.getContextPath() %>/BoardServlet?command=board_update" method="post">
            <input type="hidden" name="seq" value="${board.seq}">
            
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" value="${board.title}" placeholder="제목을 입력하세요" required autofocus>
            </div>
            
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="content" rows="15" placeholder="내용을 입력하세요" required>${board.content}</textarea>
            </div>
            
            <div class="form-group">
                <button type="submit"onclick="location.href='BoardServlet?command=board_update_form'">수정</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
</body>
</html>

