package A_Clases;

public class Cliente {

    private int Dni;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String NumeroContacto;

    public Cliente(int Dni, String Nombre, String Apellido, String Correo, String NumeroContacto) {
        this.Dni = Dni;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.NumeroContacto = NumeroContacto;
    }

    public String getNumeroContacto() {
        return NumeroContacto;
    }

    public void setNumeroContacto(String NumeroContacto) {
        this.NumeroContacto = NumeroContacto;
    }

    public int getDni() {
        return Dni;
    }

    public void setDni(int Dni) {
        this.Dni = Dni;
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

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}
