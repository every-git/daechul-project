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
    <title>게시글 상세보기 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container">
        <div class="board-view-header">
            <h2>게시글 상세보기</h2>
        </div>
        
        <div class="board-view">
            <!-- 게시글 제목 -->
            <div class="board-view-title">
                ${board.title}
            </div>
            
            <!-- 메타 정보 -->
            <div class="board-view-meta">
                <div class="meta-item">
                    <span class="icon">👤</span>
                    <label>작성자</label>
                    <span>${board.writer}</span>
                </div>
                
                <div class="meta-item">
                    <span class="icon">📅</span>
                    <label>작성일</label>
                    <span>
                        <fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </span>
                </div>
                
                <div class="meta-item">
                    <span class="icon">👁️</span>
                    <label>조회수</label>
                    <span>${board.hit}</span>
                </div>
            </div>
            
            <!-- 게시글 내용 -->
            <div class="board-content-wrapper">
                <div class="board-content">${board.content}</div>
            </div>
        </div>
        
        <!-- 액션 버튼 -->
        <div class="action-buttons">
            <c:if test="${sessionScope.userId == board.writer}">
                <!-- 작성자만 수정 가능 -->
                <a href="${pageContext.request.contextPath}/BoardServlet?command=board_update_form&amp;seq=${board.seq}" 
                   class="btn-edit">수정</a>
            </c:if>
            <c:if test="${sessionScope.userId == board.writer || sessionScope.userRole == 'ADMIN' || sessionScope.userRole == 'admin'}">
                <!-- 작성자 또는 관리자는 삭제 가능 -->
                <a href="${pageContext.request.contextPath}/BoardServlet?command=board_delete&amp;seq=${board.seq}" 
                   class="btn-delete"
                   onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
            </c:if>
            <a href="${pageContext.request.contextPath}/BoardServlet?command=board_list" class="btn-list">목록으로</a>
        </div>
    </div>
</body>
</html>
