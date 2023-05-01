<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<%User user = (User) request.getSession().getAttribute("user");%>
<body>
<h3>
    Welcome MyLibrary <%=user.getName()%>
</h3>
<a href="/authors">Authors</a><br>
<a href="/books">Books</a><br><br>
<a href="/logout">LogOut</a>
</body>
</html>
