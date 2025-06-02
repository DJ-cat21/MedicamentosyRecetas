package modelo;
 import java.sql.*;
import java.util.*;
import modelo.SMedicamento;
import BD.Coneccion;
public class MedicamentoDAO {
    public List<SMedicamento> buscarPorNombre(String nombre) {
        List<SMedicamento> lista = new ArrayList<>();
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call sp_BuscarMedicamentosPorNombre(?)}")) {

            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SMedicamento med = new SMedicamento(
                    rs.getString("nombre"),
                    rs.getInt("stock")
                );
                lista.add(med);
            }

        } catch (SQLException e) {
            System.out.println("Error buscar medicamento: " + e.getMessage());
        }
        return lista;
    }
    
    public List<SMedicamento> listar() {
        List<SMedicamento> lista = new ArrayList<>();
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call ListarMedicamentos}")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SMedicamento m = new SMedicamento(
                    rs.getString("nombre"),
                    rs.getInt("stock")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar medicamentos: " + e.getMessage());
        }
        return lista;
    }
}
