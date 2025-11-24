<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/checkAdmin.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 메인 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>⚙️ 관리자 페이지</h2>
        
        <div class="admin-menu">
            <h3>관리 메뉴</h3>
            <ul>
                <li><a href="<%= request.getContextPath() %>/AdminServlet?command=member_list">회원 관리</a></li>
                <li><a href="<%= request.getContextPath() %>/AdminServlet?command=board_manage_list">게시판 관리</a></li>
            </ul>
        </div>
        
        <div class="links">
            <a href="<%= request.getContextPath() %>/MemberServlet?command=logout">로그아웃</a>
        </div>
    </div>
</body>
</html>
