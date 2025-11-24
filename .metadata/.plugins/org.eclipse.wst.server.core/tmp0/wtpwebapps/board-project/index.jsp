<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>대철이제철 게시판 프로젝트</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <style>
        .welcome-container {
            text-align: center;
            padding: 60px 20px;
        }
        .welcome-title {
            font-size: 36px;
            font-weight: 700;
            color: #03C75A;
            margin-bottom: 16px;
        }
        .welcome-subtitle {
            font-size: 20px;
            color: #666666;
            margin-bottom: 48px;
        }
        .feature-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 24px;
            margin: 48px 0;
        }
        .feature-card {
            padding: 32px 24px;
            background-color: #F7F9FA;
            border-radius: 12px;
            transition: all 0.2s ease;
        }
        .feature-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
        }
        .feature-icon {
            font-size: 48px;
            margin-bottom: 16px;
        }
        .feature-title {
            font-size: 18px;
            font-weight: 600;
            color: #222222;
            margin-bottom: 8px;
        }
        .feature-desc {
            font-size: 14px;
            color: #666666;
            line-height: 1.6;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="welcome-container">
            <h1 class="welcome-title">대철이제철 게시판 프로젝트</h1>
            <p class="welcome-subtitle">환영합니다! 네이버 스타일의 모던한 게시판입니다.</p>
            
            <div class="feature-grid">
                <div class="feature-card">
                    <div class="feature-icon">✍️</div>
                    <div class="feature-title">자유로운 글쓰기</div>
                    <div class="feature-desc">누구나 쉽게 게시글을 작성하고 공유할 수 있습니다.</div>
                </div>
                <div class="feature-card">
                    <div class="feature-icon">👥</div>
                    <div class="feature-title">회원 관리</div>
                    <div class="feature-desc">안전한 회원가입과 로그인 시스템을 제공합니다.</div>
                </div>
                <div class="feature-card">
                    <div class="feature-icon">🔒</div>
                    <div class="feature-title">관리자 기능</div>
                    <div class="feature-desc">체계적인 게시판 및 회원 관리가 가능합니다.</div>
                </div>
            </div>
            
            <div class="menu">
                <a href="<%= request.getContextPath() %>/MemberServlet?command=login_form" style="background-color: #03C75A; color: white; border: none;">로그인</a>
                <a href="<%= request.getContextPath() %>/MemberServlet?command=join_form">회원가입</a>
                <a href="<%= request.getContextPath() %>/BoardServlet?command=board_list">게시판</a>
            </div>
        </div>
    </div>
</body>
</html>
