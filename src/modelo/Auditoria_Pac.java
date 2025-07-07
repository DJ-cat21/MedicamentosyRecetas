package modelo;

public class Auditoria_Pac {
    private int Dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String correo;
    private String telefono;
    private String accion; 
    private String Fecha_hora;


public Auditoria_Pac() {}

   public Auditoria_Pac(int Dni, String nombre, String apellido, int edad, String direccion, String correo, String telefono, String accion, String Fecha_hora) {
        this.Dni = Dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.accion = accion;
        this.Fecha_hora = Fecha_hora;
    }
    
    public int getDni() { return Dni; }
    public void setDni(int dni) { this.Dni = Dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }
    
    public String getFecha_Hora() { return Fecha_hora; }
    public void setFecha_Hora(String Fecha_hora) { this.Fecha_hora = Fecha_hora; }
}

