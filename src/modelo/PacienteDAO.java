package modelo;
import java.sql.*;
import java.util.*;
import modelo.Pacientes;
import BD.Coneccion;
public class PacienteDAO {
    public void insertar(Pacientes p) {
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call InsertarPaciente(?,?,?,?,?,?,?)}")) {
            stmt.setInt(1, p.getDni());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getApellido());
            stmt.setInt(4, p.getEdad());
            stmt.setString(5, p.getDireccion());
            stmt.setString(6, p.getCorreo());
            stmt.setInt(7, p.getTelefono());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error insertar: " + e.getMessage());
        }
    }

    public void actualizar(Pacientes p) {
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call ActualizarPaciente(?,?,?,?,?,?,?)}")) {
            stmt.setInt(1, p.getDni());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getApellido());
            stmt.setInt(4, p.getEdad());
            stmt.setString(5, p.getDireccion());
            stmt.setString(6, p.getCorreo());
            stmt.setInt(7, p.getTelefono());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error actualizar: " + e.getMessage());
        }
    }

    public void eliminar(int Dni) {
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call EliminarPaciente(?)}")) {
            stmt.setInt(1, Dni);
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Error eliminar: " + e.getMessage());
        }
    }

    public Pacientes buscarPorDni(int Dni) {
        Pacientes p = null;
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call BuscarPaciente(?)}")) {
            stmt.setInt(1, Dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = new Pacientes(
                    rs.getInt("Dni"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getInt("telefono")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error buscar: " + e.getMessage());
        }
        return p;
    }

    public List<Pacientes> listar() {
        List<Pacientes> lista = new ArrayList<>();
        try (Connection conn = Coneccion.getConexion();
             CallableStatement stmt = conn.prepareCall("{call ListarPacientes()}");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pacientes p = new Pacientes(
                    rs.getInt("Dni"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("edad"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getInt("edad")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error listar: " + e.getMessage());
        }
        return lista;
}
}


