import java.sql.*;

public class Login {
    public void getUser(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "user", "pass");
        Statement stmt = conn.createStatement();
        // VULNERABILIDAD CRÍTICA: SQL Injection
        // El usuario puede enviar " ' OR '1'='1 " para saltarse la seguridad.
        String query = "SELECT * FROM users WHERE id = '" + userId + "'";
        ResultSet rs = stmt.executeQuery(query);
    }
}