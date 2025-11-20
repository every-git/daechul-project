<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="header">
        <div class="container">
            <h1><a href="<%= request.getContextPath() %>/index.jsp">게시판 프로젝트</a></h1>
            <div class="user-info">
                <%
                    String userId = (String) session.getAttribute("userId");
                    String userName = (String) session.getAttribute("userName");
                    String userRole = (String) session.getAttribute("userRole");
                    
                    if (userId != null) {
                %>
                    <span>
                        <%= userName %>님 
                        <% if ("ADMIN".equals(userRole)) { %>
                            <span class="badge-admin">[관리자]</span>
                        <% } %>
                    </span>
                    <a href="<%= request.getContextPath() %>/MemberServlet?command=logout">로그아웃</a>
                <%
                    } else {
                %>
                    <a href="<%= request.getContextPath() %>/MemberServlet?command=login_form">로그인</a>
                    <a href="<%= request.getContextPath() %>/MemberServlet?command=join_form">회원가입</a>
                <%
                    }
                %>
            </div>
        </div>
    </div>
    <nav class="navbar">
        <div class="container">
            <a href="<%= request.getContextPath() %>/index.jsp">홈</a>
            <a href="<%= request.getContextPath() %>/BoardServlet?command=board_list">게시판</a>
            <%
                if ("ADMIN".equals(userRole)) {
            %>
                <a href="<%= request.getContextPath() %>/AdminServlet?command=admin_main">관리자</a>
            <%
                }
            %>
        </div>
    </nav>
