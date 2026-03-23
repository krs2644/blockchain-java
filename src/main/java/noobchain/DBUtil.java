package noobchain;
import java.sql.*;

public class DBUtil {

    private static final String DB_URL = "jdbc:h2:./data/blockchainDB"; 
    // SAME FILE reused (./data/blockchainDB.mv.db)

    private static final String USER = "sa";
    private static final String PASS = "";

    static {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Create table if not exists
            String sql = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "id VARCHAR(255) PRIMARY KEY, " +
                    "sender VARCHAR(255), " +
                    "receiver VARCHAR(255), " +
                    "amount DOUBLE, " +
                    "timestamp BIGINT" +
                    ")";
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void saveTransaction(String id, String sender, String receiver, double amount) {
        String sql = "MERGE INTO transactions (id, sender, receiver, amount, timestamp) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            pstmt.setString(2, sender);
            pstmt.setString(3, receiver);
            pstmt.setDouble(4, amount);
            pstmt.setLong(5, System.currentTimeMillis());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}