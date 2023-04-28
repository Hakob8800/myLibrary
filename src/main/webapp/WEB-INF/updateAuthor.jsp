<%@ page import="model.Author" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Author</title>
</head>
<% Author author = (Author) request.getAttribute("author"); %>
<body>
<h2>
    Update Author
</h2>
<form action="/updateAuthor" method="post">
    <input type="hidden" name="id" value="<%= author.getId() %>">
    name:<input type="text" name="name" value="<%= author.getName()%>"> <br>
    surname:<input type="text" name="surname" value="<%= author.getSurname()%>"><br>
    email:<input type="email" name="email" value="<%=author.getEmail()%>"><br>
    age:<input type="text" name="age" value="<%=author.getAge()%>"><br>
    <input type="submit" value="update">
</form>
<a href="/authors">back</a>
</body>
</html>