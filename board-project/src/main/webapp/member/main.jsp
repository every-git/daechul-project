<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 메인</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>회원 메인 페이지</h2>
        <p>환영합니다, <%= session.getAttribute("userName") %>님!</p>
        
        <div class="menu">
            <a href="../BoardServlet?command=board_list">게시판</a>
            <a href="../MemberServlet?command=update">회원정보 수정</a>
            <a href="../MemberServlet?command=logout">로그아웃</a>
        </div>
    </div>
</body>
</html>
