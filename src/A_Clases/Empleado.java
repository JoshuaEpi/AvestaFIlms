package A_Clases;

public class Empleado {

    private int CodigoEmpleado;
    private String Nombre;
    private String Apellido;
    private double Sueldo;
    private String Telefono;
    private String Cargo;


    public Empleado(int CodigoEmpleado, String Nombre, String Apellido, double Sueldo, String Telefono, String Cargo) {
        this.CodigoEmpleado = CodigoEmpleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sueldo = Sueldo;
        this.Telefono = Telefono;
        this.Cargo = Cargo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getCodigoEmpleado() {
        return CodigoEmpleado;
    }

    public void setCodigoEmpleado(int CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

}
