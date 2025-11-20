<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>로그인</h2>
        
        <form action="../MemberServlet?command=login" method="post">
            <div class="form-group">
                <label>아이디:</label>
                <input type="text" name="id" required>
            </div>
            
            <div class="form-group">
                <label>비밀번호:</label>
                <input type="password" name="password" required>
            </div>
            
            <div class="form-group">
                <button type="submit">로그인</button>
            </div>
        </form>
        
        <div class="links">
            <a href="../MemberServlet?command=join_form">회원가입</a>
            <a href="../index.jsp">메인으로</a>
        </div>
    </div>
</body>
</html>
