<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>관리자 메인</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>관리자 페이지</h2>
        
        <div class="admin-menu">
            <h3>관리 메뉴</h3>
            <ul>
                <li><a href="../AdminServlet?command=member_list">회원 관리</a></li>
                <li><a href="../AdminServlet?command=board_manage_list">게시판 관리</a></li>
            </ul>
        </div>
        
        <div class="links">
            <a href="../MemberServlet?command=logout">로그아웃</a>
        </div>
    </div>
</body>
</html>
