package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private static final String URl ="jdbc:mysql://127.0.0.1:3306/doctor_db_Bai1";
    private static final String User ="root";
    private static final String Password ="Bibeo54321";
    public static Connection   getConnection() {
        try{
            return DriverManager.getConnection(URl,User,Password);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
