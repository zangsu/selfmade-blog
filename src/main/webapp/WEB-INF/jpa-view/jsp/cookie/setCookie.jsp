<%@ page import="org.springframework.boot.web.servlet.server.Session" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<%
    if(session.getAttribute("cookie") == null){
        System.out.println("no session");
        %>
<script>
location.href = "http://localhost:8080/cookie/makeSession"</script>
<%
    }else{
        %>
<p>session value = <%=session.getAttribute("cookie")%></p>
<%
    }
%>
</body>
</html>