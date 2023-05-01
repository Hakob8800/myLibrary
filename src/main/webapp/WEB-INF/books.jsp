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
        <th>Cover picture</th>
        <th>Title</th>
        <th>Description</th>
        <th>price</th>
        <th>Author</th>
        <th>Action</th>
    </tr>
    <% if (books != null) { %>
    <% for (Book book : books) { %>

    <tr>
        <td><%= book.getId() %>
        </td>
        <%if (book.getImagePath() == null || book.getImagePath().equals("null")) {%>
        <td><img src="\img\default_book_picture.webp" width="100px"></td>
        <%} else {%>
        <td><a href="/getImgServlet?imgPath=<%=book.getImagePath()%>"><img
                src="/getImgServlet?imgPath=<%=book.getImagePath()%>" width="100px"></a></td>
        <%}%>
        <td><%= book.getTitle() %>
        </td>
        <td><%= book.getDescription() %>
        </td>
        <td><%= book.getPrice() %>
        </td>
        <td><%= book.getAuthor().getName() %> <%= book.getAuthor().getSurname()%>
        </td>
        <td><a href="/deleteBook?id=<%=book.getId()%>">Delete</a>/
            <a href="/updateBook?id=<%=book.getId()%>">Update</a>
        </td>
    </tr>

    <% } %>
    <% } %>

</table>
<br>

<form action="/books" method="get">
    <input type="text" value="Keyword" name="keyword">
    <input type="submit" value="search">
</form>
<br><br>

<a href="/home">back</a>
</body>
</html>
