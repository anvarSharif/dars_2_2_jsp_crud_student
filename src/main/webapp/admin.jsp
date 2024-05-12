<%@ page import="java.util.List" %>
<%@ page import="com.example.dars_2_2_jsp_crud_student.entity.Student" %>
<%@ page import="com.example.dars_2_2_jsp_crud_student.repo.StudentRepo" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/04/2024
  Time: 07:16
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
    List<Student> students= StudentRepo.findAll();
%>

<div class="row">
    <div class="col-2 offset-10">
        <a href="addstudent.jsp" class="btn btn-dark text-white">add student</a>
    </div>
</div>
<hr>

<table class="table table-stripped">
    <thed>
        <tr>
            <th>id</th>
            <th>firstName</th>
            <th>lastName</th>
            <th>age</th>
            <th>action</th>
        </tr>
    </thed>
    <tbody>
    <%  for (Student student : students) {  %>
<tr>
    <td><%=student.getFirstName()%></td>
    <td><%=student.getLastName()%></td>
    <td><%=student.getAge()%></td>
    <td>
        <a href="updateStudent.jsp?id=<%=student.getId()%>" class="btn btn-info">edit</a>
        <a href="/student/delete?id=<%=student.getId()%>" class="btn btn-danger ">delete</a>
    </td>
</tr>
<%  }  %>
    </tbody>
</table>
</body>
</html>
