package com.example;

import java.io.*;
import java.util.ArrayList;

public class Client {
    static MainPage MP;
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000) )
        {
            MP = new MainPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}