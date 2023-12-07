package A_Estructura_Datos_Metodos;
import A_Clases.Cines;
import Conexion.ConexionBD;
import A_Nodos.NodoCines;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListaEnlazada_Cines {
 
    private NodoCines nodoInicial;
    public int numElementos;

    public ListaEnlazada_Cines() {
        this.nodoInicial = null;
        this.numElementos = 0;
    }

    public void agregarCines(Cines cines) {
        NodoCines nuevoNodo = new NodoCines(cines);
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            NodoCines actual = nodoInicial;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }

         agregarCinesBD(cines);
    }

    public void elimanrCliente(int RUC) {
        if (nodoInicial == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (nodoInicial.getCines().getRUC() == RUC) {
            nodoInicial = nodoInicial.getSiguiente();
            eliminarCinesBD(RUC);
            return;
        }

        NodoCines actual = nodoInicial;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getCines().getRUC() == RUC) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                eliminarCinesBD(RUC);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("El Cine no se encontró en la lista");
    }

    private void agregarCinesBD(Cines cines) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO CINES (RUC, Gerente, Distrito, Direccion) VALUES (?, ?, ?, ?,)";
            try {
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, cines.getRUC());
                statement.setString(2, cines.getGerente());
                statement.setString(3, cines.getDistrito());
                statement.setString(4, cines.getDireccion());
                statement.executeUpdate();
                System.out.println("Cine agregado a la base de datos!!!");
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

    private void eliminarCinesBD(int RUC) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "DELETE FROM CINES WHERE RUC = ?";
            try {
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, RUC);
                int rowCount = statement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Cine eliminado de la base de datos!!!");
                } else {
                    System.out.println("ERROR!! El cine no se encontró en la base de datos!!!!");
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

    public Cines buscarCinesPorRUC(int RUC) {
        NodoCines nodoActual = nodoInicial;

        while (nodoActual != null) {
            if (nodoActual.getCines().getRUC() == RUC) {
                return nodoActual.getCines();
            }
            nodoActual = nodoActual.getSiguiente();
        }

        return null;
    }
    
    //----------------------ACTUALIZACION DE S11 RECUSIVO BUSCAR-----------------------------------
    public Cines buscarClientePorDniRecursivo(NodoCines nodoActual, int RUC) {

        if (nodoActual == null) {
            return null;
        }

        if (nodoActual.getCines().getRUC() == RUC) {
            return nodoActual.getCines();
        }

        return buscarCinesPorRUCRecursivo(nodoActual.getSiguiente(), RUC);
    }
    //----------------------ACTUALIZACION DE S11 RECUSIVO ELIMINAR-----------------------------------

    public void eliminarCliente(int RUC) {
        nodoInicial = eliminarCinesRecursivo(nodoInicial, RUC);
    }

    private NodoCines eliminarCinesRecursivo(NodoCines actual, int RUC) {

        if (actual == null) {
            System.out.println("El cine no se encontró en la lista");
            return null;
        }

        if (actual.getCines().getRUC() == RUC) {
            eliminarCinesBD(RUC);
            return actual.getSiguiente();
        }

        actual.setSiguiente(eliminarCinesRecursivo(actual.getSiguiente(), RUC));
        return actual;
    }

    private Cines buscarCinesPorRUCRecursivo(NodoCines siguiente, int RUC) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void eliminarCines(int RUC) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

