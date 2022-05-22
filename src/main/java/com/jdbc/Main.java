package com.jdbc;


import java.sql.*;

public class Main {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "Hhf:W7N+at";
    private static final String URL = "jdbc:mysql://192.168.10.63:3306/MySQL";
    private static final String URLFIXED = URL + "?useSSL=false&serverTimezone=UTC";
    public static void main(String[] args) throws SQLException {
        DBProcessor db = new DBProcessor();
        Connection conn = db.getConnection(URLFIXED, USERNAME, PASSWORD);
        String query = "select * from touristagency.tours";
        Statement stat = conn.createStatement();
        ResultSet resSet = stat.executeQuery(query);
        while (resSet.next()) {
            System.out.println(resSet.getString("tour_name"));
        }

        /*String queryInsert = "insert into business.products (product_name, price, shop_id) values (?, ?, ?)";
        PreparedStatement prepInsert = conn.prepareStatement(queryInsert);
        prepInsert.setString(1,"NewFood");
        prepInsert.setDouble(2,458.9);
        prepInsert.setInt(3,2);
        prepInsert.execute();

        PreparedStatement prepStat = conn.prepareStatement(query);
        ResultSet resSet = prepStat.executeQuery();
        while (resSet.next()) {
            System.out.println(resSet.getInt("product_id") + " " + resSet.getString("product_name"));
        }*/

        conn.close();




        /*Statement stat = conn.createStatement();
        ResultSet resSet = stat.executeQuery(query);
        while (resSet.next()) {
            int id;
            String name;
            double price;
            int shopID;
            id = resSet.getInt("product_id");
            name = resSet.getString("product_name");
            price = resSet.getDouble("price");
            shopID = resSet.getInt("shop_id");
            Product product = new Product(id, name, price, shopID);
            System.out.println(product);
        }
        stat.close(); */

        /*stat.executeUpdate("update business.products set product_name=\"Snickers\" where product_id=11");
        stat.addBatch("insert into business.products (product_name, price, shop_id) values (\"Prod1\", 23, 1)");
        stat.addBatch("insert into business.products (product_name, price, shop_id) values (\"Prod2\", 354, 2)");
        stat.addBatch("insert into business.products (product_name, price, shop_id) values (\"Prod3\", 23, 3)");
        stat.executeBatch();
        stat.clearBatch();*/

    }
}
