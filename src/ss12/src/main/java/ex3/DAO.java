package ex3;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class DAO {
    public double getCost(int id) {
        double cost = 0;
        String sql = "{call GET_SURGERY_FEE(?, ?)}";
        try (Connection conn = DBContext.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DOUBLE);
            cs.execute();
            cost = cs.getDouble(2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cost;
    }
}
