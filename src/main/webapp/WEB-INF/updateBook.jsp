<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Author" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
</head>
<% Book book = (Book) request.getAttribute("book"); %>
<% List<Author> authors = (List<Author>) request.getAttribute("authors"); %>
<body>
<h2>
   Update Book
</h2>
<form action="/updateBook" method="post">
    <input type="hidden" name="id" value="<%= book.getId() %>">
    title:<input type="text" name="title" value="<%= book.getTitle()%>"> <br>
    description:<input type="text" name="description" value="<%= book.getDescription()%>"><br>
    price:<input type="text" name="price" value="<%=book.getPrice()%>"><br>
    <select name="author_id">
        <%for (Author author : authors) { %>
        <option value="<%=author.getId()%>"> <%=author.getName() %><%=author.getSurname()%> </option>
        <% } %>
    </select><br>
    <input type="submit" value="update">
</form>
<a href="/books">back</a>
</body>
</html>