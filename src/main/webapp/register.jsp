<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="css/style.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body>
<%
    if (request.getSession().getAttribute("user") != null) {
        response.sendRedirect("/home");
    }
    String msg = (String) request.getAttribute("msg");
%>
<%if (msg != null) {%>
<span style="color: red"><%=msg%></span>
<%}%>
<div class="main-block">
    <h1>Registration</h1>
    <form action="/register" method="post">
        <hr>
        <label id="icon" for="name"><i class="fas fa-user"></i></label>
        <input type="text" name="name" id="name" placeholder="Name" required/>

        <label id="icon" for="surname"><i class="fas fa-user"></i></label>
        <input type="text" name="surname" id="surname" placeholder="Surname" required/>

        <label id="icon" for="email"><i class="fas fa-envelope"></i></label>
        <input type="text" name="email" id="email" placeholder="Email" required/>

        <label id="icon" for="password"><i class="fas fa-unlock-alt"></i></label>
        <input type="password" name="password" id="password" placeholder="Password" required/>
        <hr>
        <div class="gender">
            <input type="radio" value="USER" id="User" name="type" checked/>
            <label for="user" class="radio">USER</label>

            <input type="radio" value="ADMIN" id="admin" name="type"/>
            <label for="admin" class="radio">ADMIN</label>
        </div>
        <hr>
        <div class="btn-block">
            <button type="submit">Register</button>
            <a href="/">
                <button type="button">Back</button>
            </a>
        </div>
    </form>
</div>
</body>
</html>
