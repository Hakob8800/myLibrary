<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
</head>
<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>
<body>
<h2>
    Create Book
</h2>
<form action="/createBook" method="post">

    title:<input type="text" name="title"><br>
    Description:<input type="text" name="description"><br>
    price:<input type="text" name="price"><br>
    <select name="author">
        <%for (Author author : authors) { %>
        <option value="<%=author.getId()%>"> <%=author.getName() %> <%=author.getSurname()%> </option>
        <% } %>
    </select><br>
    <input type="submit" value="create">
</form><br>
<a href="/books">Back</a>
</body>
</html>
