package A_Estructura_Datos_Metodos;

import A_Clases.Producto;
import A_Nodos.NodoConcesionArbol;
import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Arbol_Concesion {

    NodoConcesionArbol raiz;
    public int numElementos;

    public Arbol_Concesion() {
        this.raiz = raiz;
        this.numElementos = 0;
    }

    //------------------------------METODO INSERTAR---------------------------------------------------
    //
    public void InsertarProducto(Producto producto) {
        raiz = InsertarRecursivo(raiz, producto);

        agregarProductoBD(producto);
    }

    private NodoConcesionArbol InsertarRecursivo(NodoConcesionArbol raiz, Producto producto) {
        if (raiz == null) {
            raiz = new NodoConcesionArbol(producto);
            return raiz;
        }

        if (producto.getCodigoProducto() < raiz.getProducto().getCodigoProducto()) {
            raiz.setIzquierda(InsertarRecursivo(raiz.getIzquierda(), producto));
        } else if (producto.getCodigoProducto() > raiz.getProducto().getCodigoProducto()) {
            raiz.setDerecha(InsertarRecursivo(raiz.getDerecha(), producto));
        }

        return raiz;
    }

    //------------------------------METODO BUSCAR---------------------------------------------------
    //
    public Producto BuscarProducto(int CodigoProducto) {
        return BuscarRecursivo(raiz, CodigoProducto);
    }

    private Producto BuscarRecursivo(NodoConcesionArbol raiz, int CodigoProducto) {
        if (raiz == null || raiz.getProducto().getCodigoProducto() == CodigoProducto) {
            return raiz != null ? raiz.getProducto() : null;
        }
        if (CodigoProducto < raiz.getProducto().getCodigoProducto()) {
            return BuscarRecursivo(raiz.getIzquierda(), CodigoProducto);
        }
        return BuscarRecursivo(raiz.getDerecha(), CodigoProducto);
    }

    //-------------------------------METOOS ORDENES-------------------------------------------------
    //
    public String pre_orden(NodoConcesionArbol raiz) {
        String resultado = pre_orden(raiz);
        return resultado;
    }

    public String in_orden(NodoConcesionArbol raiz) {
        String resutado = in_orden(raiz);
        return resutado;
    }

    public String post_orden(NodoConcesionArbol raiz) {
        String resultado = post_orden(raiz);
        return resultado;
    }

    //------------------------------METODO ELIMINAR---------------------------------------------------
    //
    public void EliminarProducto(int CodigoProducto) {
        raiz = EliminarRecursivo(raiz, CodigoProducto);

        eliminarProductoBD(CodigoProducto);
    }

    private NodoConcesionArbol EliminarRecursivo(NodoConcesionArbol raiz, int CodigoProducto) {
        if (raiz == null) {
            return raiz;
        }
        if (CodigoProducto < raiz.getProducto().getCodigoProducto()) {
            raiz.setIzquierda(EliminarRecursivo(raiz.getIzquierda(), CodigoProducto));
        } else if (CodigoProducto > raiz.getProducto().getCodigoProducto()) {
            raiz.setDerecha(EliminarRecursivo(raiz.getDerecha(), CodigoProducto));
        } else {
            if (raiz.getIzquierda() == null) {
                return raiz.getDerecha();
            } else if (raiz.getDerecha() == null) {
                return raiz.getIzquierda();
            }
            raiz.setProducto(MinimoValor(raiz.getDerecha()).getProducto());

            raiz.setDerecha(EliminarRecursivo(raiz.getDerecha(), raiz.getProducto().getCodigoProducto()));
        }
        return raiz;
    }

    private NodoConcesionArbol MinimoValor(NodoConcesionArbol raiz) {
        NodoConcesionArbol minimo = raiz;
        while (minimo.getIzquierda() != null) {
            minimo = minimo.getIzquierda();
        }
        return minimo;
    }

    private void agregarProductoBD(Producto producto) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO CONCESION (CodigoPoducto, Nombre, Descripcion, Precio, Stock) VALUES (?, ?, ?, ?, ?)";
            try {
                if (producto.getNombre() != null) {
                    PreparedStatement statement = conexion.prepareStatement(query);
                    statement.setInt(1, producto.getCodigoProducto());
                    statement.setString(2, producto.getNombre());
                    statement.setString(3, producto.getDescripcion());
                    statement.setDouble(5, producto.getPrecio());
                    statement.setInt(4, producto.getStock());
                    statement.executeUpdate();
                    System.out.println("El producto se agregó a la base de datos!!!");
                } else {
                    System.out.println("Error: El nombre del producto no puede ser null");
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

    private void eliminarProductoBD(int CodigoProducto) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "DELETE FROM CONCESION WHERE CodigoProducto = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, CodigoProducto);
                int rowCount = statement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Producto eliminado de la base de datos!!!");
                } else {
                    System.out.println("ERROR!! Producto no se encontró en la base de datos!!!!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
