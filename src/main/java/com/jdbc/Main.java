package com.jdbc;


import java.sql.*;

public class Main {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "HhVL:jfdR>W7N+at";
    private static final String URL = "jdbc:mysql://192.168.120.102:3306/MySQL?useSSL=false";
    private static final String URLFIXED = "jdbc:mysql://localhost:3306/MySQL?useSSL=false&serverTimezone=UTC";
    public static void main(String[] args) throws SQLException {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();       // создание драйвера
            DriverManager.registerDriver(driver);   // регистрация драйвера
        } catch (SQLException e) {
            System.out.println("Произошла ошибка при создании или регистрации драйвера");
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(URLFIXED,USERNAME,PASSWORD);
                Statement statement = connection.createStatement()){      // соединение с БД
            statement.execute("insert into business.products (product_name, price, shop_id) values (\"Smth\", 45, 2)");
            //statement.executeUpdate("update business.products set product_name=\"Snikers\" where product_id=11");
            //statement.addBatch("insert into business.products (product_name, price, shop_id) values (\"Prod1\", 23, 1)");
            //statement.addBatch("insert into business.products (product_name, price, shop_id) values (\"Prod2\", 354, 2)");
            //statement.addBatch("insert into business.products (product_name, price, shop_id) values (\"Prod3\", 23, 3)");
            //statement.executeBatch();
            //statement.clearBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
