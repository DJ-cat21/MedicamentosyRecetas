
package modelo;

public class SMedicamento {
    private String nombre;
    private int stock;

    public SMedicamento(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }
}
