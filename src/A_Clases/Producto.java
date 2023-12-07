package A_Clases;

public class Producto {

    private int CodigoProducto;
    private String Nombre;
    private String Descripcion;
    private double Precio;
    private int Stock;

    public Producto(int CodigoProducto, String Nombre, String Descripcion, double Precio, int Stock) {
        this.CodigoProducto = CodigoProducto;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Stock = Stock;
    }

    @Override
    public String toString() {
        return "Producto{"
                + "Codigo=" + CodigoProducto
                + ", Nombre='" + Nombre + '\''
                + ", Descripcion=" + Descripcion
                + ", Precio=" + Precio
                + ", Stock=" + Stock
                + '}';

    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }
}
