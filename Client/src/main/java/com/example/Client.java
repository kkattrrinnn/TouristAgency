package com.example;

import java.io.*;
import java.util.ArrayList;

public class Client {

    static InitialWindow IW;
    static LoginWindow LW;
    static RegistrationWindow RW;
    public static void main(String[] args) {


        try (Phone phone = new Phone("127.0.0.1", 8000) )
        {
            IW = new InitialWindow();
            //System.out.println("Connected to server");
            //String request = "na-na-na-nan-na-na-na-na-ma";
            //System.out.println("Request: " + request);
            //phone.writeLine(request);
            //String response = phone.readLine();
            //System.out.println("Response: " + response);
            //System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}