<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Author</title>
</head>
<body>
<h2>
    Create Author
</h2>
<form action="/createAuthor" method="post">

    name:<input type="text" name="name"><br>
    surname:<input type="text" name="surname"><br>
    email:<input type="text" name="email"><br>
    age:<input type="text" name="age"><br>
    <input type="submit" value="create">
</form><br>
<a href="/authors">Back</a>
</body>
</html>
