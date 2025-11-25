<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 로그인 체크 --%>
<%@ include file="../common/checkLogin.jsp" %>
<%
    // 세션에서 로그인 정보 가져오기
    String loginUserId = (String) session.getAttribute("userId");
    String loginUserName = (String) session.getAttribute("userName");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시글 작성</h2>
        
        <form action="<%= request.getContextPath() %>/BoardServlet?command=board_write" method="post">
            <%-- 작성자 정보 (세션에서 자동 설정) --%>
            <input type="hidden" name="writer" value="<%= loginUserId %>">
            
            <div class="form-group">
                <label>작성자</label>
                <span class="read-only"><%= loginUserName %></span>
            </div>
            
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" placeholder="제목을 입력하세요" required autofocus>
            </div>
            
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="content" rows="15" placeholder="내용을 입력하세요" required></textarea>
            </div>
            
            <div class="form-group">
                <button type="submit" onclick="location.href='BoardServlet?command=board_write'">등록</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
</body>
</html>
