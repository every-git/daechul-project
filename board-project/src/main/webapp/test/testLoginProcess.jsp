<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 폼에서 받은 데이터로 세션 설정
    String userId = request.getParameter("userId");
    String userName = request.getParameter("userName");
    String userRole = request.getParameter("userRole");
    
    // 세션에 저장 (실제 로그인과 동일한 방식)
    session.setAttribute("userId", userId);
    session.setAttribute("userName", userName);
    session.setAttribute("userRole", userRole);
    
    // 권한에 따라 리다이렉션
    if("ADMIN".equals(userRole)) {
        response.sendRedirect("../admin/adminMain.jsp");
    } else {
        response.sendRedirect("../board/boardList.jsp");
    }
%>
