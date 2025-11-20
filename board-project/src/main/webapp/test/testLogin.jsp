<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>임시 로그인 (개발용)</title>
    <link rel="stylesheet" href="../css/style.css">
    <style>
        .warning {
            background: #fff3cd;
            padding: 15px;
            border-left: 4px solid #ffc107;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .dev-button {
            padding: 15px 30px;
            margin: 10px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            color: white;
        }
        .member-btn { background-color: #28a745; }
        .member-btn:hover { background-color: #218838; }
        .admin-btn { background-color: #dc3545; }
        .admin-btn:hover { background-color: #c82333; }
        .session-info {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="warning">
            <strong>⚠️ 개발 전용 페이지</strong><br>
            이 페이지는 로그인 기능이 완성되기 전까지만 사용하는 임시 페이지입니다.<br>
            실제 배포 시 반드시 삭제해야 합니다!
        </div>
        
        <h2>임시 로그인 (개발 테스트용)</h2>
        <p>아래 버튼을 클릭하여 원하는 권한으로 세션을 설정하세요:</p>
        
        <!-- 일반 회원으로 로그인 -->
        <form action="testLoginProcess.jsp" method="post" style="display: inline;">
            <input type="hidden" name="userId" value="user1">
            <input type="hidden" name="userName" value="홍길동">
            <input type="hidden" name="userRole" value="MEMBER">
            <button type="submit" class="dev-button member-btn">일반 회원으로 시작</button>
        </form>
        
        <!-- 관리자로 로그인 -->
        <form action="testLoginProcess.jsp" method="post" style="display: inline;">
            <input type="hidden" name="userId" value="admin">
            <input type="hidden" name="userName" value="관리자">
            <input type="hidden" name="userRole" value="ADMIN">
            <button type="submit" class="dev-button admin-btn">관리자로 시작</button>
        </form>
        
        <div class="session-info">
            <h3>현재 세션 정보</h3>
            <ul>
                <li><strong>userId:</strong> <%= session.getAttribute("userId") %></li>
                <li><strong>userName:</strong> <%= session.getAttribute("userName") %></li>
                <li><strong>userRole:</strong> <%= session.getAttribute("userRole") %></li>
            </ul>
        </div>
        
        <div class="links" style="margin-top: 30px;">
            <a href="../index.jsp">메인으로</a>
            <a href="../BoardServlet?command=board_list">게시판</a>
            <a href="../AdminServlet?command=admin_main">관리자</a>
        </div>
    </div>
</body>
</html>
