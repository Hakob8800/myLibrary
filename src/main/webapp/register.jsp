
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<%
  if(request.getSession().getAttribute("user")!=null){
    response.sendRedirect("/home");
  }
%>
<h3>
  Register
</h3>
<form action="/register" method="post">
  name: <input type="text" name="name"><br>
  surname: <input type="text" name="surname"><br>
  email: <input type="text" name="email"><br>
  password: <input type="password" name="password"><br>
  <input type="submit" value="register">
</form>
</body>
</html>
