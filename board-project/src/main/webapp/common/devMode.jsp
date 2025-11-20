<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
    // 개발 모드 설정 (로그인 완성 후 false로 변경)
    public static final boolean DEV_MODE = true;
    
    // 개발용 더미 세션 정보
    public static final String DEV_USER_ID = "user1";
    public static final String DEV_USER_NAME = "홍길동";
    public static final String DEV_USER_ROLE = "MEMBER";  // 또는 "ADMIN"
%>

<%
    String userId, userName, userRole;
    
    if(DEV_MODE) {
        // 개발 모드: 더미 데이터 사용
        userId = DEV_USER_ID;
        userName = DEV_USER_NAME;
        userRole = DEV_USER_ROLE;
        
        // 개발 편의를 위해 세션에도 설정
        session.setAttribute("userId", userId);
        session.setAttribute("userName", userName);
        session.setAttribute("userRole", userRole);
    } else {
        // 실제 모드: 세션에서 가져오기
        userId = (String) session.getAttribute("userId");
        userName = (String) session.getAttribute("userName");
        userRole = (String) session.getAttribute("userRole");
        
        // 로그인 체크
        if(userId == null) {
            response.sendRedirect(request.getContextPath() + "/member/login.jsp");
            return;
        }
    }
%>
