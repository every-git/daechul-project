<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>오류 발생</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <style>
        .error-container {
            max-width: 800px;
            margin: 50px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .error-icon {
            font-size: 64px;
            text-align: center;
            color: #dc3545;
            margin-bottom: 20px;
        }
        .error-message {
            background-color: #f8d7da;
            color: #721c24;
            padding: 15px;
            border-radius: 5px;
            border-left: 4px solid #dc3545;
            margin: 20px 0;
        }
        .error-details {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            font-family: monospace;
            font-size: 12px;
            overflow-x: auto;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <div class="error-icon">⚠️</div>
        <h1 style="text-align: center;">오류가 발생했습니다</h1>
        
        <div class="error-message">
            <%
                String errorMsg = (String) request.getAttribute("error");
                if (errorMsg != null) {
                    out.println("<p><strong>오류 메시지:</strong> " + errorMsg + "</p>");
                } else if (exception != null) {
                    out.println("<p><strong>오류 메시지:</strong> " + exception.getMessage() + "</p>");
                } else {
                    out.println("<p>알 수 없는 오류가 발생했습니다.</p>");
                }
            %>
        </div>
        
        <%
            // 개발 모드일 경우 상세 정보 표시
            if (exception != null && request.getParameter("debug") != null) {
        %>
        <div class="error-details">
            <h3>상세 정보 (개발용):</h3>
            <pre><%= exception.toString() %></pre>
            <%
                for (StackTraceElement element : exception.getStackTrace()) {
                    out.println(element.toString() + "<br>");
                }
            %>
        </div>
        <%
            }
        %>
        
        <div style="text-align: center; margin-top: 30px;">
            <a href="javascript:history.back()" class="button">이전 페이지</a>
            <a href="<%= request.getContextPath() %>/index.jsp" class="button">메인으로</a>
        </div>
    </div>
</body>
</html>
