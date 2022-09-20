package com.example.demo3.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnection {

    private static final String PROPERTIES_FILENAME = "db.properties";
    private static final String DB_DRIVER_CLASS_PROPERTY = "DB_DRIVER_CLASS";
    private static final String DB_URL_PROPERTY = "DB_URL";
    private static final String DB_USERNAME_PROPERTY = "DB_USERNAME";
    private static final String DB_PASSWORD_PROPERTY = "DB_PASSWORD";

    public static Connection getConnection() {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        Connection connection = null;
        try {
            fileInputStream = new FileInputStream(PROPERTIES_FILENAME);
            properties.load(fileInputStream);
            Class.forName(properties.getProperty(DB_DRIVER_CLASS_PROPERTY));
            connection = DriverManager.getConnection(properties.getProperty(DB_URL_PROPERTY),
                    properties.getProperty(DB_USERNAME_PROPERTY),
                    properties.getProperty(DB_PASSWORD_PROPERTY));
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();

        }
        return connection;
    }
}