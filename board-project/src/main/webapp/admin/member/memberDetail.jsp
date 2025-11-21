<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../common/checkAdmin.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세 정보 - 관리자</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>👤 회원 상세 정보</h2>
        
        <div class="member-detail">
            <div class="view-row">
                <label>아이디:</label>
                <span>${member.id}</span>
            </div>
            
            <div class="view-row">
                <label>이름:</label>
                <span>${member.name}</span>
            </div>
            
            <div class="view-row">
                <label>이메일:</label>
                <span>${member.email}</span>
            </div>
            
            <div class="view-row">
                <label>전화번호:</label>
                <span>${member.phone}</span>
            </div>
            
            <div class="view-row">
                <label>권한:</label>
                <span>${member.role}</span>
            </div>
            
            <div class="view-row">
                <label>가입일:</label>
                <span>${member.regdate}</span>
            </div>
        </div>
        
        <div class="button-group">
            <c:if test="${member.id != sessionScope.userId}">
                <a href="${pageContext.request.contextPath}/AdminServlet?command=member_delete&amp;id=${member.id}" 
                   onclick="return confirm('정말 ${member.name}(${member.id}) 회원을 강제 탈퇴시키겠습니까?\n\n이 작업은 되돌릴 수 없습니다.')"
                   style="background: linear-gradient(135deg, var(--red) 0%, #dc2626 100%);">강제탈퇴</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/AdminServlet?command=member_list">목록</a>
            <a href="${pageContext.request.contextPath}/AdminServlet?command=admin_main">관리자 메인</a>
        </div>
    </div>
</body>
</html>
