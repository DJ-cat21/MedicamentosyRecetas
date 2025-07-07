package modelo;
import java.sql.*;
import java.util.*;
import modelo.Auditoria_Pac;
import BD.Coneccion;
public class Auditoria_PacDAO {
    public List<Auditoria_Pac> listar() {
        List<Auditoria_Pac> lista = new ArrayList<>();
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("Select Dni, nombre, apellido, edad, direccion, correo, telefono, Accion, FechaHora from AuditoriaPacientes");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Auditoria_Pac a = new Auditoria_Pac(
                    rs.getInt("Dni"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getString("telefono"),
                    rs.getString("accion"),
                    rs.getString("Fechahora")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error listar: " + e.getMessage());
        }
        return lista;
}
}
