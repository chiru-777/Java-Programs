import java.sql.*;

public class DBConnection {

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hotel_db",
            "root",
            "chiru@262006"
        );
    }
}