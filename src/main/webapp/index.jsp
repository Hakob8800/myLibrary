<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login MyLibrary</title>
</head>
<body>
<%
    if(request.getSession().getAttribute("user")!=null){
        response.sendRedirect("/home");
    }
%>
<h3>
    Login
</h3>
<form action="/login" method="post">
    email: <input type="text" name="email"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="login">
</form>
<br/>
<a href="/register.jsp">Register</a><br>
</body>
</html>