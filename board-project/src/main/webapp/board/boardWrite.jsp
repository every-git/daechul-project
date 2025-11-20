<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <div class="container">
        <h2>게시글 작성</h2>
        
        <form action="../BoardServlet?command=board_write" method="post">
            <div class="form-group">
                <label>제목:</label>
                <input type="text" name="title" required>
            </div>
            
            <div class="form-group">
                <label>내용:</label>
                <textarea name="content" rows="10" required></textarea>
            </div>
            
            <div class="form-group">
                <button type="submit">등록</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
</body>
</html>
