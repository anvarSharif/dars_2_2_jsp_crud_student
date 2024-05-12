package com.example.dars_2_2_jsp_crud_student.servlet;

import com.example.dars_2_2_jsp_crud_student.entity.Student;
import com.example.dars_2_2_jsp_crud_student.repo.StudentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/student")
public class AddStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Integer age=Integer.parseInt(Objects.requireNonNullElse( req.getParameter("age"),"0"));
        StudentRepo.save(Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .build());
        resp.sendRedirect("/admin.jsp");
    }
}
