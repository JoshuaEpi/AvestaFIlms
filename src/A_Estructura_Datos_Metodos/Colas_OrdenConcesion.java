package A_Estructura_Datos_Metodos;

import A_Clases.OrdenConcesion;
import Formatos.Mensajes;
import A_Nodos.NodoOrdenConcesion;
import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Colas_OrdenConcesion {

    private NodoOrdenConcesion PrimeraOrden;
    private NodoOrdenConcesion UltimaOrden;

    public Colas_OrdenConcesion() {
        this.PrimeraOrden = null;
        this.UltimaOrden = null;
    }

    public NodoOrdenConcesion getPrimeraOrden() {
        return PrimeraOrden;
    }

    public void setPrimeraOrden(NodoOrdenConcesion PrimeraOrden) {
        this.PrimeraOrden = PrimeraOrden;
    }

    public NodoOrdenConcesion getUltimaOrden() {
        return UltimaOrden;
    }

    public void setUltimaOrden(NodoOrdenConcesion UltimaOrden) {
        this.UltimaOrden = UltimaOrden;
    }

    public void encolar(OrdenConcesion ordenConcesion) {
        NodoOrdenConcesion nuevoNodo = new NodoOrdenConcesion(ordenConcesion);

        if (PrimeraOrden == null) {
            PrimeraOrden = nuevoNodo;
            UltimaOrden = nuevoNodo;
        } else {
            UltimaOrden.setSiguiente(nuevoNodo);
            UltimaOrden = nuevoNodo;
        }
    }

    public void encolarRecursivo(OrdenConcesion ordenConcesion) {
        
        NodoOrdenConcesion nodoactual = new NodoOrdenConcesion(ordenConcesion);
        
        if (nodoactual == null) {
            NodoOrdenConcesion nuevoNodo = new NodoOrdenConcesion(ordenConcesion);
            PrimeraOrden = nuevoNodo;
            UltimaOrden = nuevoNodo;
        } else if (nodoactual.getSiguiente() == null) {
            NodoOrdenConcesion nuevoNodo = new NodoOrdenConcesion(ordenConcesion);
            nodoactual.setSiguiente(nuevoNodo);
            UltimaOrden = nuevoNodo;
        } else {
            encolarRecursivo(ordenConcesion, nodoactual.getSiguiente());
        }
        AgregarOrdenBD(ordenConcesion);
    }

    private void encolarRecursivo(OrdenConcesion ordenConcesion, NodoOrdenConcesion nodo) {
        if (nodo.getSiguiente() == null) {
            NodoOrdenConcesion nuevoNodo = new NodoOrdenConcesion(ordenConcesion);
            nodo.setSiguiente(nuevoNodo);
            UltimaOrden = nuevoNodo;
        } else {
            encolarRecursivo(ordenConcesion, nodo.getSiguiente());
        }
    }

    public OrdenConcesion desencolar() {
        if (PrimeraOrden == null) {
            Mensajes.M1("LA COLA VACIA!!!!");
        }
        OrdenConcesion ordenConcesion = PrimeraOrden.getOrdenConcesion();
        PrimeraOrden = PrimeraOrden.getSiguiente();
        //eliminarOrdenDeBD(ordenConcesion);

        return ordenConcesion;
    }

    public OrdenConcesion VerPrimero() {
        if (PrimeraOrden == null) {
            Mensajes.M1("La cola está vacía");
            return null;
        } else {
            return PrimeraOrden.getOrdenConcesion();
        }
    }

//    public boolean EstaVacia() {
//        return PrimeraOrden == null;
//    }
    public boolean EstaVacia() {
        if (PrimeraOrden == null) {
            return true;
        } else {
            return false;
        }
    }

    private void AgregarOrdenBD(OrdenConcesion ordenConcesion) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO OrdenConcesion (NumeroOrden, NombreCliente, Producto, Cantidad, PrecioUnitario, Total) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                if (ordenConcesion.getProducto() != null) {
                    PreparedStatement statement = conexion.prepareStatement(query);
                    statement.setInt(1, ordenConcesion.getNumeroOrden());
                    statement.setString(2, ordenConcesion.getNombreCliente());
                    statement.setString(3, ordenConcesion.getProducto());
                    statement.setInt(4, ordenConcesion.getCantidad());
                    statement.setDouble(5, ordenConcesion.getPrecioUnitario());
                    statement.setDouble(6, ordenConcesion.getTotal());
                    statement.executeUpdate();
                    System.out.println("La orde se agregó a la base de datos!!!");
                } else {
                    System.out.println("Error: El producto no puede ser null");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void eliminarOrdenDeBD(OrdenConcesion ordenConcesion) {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                String sql = "DELETE FROM OrdenConcesion WHERE NumeroOrden = ?";
                try (PreparedStatement stmt = con.prepareStatement(sql)) {
                    stmt.setInt(1, ordenConcesion.getNumeroOrden());
                    stmt.executeUpdate();
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Mensajes.M1("La conexión a la base de datos falló");
        }
    }
}
