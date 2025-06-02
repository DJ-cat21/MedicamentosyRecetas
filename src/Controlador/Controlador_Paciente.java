package Controlador;
import modelo.Pacientes;
import modelo.PacienteDAO;
public class Controlador_Paciente {
    
    private final PacienteDAO dao = new PacienteDAO();

    public Pacientes buscarPacientePorDni(int dni) {
        return dao.buscarPorDni(dni);
    }
}
