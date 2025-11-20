<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 관리자 권한 체크 공통 파일
    String userId = (String) session.getAttribute("userId");
    String userRole = (String) session.getAttribute("userRole");
    
    if (userId == null || userId.isEmpty()) {
        // 로그인되지 않은 경우
        response.sendRedirect(request.getContextPath() + "/member/login.jsp");
        return;
    }
    
    if (!"ADMIN".equals(userRole)) {
        // 관리자가 아닌 경우
        out.println("<script>");
        out.println("alert('관리자만 접근 가능합니다.');");
        out.println("location.href='" + request.getContextPath() + "/index.jsp';");
        out.println("</script>");
        return;
    }
%>
