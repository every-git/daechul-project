<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>로그인</h2>
        
        <form action="<%= request.getContextPath() %>/MemberServlet?command=login" method="post">
            <div class="form-group">
                <label for="id">아이디</label>
                <input type="text" id="id" name="id" placeholder="아이디를 입력하세요" required autofocus>
            </div>
            
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호를 입력하세요" required>
            </div>
            
            <div class="form-group">
                <button type="submit">로그인</button>
            </div>
        </form>
        
        <div class="links">
            <a href="<%= request.getContextPath() %>/MemberServlet?command=join_form">회원가입</a>
            <a href="<%= request.getContextPath() %>/index.jsp">메인으로</a>
        </div>
    </div>
</body>
</html>
