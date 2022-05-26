package com.example;

import java.awt.*;
import java.sql.*;

public class Main {


    public static void main(String[] args) throws SQLException {

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
