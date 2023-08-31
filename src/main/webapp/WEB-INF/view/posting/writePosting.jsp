<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<div class="container">
    <form action="http://localhost:8080/post" method="post">
        <p>제목 : <input type="text" name="title"/><br></p>
        <p>내용 : <input type="text" name="content"/><br></p>
        <input type="submit" name="전송"/>
    </form>
</div>
</body>
</html>