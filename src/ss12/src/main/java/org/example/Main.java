package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBContext.getConnection()) {
            System.out.println("Ket noi thanh cong!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}