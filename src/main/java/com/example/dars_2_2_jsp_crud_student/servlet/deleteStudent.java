package com.example.dars_2_2_jsp_crud_student.servlet;

import com.example.dars_2_2_jsp_crud_student.repo.StudentRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/student/delete")
public class deleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID studentId = UUID.fromString(req.getParameter("id"));
        StudentRepo.deleteById(studentId);
        resp.sendRedirect("/admin.jsp");
    }
}
