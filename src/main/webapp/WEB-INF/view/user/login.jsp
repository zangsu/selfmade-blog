<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>
<div class="container">
    <%
        if(session.getAttribute("userIdx") != null){
            %>
    <p>이미 로그인이 되어있습니다.</p>
    <!--script>
        alert("이미 로그인이 되어 있습니다.")
        //history.back
        /*
        const Http = new XMLHttpRequest();
        const url = "http://localhost:8080/user/login";
        Http.open("POST", url);
        Http.send();
         */
        location.href = "/successLogin.jsp"
    </script-->
    <%
        }
        else {
    %>
    로그인 페이지 입니다.
    <form action="http://localhost:8080/user/login" method="post">
        <p>아이디 : <input type="text" name="id"/><br></p>
        <p>비밀번호 : <input type="password" name="password"/><br></p>
        <input type="submit"/>
    </form>
    <%
        }
    %>
</div>
</body>
</html>