<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>login MyLibrary</title>
</head>
<% String msg = (String) request.getSession().getAttribute("msg");%>
<body>
<%
    if (request.getSession().getAttribute("user") != null) {
        response.sendRedirect("/home");
    }
%>
<h3>
    Login
</h3>
<% if (msg != null) {%>
    <span style="color: firebrick"><%=msg%></span>
<%}%>
<%request.getSession().removeAttribute("msg");%>
<form action="/login" method="post">
    <div class="inp">
        email: <input type="text" name="email"><br><br>
        password: <input type="password" name="password"><br><br>
        <input type="submit" value="login">
    </div>

</form>
<br/>
<a href="/register.jsp">Register</a><br>
</body>
</html>