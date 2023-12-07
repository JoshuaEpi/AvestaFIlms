package A_Clases;

public class OrdenConcesion {

    private int NumeroOrden;
    private String NombreCliente;
    private String Producto;
    private int Cantidad;
    private double PrecioUnitario;
    private double Total;

    public OrdenConcesion(int NumeroOrden, String NombreCliente, String Producto, int Cantidad, double PrecioUnitario, double Total) {
        this.NumeroOrden = NumeroOrden;
        this.NombreCliente = NombreCliente;
        this.Producto = Producto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Total = Total;
    }

    public int getNumeroOrden() {
        return NumeroOrden;
    }

    public void setNumeroOrden(int NumeroOrden) {
        this.NumeroOrden = NumeroOrden;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

}
