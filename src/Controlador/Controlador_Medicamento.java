
package Controlador;
import java.util.List;
import modelo.SMedicamento;
import modelo.MedicamentoDAO;
public class Controlador_Medicamento {
    private final MedicamentoDAO dao = new MedicamentoDAO();

    public List<SMedicamento> listarMedicamentos() {
        return dao.listar();
    }

    public List<SMedicamento> buscarPorNombre(String nombre) {
        return dao.buscarPorNombre(nombre);
    }
}
