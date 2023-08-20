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
    <form action="localhost:8080/post" method="post">
        <p>제목 : <%=title%><br></p>
        <p>내용 : <%=content%></p>
    </form>
</div>
</body>
</html>