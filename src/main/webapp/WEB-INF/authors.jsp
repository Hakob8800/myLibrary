<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors</title>
</head>
<% List<Author> authors = (List<Author>) request.getAttribute("authors"); %>
<body>
<h2>Authors</h2>
<a href="/createAuthor">Create Author</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Surname</th>
    <th>Email</th>
    <th>Age</th>
    <th>Action</th>
  </tr>
  <% if(authors!=null) { %>
  <% for (Author author : authors) { %>

  <tr>
    <td> <%= author.getId() %> </td>
    <td> <%= author.getName() %> </td>
    <td> <%= author.getSurname() %> </td>
    <td> <%= author.getEmail() %> </td>
    <td> <%= author.getAge() %> </td>
    <td> <a href="/deleteAuthor?id=<%=author.getId()%>">Delete</a>/
      <a href="/updateAuthor?id=<%=author.getId()%>">Update</a>
    </td>
  </tr>

  <% } %>
  <% } %>

</table><br><br>
<a href="/home">back</a>
</body>
</html>
