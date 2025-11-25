<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>대철이제철 게시판 프로젝트</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body, html {
            width: 100%;
            height: 100%;
            overflow: hidden;
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
        }
        
        .landing-container {
            position: relative;
            width: 100%;
            height: 100vh;
            background-color: #F0EDE8;
        }
        
        /* Background Image */
        .background-image {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: 0;
        }
        
        .background-image img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            object-position: center;
        }
        
        /* Gradient overlay for bottom visibility */
        .gradient-overlay {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            height: 33.333%;
            background: linear-gradient(to top, rgba(0, 0, 0, 0.2), transparent);
            pointer-events: none;
            z-index: 1;
        }
        
        /* Header Section */
        .header-section {
            position: absolute;
            top: 60px;
            left: 0;
            right: 0;
            z-index: 10;
            text-align: center;
            padding: 0 24px;
        }
        
        .catchphrase {
            display: inline-block;
            padding: 24px 40px;
        }
        
        .catchphrase-line {
            font-size: 42px;
            font-weight: 700;
            line-height: 1.4;
            color: #fff;
            margin: 0;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.2),
                         0 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        .catchphrase-line:first-child {
            font-size: 36px;
            font-weight: 500;
            color: rgba(255, 255, 255, 0.95);
        }
        
        .catchphrase-line:last-child {
            color: #03C75A;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.25),
                         0 4px 8px rgba(0, 0, 0, 0.15),
                         0 0 12px rgba(3, 199, 90, 0.2);
        }
        
        .mobile-break {
            display: none;
        }
        
        /* Main Content Area */
        .content-area {
            position: relative;
            z-index: 10;
            height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
            align-items: center;
            padding: 0 24px 80px;
        }
        
        /* Action Buttons Group */
        .button-group {
            width: 100%;
            max-width: 448px;
            display: flex;
            gap: 12px;
            justify-content: center;
            align-items: center;
        }
        
        /* Button Base Styles */
        .btn {
            min-width: 140px;
            height: 48px;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            border-radius: 6px;
            font-size: 16px;
            font-weight: 500;
            text-decoration: none;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
            transition: all 0.2s ease;
            cursor: pointer;
            border: none;
        }
        
        .btn:active {
            transform: scale(0.95);
        }
        
        .btn:focus {
            outline: none;
            box-shadow: 0 0 0 3px rgba(3, 199, 90, 0.3);
        }
        
        /* 로그인 Button (Green) */
        .btn-login {
            background-color: #03C75A;
            color: white;
        }
        
        .btn-login:hover {
            background-color: #02b150;
        }
        
        /* 회원가입 Button (White) */
        .btn-signup {
            background-color: rgba(255, 255, 255, 0.9);
            color: #222222;
            backdrop-filter: blur(8px);
        }
        
        .btn-signup:hover {
            background-color: rgba(255, 255, 255, 1);
        }
        
        .btn-signup:focus {
            box-shadow: 0 0 0 3px rgba(255, 255, 255, 0.5);
        }
        
        /* Responsive Design */
        @media (max-width: 640px) {
            .header-section {
                top: 30px;
            }
            
            .catchphrase {
                padding: 16px 20px;
            }
            
            .catchphrase-line {
                font-size: 28px;
                line-height: 1.3;
            }
            
            .catchphrase-line:first-child {
                font-size: 24px;
            }
            
            .mobile-break {
                display: block;
            }
            
            .button-group {
                flex-direction: column;
                gap: 12px;
            }
            
            .btn {
                width: 100%;
            }
            
            .content-area {
                padding-bottom: 96px;
            }
        }
    </style>
</head>
<body>
    <div class="landing-container">
        <!-- Background Image -->
        <div class="background-image">
            <img src="<%= request.getContextPath() %>/images/door-802.jpg" alt="Room 802 Door">
        </div>
        
        <!-- Gradient overlay for bottom visibility -->
        <div class="gradient-overlay"></div>
        
        <!-- Header Section -->
        <div class="header-section">
            <div class="catchphrase">
                <p class="catchphrase-line">대게가 지금 <br class="mobile-break">제철이라고?</p>
                <p class="catchphrase-line">우리 학원은 <br class="mobile-break">대철이 제철!</p>
            </div>
        </div>
        
        <!-- Main Content Area -->
        <div class="content-area">
            <!-- Action Buttons Group -->
            <div class="button-group">
                <!-- 로그인 버튼 -->
                <a href="<%= request.getContextPath() %>/MemberServlet?command=login_form" class="btn btn-login">
                    로그인
                </a>
                
                <!-- 회원가입 버튼 -->
                <a href="<%= request.getContextPath() %>/MemberServlet?command=join_form" class="btn btn-signup">
                    회원가입
                </a>
            </div>
        </div>
    </div>
</body>
</html>
