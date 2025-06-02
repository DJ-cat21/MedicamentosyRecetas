package modelo;

public class Pacientes {
    private int Dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String correo;
    private int telefono;
     
    
  public Pacientes() {}

   public Pacientes(int Dni, String nombre, String apellido, int edad, String direccion, String correo, int telefono) {
        this.Dni = Dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
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
    
    public int getTelefono() { return telefono; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
}



