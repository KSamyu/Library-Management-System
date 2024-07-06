import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Int1 {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        String url ="jdbc:mysql://localhost:3306/jdbcexam\",\"root\",\"samyu_park";
        String user = "root";
        String password = "samyu_park";
        String query = "SELECT HASHBYTES('MD5', 'samyu') AS HashValue";
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                byte[] hashBytes = rs.getBytes("HashValue");
                StringBuilder sb = new StringBuilder();
                for (byte b : hashBytes) {
                    sb.append(String.format("%02x", b));
                }
                System.out.println(sb.toString());
            }
        }
    }
}
