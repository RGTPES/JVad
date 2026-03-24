package bthuchanh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    private static final String DATABASE_NAME = "Hospital_DB";
    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/" + DATABASE_NAME +
                    "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Bibeo54321";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Khong tim thay MySQL JDBC Driver", e);
        }
        return DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
    }
}
