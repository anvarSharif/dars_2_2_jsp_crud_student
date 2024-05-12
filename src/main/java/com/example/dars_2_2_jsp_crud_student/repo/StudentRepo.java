package com.example.dars_2_2_jsp_crud_student.repo;

import com.example.dars_2_2_jsp_crud_student.config.Pool;
import com.example.dars_2_2_jsp_crud_student.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentRepo {
    public static void save(Student student) {
        String query = "insert into student(first_name,last_name,age) values (?,?,?)";
        try (
                Connection connection = Pool.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> findAll() {
        String query = "select * from student";
        try (
                Connection connection = Pool.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(new Student(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                ));
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteById(UUID studentId) {
        String query = "delete from student where id=?";
        try (
                Connection connection = Pool.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1, studentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Student findById(UUID studentId) {
        String query = "select * from student where id=?";
        try (
                Connection connection = Pool.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setObject(1,studentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(new Student(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                ));
            }
            return students.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update(UUID studentId, Student student) {
        String query = "update student set first_name=?,last_name=?,age=? where id=?";
        try (
                Connection connection = Pool.getDataSource().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setObject(4, studentId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
