package modelo;

public class solicituddemedicamento {
    private int idSolicitud;
    private int dni;
    private String medicamento;
    private int cantidad;

    public solicituddemedicamento(int dni, String medicamento, int cantidad) {
        this.dni = dni;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public int getDni() { return dni; }
    public void setDni(int dni) { this.dni = dni; }

    public String getMedicamento() { return medicamento; }
    public void setMedicamento(String medicamento) { this.medicamento = medicamento; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
