<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/checkLogin.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 메인 - 대철이제철 게시판</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <style>
        .welcome-message {
            text-align: center;
            padding: 40px 20px;
            background: linear-gradient(135deg, #E8F8F0 0%, #F7F9FA 100%);
            border-radius: 12px;
            margin: 32px 0;
        }
        .welcome-message h3 {
            font-size: 24px;
            color: #03C75A;
            margin-bottom: 12px;
        }
        .welcome-message p {
            font-size: 16px;
            color: #666666;
        }
        .quick-menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 16px;
            margin: 32px 0;
        }
        .quick-menu a {
            padding: 24px;
            background-color: white;
            border: 2px solid #E5E5E5;
            border-radius: 8px;
            text-align: center;
            font-weight: 600;
            font-size: 15px;
            transition: all 0.2s ease;
        }
        .quick-menu a:hover {
            border-color: #03C75A;
            color: #03C75A;
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="welcome-message">
            <h3>환영합니다! 👋</h3>
            <p><strong><%= session.getAttribute("userName") %></strong>님, 좋은 하루 되세요!</p>
        </div>
        
        <h2>바로가기 메뉴</h2>
        <div class="quick-menu">
            <a href="<%= request.getContextPath() %>/BoardServlet?command=board_list">📋 게시판</a>
            <a href="<%= request.getContextPath() %>/member/memberUpdate.jsp">⚙️ 회원정보 수정</a>
            <a href="<%= request.getContextPath() %>/MemberServlet?command=logout">🚪 로그아웃</a>
        </div>
    </div>
</body>
</html>
