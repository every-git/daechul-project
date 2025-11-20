<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>회원정보 수정</h2>
        
        <form action="../MemberServlet?command=update" method="post">
            <!-- TODO: 회원정보 수정 폼 구현 -->
            <div class="form-group">
                <button type="submit">수정하기</button>
            </div>
        </form>
        
        <div class="links">
            <a href="main.jsp">돌아가기</a>
        </div>
    </div>
</body>
</html>
