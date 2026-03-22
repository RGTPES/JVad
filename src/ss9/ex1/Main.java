package ss9.ex1;


import java.sql.Connection;
import java.sql.SQLException;

import static ss9.ex1.DBContext.getConnection;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println("Ket noi that bai");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
