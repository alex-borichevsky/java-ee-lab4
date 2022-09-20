package com.example.demo3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DefaultStudentDao {
    private static final String ID_COLUMN = "id";
    private static final String LASTNAME_COLUMN = "lastname";
    private static final String FIRSTNAME_COLUMN = "firstname";
    private static final String COURSE_COLUMN = "course";
    private static final String GROUP_COLUMN = "group";
    private static final String IS_VILLAGER_COLUMN = "isVillager";
    private static final String AVG_MARK_COLUMN = "avgMark";


    private static DefaultStudentDao personDao;

    private Connection connection;
    private Statement statement;

    private DefaultStudentDao(Connection connection) throws SQLException {
        this.connection = connection;
        statement = connection.createStatement();
    }

    public static DefaultStudentDao getInstance(Connection connection) {
        if (personDao == null) {
            try {
                personDao = new DefaultStudentDao(connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return personDao;
    }

    public List<Student> getAllStudents() {
        List<Student> persons = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Long id = rs.getLong(ID_COLUMN);
                String lastname = rs.getString(LASTNAME_COLUMN);
                String firstname = rs.getString(FIRSTNAME_COLUMN);
                Integer course = rs.getInt(COURSE_COLUMN);
                Integer group = rs.getInt(GROUP_COLUMN);
                Boolean isVillager = rs.getBoolean(IS_VILLAGER_COLUMN);
                Double avgMark = rs.getDouble(AVG_MARK_COLUMN);
                persons.add(new Student(id, lastname, firstname, isVillager, course, group, avgMark));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return persons;
    }

    public Long count() {
        Long count = null;
        try {
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) as count FROM students");
            rs.next();
            count = rs.getLong("count");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}
