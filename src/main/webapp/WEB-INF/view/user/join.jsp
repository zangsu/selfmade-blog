<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<div class="container">

    회원 가입 페이지 입니다.
    <form action="http://localhost:8080/user" method="post">
        <p>아이디 : <input type="text" name="id"/><br></p>
        <p>비밀번호 : <input type="password" name="password"/><br></p>
        <input type="submit"/>
    </form>
</div>
</body>
</html>