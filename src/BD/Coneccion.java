package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Coneccion {
     private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=recetasymedicamentos;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "admin2";
    private static final String PASSWORD = "root13";
    
    public static Connection getConexion() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return null;
        }
}
}
