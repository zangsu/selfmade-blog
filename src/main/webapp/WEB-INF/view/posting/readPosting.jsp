<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<%
    request.setCharacterEncoding("utf-8");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
%>

<div class="container">
    <p>제목 : <%=title%><br></p>
    <p>내용 : <%=content%></p>
</div>
</body>
</html>