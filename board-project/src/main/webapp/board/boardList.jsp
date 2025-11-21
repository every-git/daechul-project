<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 로그인 체크 --%>
<%@ include file="../common/checkLogin.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시판</h2>
        
        <div class="board-header">
            <a href="${pageContext.request.contextPath}/BoardServlet?command=board_write_form">글쓰기</a>
        </div>
        
        <div class="board-list">
            <c:forEach var="board" items="${boardList}">
                <div class="board-item">
                    <div class="board-title">
                        <a href="${pageContext.request.contextPath}/BoardServlet?command=board_view&seq=${board.seq}">
                            ${board.title}
                        </a>
                    </div>
                    <div class="board-meta">
                        <span class="board-writer">${board.writer}</span>
                        <span class="board-separator">|</span>
                        <span class="board-date">
                            <fmt:formatDate value="${board.regdate}" pattern="yyyy.MM.dd HH:mm"/>
                        </span>
                        <span class="board-separator">|</span>
                        <span class="board-hit">조회 ${board.hit}</span>
                    </div>
                </div>
            </c:forEach>
            
            <c:if test="${empty boardList}">
                <div class="board-empty">
                    등록된 게시글이 없습니다.
                </div>
            </c:if>
        </div>
        
        <div class="links">
            <a href="${pageContext.request.contextPath}/member/main.jsp">메인으로</a>
            <a href="${pageContext.request.contextPath}/MemberServlet?command=logout">로그아웃</a>
        </div>
    </div>
</body>
</html>
