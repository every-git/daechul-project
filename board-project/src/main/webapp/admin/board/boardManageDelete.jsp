<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 삭제</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <script>
        alert('게시글이 삭제되었습니다.');
        location.href = '../../AdminServlet?command=board_manage_list';
    </script>
</body>
</html>
