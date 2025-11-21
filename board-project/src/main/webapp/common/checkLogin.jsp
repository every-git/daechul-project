<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 로그인 체크 공통 파일
    String userId = (String) session.getAttribute("userId");
    
    if (userId == null || userId.isEmpty()) {
        // 로그인되지 않은 경우 메인 화면으로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        return;
    }
%>
