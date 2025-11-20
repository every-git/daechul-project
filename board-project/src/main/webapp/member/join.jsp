<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>회원가입</h2>
        
        <form action="../MemberServlet?command=join" method="post">
            <div class="form-group">
                <label>아이디:</label>
                <input type="text" name="id" id="id" required>
                <button type="button" onclick="checkIdDuplicate()">중복확인</button>
            </div>
            
            <div class="form-group">
                <label>비밀번호:</label>
                <input type="password" name="password" required>
            </div>
            
            <div class="form-group">
                <label>이름:</label>
                <input type="text" name="name" required>
            </div>
            
            <div class="form-group">
                <label>이메일:</label>
                <input type="email" name="email">
            </div>
            
            <div class="form-group">
                <label>전화번호:</label>
                <input type="text" name="phone">
            </div>
            
            <div class="form-group">
                <label>회원 유형:</label>
                <input type="radio" name="role" value="MEMBER" checked> 일반회원
                <input type="radio" name="role" value="ADMIN"> 관리자
            </div>
            
            <div class="form-group">
                <button type="submit">가입하기</button>
            </div>
        </form>
        
        <div class="links">
            <a href="../MemberServlet?command=login_form">로그인</a>
            <a href="../index.jsp">메인으로</a>
        </div>
    </div>
    
    <script src="../script/common.js"></script>
</body>
</html>
