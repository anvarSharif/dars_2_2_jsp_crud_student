<%@ page import="java.util.UUID" %>
<%@ page import="com.example.dars_2_2_jsp_crud_student.repo.StudentRepo" %>
<%@ page import="com.example.dars_2_2_jsp_crud_student.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/04/2024
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>

<%
    UUID studentId = UUID.fromString(request.getParameter("id"));
    Student student=StudentRepo. findById(studentId);
%>

<div class="container">
    <h1 class="mt-4">Add Student</h1>
    <form action="/student/update" method="post">
        <input type="hidden" name="id" value="<%=student.getId()%>">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input value="<%=student.getFirstName()%>" type="text" class="form-control" id="firstName" name="firstName" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input value="<%=student.getLastName()%>" type="text" class="form-control" id="lastName" name="lastName" required>
        </div>

        <div class="form-group">
            <label for="age">Age:</label>
            <input value="<%=student.getAge()%>" type="number" class="form-control" id="age" name="age" required>
        </div>
        <button type="submit" class="btn btn-primary">save</button>
    </form>
</div>


</body>
</html>
