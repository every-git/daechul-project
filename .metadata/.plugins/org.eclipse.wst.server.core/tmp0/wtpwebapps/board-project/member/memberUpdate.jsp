<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 로그인 체크 --%>
<%@ include file="../common/checkLogin.jsp" %>
<%
    // checkLogin.jsp에서 이미 userId 선언됨
    String userName = (String) session.getAttribute("userName");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 수정 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>회원정보 수정</h2>
        
        <form action="<%= request.getContextPath() %>/MemberServlet?command=update" method="post">
            <div class="form-group">
                <label>아이디</label>
                <span class="read-only"><%= userId %></span>
            </div>
            
            <div class="form-group">
                <label>이름</label>
                <span class="read-only"><%= userName %></span>
            </div>
            
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="새 비밀번호를 입력하세요" required>
            </div>
            
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" placeholder="이메일을 입력하세요">
            </div>
            
            <div class="form-group">
                <label for="phone">전화번호</label>
                <input type="text" id="phone" name="phone" placeholder="전화번호를 입력하세요">
            </div>
            
            <div class="form-group">
                <button type="submit">수정하기</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
        
        <div class="links">
            <a href="<%= request.getContextPath() %>/member/main.jsp">돌아가기</a>
        </div>
    </div>
</body>
</html>
