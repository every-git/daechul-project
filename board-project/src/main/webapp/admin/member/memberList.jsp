<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../common/checkAdmin.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 목록 - 관리자</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>👥 회원 목록 관리</h2>
        
        <table class="admin-table">
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>권한</th>
                    <th>가입일</th>
                    <th>관리</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${memberList}">
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>${member.role}</td>
                        <td>${member.regdate}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/AdminServlet?command=member_detail&amp;id=${member.id}">상세보기</a>
                            <c:if test="${member.id != sessionScope.userId}">
                                | <a href="${pageContext.request.contextPath}/AdminServlet?command=member_delete&amp;id=${member.id}" 
                                     onclick="return confirm('정말 ${member.name}(${member.id}) 회원을 강제 탈퇴시키겠습니까?\n\n이 작업은 되돌릴 수 없습니다.')"
                                     style="color: var(--red);">강제탈퇴</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <div class="links">
            <a href="${pageContext.request.contextPath}/AdminServlet?command=admin_main">관리자 메인</a>
        </div>
    </div>
</body>
</html>
