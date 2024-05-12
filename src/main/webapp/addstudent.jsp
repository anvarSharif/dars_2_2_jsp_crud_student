<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/04/2024
  Time: 07:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add student</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-4">Add Student</h1>
    <form action="/student" method="post">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>

        <div class="form-group">
            <label for="age">Age:</label>
            <input type="number" class="form-control" id="age" name="age" required>
        </div>

        <button type="submit" class="btn btn-primary">Add Student</button>
    </form>
</div>

</body>
</html>
