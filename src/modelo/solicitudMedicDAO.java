package modelo;
import BD.Coneccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.solicituddemedicamento;

public class solicitudMedicDAO {
    
    public boolean insertarSolicitud(solicituddemedicamento solicitud) {
        String sql = "{call InsertarSolicitud(?,?,?)}";

        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, solicitud.getDni());
            stmt.setString(2, solicitud.getMedicamento());
            stmt.setInt(3, solicitud.getCantidad());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error insertar solicitud: " + e.getMessage());
            return false;
        }
}
    public void registrarSolicitud(int dni, String medicamento, int cantidad) {
        
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call sp_RegistrarSolicitud(?, ?, ?)}")) {

            stmt.setInt(1, dni);
            stmt.setString(2, medicamento);
            stmt.setInt(3, cantidad);

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error al registrar solicitud: " + e.getMessage());
        }

    }
    public void eliminarSolicitud(int dni, String nombreMedicamento) {
    try (Connection conn = Coneccion.getConexion();
         CallableStatement stmt = conn.prepareCall("{call sp_EliminarSolicitud(?, ?)}")) {

        stmt.setInt(1, dni);
        stmt.setString(2, nombreMedicamento);
        stmt.execute();

    } catch (SQLException e) {
        System.out.println("Error al eliminar solicitud: " + e.getMessage());
    }
}
    public List<solicituddemedicamento> buscarPorDni(int dni) {
        List<solicituddemedicamento> lista = new ArrayList<>();
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call sp_BuscarSolicitudesPorDni(?)}")) {

            stmt.setInt(1, dni);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                solicituddemedicamento s = new solicituddemedicamento(
                       rs.getInt("Dni"),
                        rs.getString("Medicamento"),
                    rs.getInt("Cantidad")
                );
                lista.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar solicitudes: " + e.getMessage());
        }
        return lista;
    }

}
