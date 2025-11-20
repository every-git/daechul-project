<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 프로젝트</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>게시판 프로젝트</h1>
        <h2>환영합니다!</h2>
        
        <div class="menu">
            <a href="MemberServlet?command=login_form">로그인</a>
            <a href="MemberServlet?command=join_form">회원가입</a>
            <a href="BoardServlet?command=board_list">게시판</a>
        </div>
    </div>
</body>
</html>
