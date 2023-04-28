<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
<body>
<h2>Books</h2>
<a href="/createBook">Create Book</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Title</th>
    <th>Description</th>
    <th>price</th>
    <th>Author</th>
    <th>Action</th>
  </tr>
  <% if(books!=null) { %>
  <% for (Book book : books) { %>

  <tr>
    <td> <%= book.getId() %> </td>
    <td> <%= book.getTitle() %> </td>
    <td> <%= book.getDescription() %> </td>
    <td> <%= book.getPrice() %> </td>
    <td> <%= book.getAuthor().getName() %> <%= book.getAuthor().getSurname()%></td>
    <td> <a href="/deleteBook?id=<%=book.getId()%>">Delete</a>/
      <a href="/updateBook?id=<%=book.getId()%>">Update</a>
    </td>
  </tr>

  <% } %>
  <% } %>

</table><br>

<a href="/books">All books</a>
</body>
</html>
