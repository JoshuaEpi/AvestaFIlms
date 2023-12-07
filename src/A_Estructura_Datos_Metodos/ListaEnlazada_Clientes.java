package A_Estructura_Datos_Metodos;



import A_Nodos.NodoCliente;
import A_Clases.Cliente;
import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListaEnlazada_Clientes {

    private NodoCliente nodoInicial;
    public int numElementos;

    public ListaEnlazada_Clientes() {
        this.nodoInicial = null;
        this.numElementos = 0;
    }

    public void agregarCliente(Cliente cliente) {
        NodoCliente nuevoNodo = new NodoCliente(cliente);
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            NodoCliente actual = nodoInicial;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }

        agregarClienteBD(cliente);
    }

    public void elimanrCliente(int Dni) {
        if (nodoInicial == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (nodoInicial.getCliente().getDni() == Dni) {
            nodoInicial = nodoInicial.getSiguiente();
            eliminarClienteBD(Dni);
            return;
        }

        NodoCliente actual = nodoInicial;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getCliente().getDni() == Dni) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                eliminarClienteBD(Dni);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("La película no se encontró en la lista");
    }

    private void agregarClienteBD(Cliente cliente) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO CLIENTE (Dni, Nombre, Apellido, CorreoElectronico, NumeroContacto) "
                    + "VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, cliente.getDni());
                statement.setString(2, cliente.getNombre());
                statement.setString(3, cliente.getApellido());
                statement.setString(4, cliente.getCorreo());
                statement.setString(6, cliente.getNumeroContacto());
                statement.executeUpdate();
                System.out.println("Cliente agregado a la base de datos!!!");
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

    private void eliminarClienteBD(int Dni) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "DELETE FROM CLIENTE WHERE Dni = ?";
            try {
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, Dni);
                int rowCount = statement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Cliente eliminado de la base de datos!!!");
                } else {
                    System.out.println("ERROR!! El cliente no se encontró en la base de datos!!!!");
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

        //----------------------RECUSIVO Lineal-----------------------------------

    public Cliente buscarClientePorDni(int Dni) {
        NodoCliente nodoActual = nodoInicial;

        while (nodoActual != null) {
            if (nodoActual.getCliente().getDni() == Dni) {
                return nodoActual.getCliente();
            }
            nodoActual = nodoActual.getSiguiente();
        }

        return null;
    }

    //----------------------RECUSIVO BUSCAR-----------------------------------
    public Cliente buscarClientePorDniRecursivo(NodoCliente nodoActual, int dni) {

        if (nodoActual == null) {
            return null;
        }

        if (nodoActual.getCliente().getDni() == dni) {
            return nodoActual.getCliente();
        }

        return buscarClientePorDniRecursivo(nodoActual.getSiguiente(), dni);
    }
    //---------------------RECUSIVO ELIMINAR-----------------------------------

    public void eliminarCliente(int Dni) {
        nodoInicial = eliminarClienteRecursivo(nodoInicial, Dni);
    }

    private NodoCliente eliminarClienteRecursivo(NodoCliente actual, int Dni) {

        if (actual == null) {
            System.out.println("El cliente no se encontró en la lista");
            return null;
        }

        if (actual.getCliente().getDni() == Dni) {
            eliminarClienteBD(Dni);
            return actual.getSiguiente();
        }

        actual.setSiguiente(eliminarClienteRecursivo(actual.getSiguiente(), Dni));
        return actual;
    }
    //----------------------PRIMER DATO LO COMPARA CON TODOS-----------------------------------
    public void ordenarPorDniInsercion() {
        if (nodoInicial == null || nodoInicial.getSiguiente() == null) {
            return;
        }

        NodoCliente nodoActual, nodoComparado, nodoPrevio;
        Cliente temp;

        for (nodoActual = nodoInicial.getSiguiente(); nodoActual != null; nodoActual = nodoActual.getSiguiente()) {
            temp = nodoActual.getCliente();
            nodoComparado = nodoInicial;
            nodoPrevio = null;

            while (nodoComparado != nodoActual && nodoComparado.getCliente().getDni() > temp.getDni()) {
                nodoPrevio = nodoComparado;
                nodoComparado = nodoComparado.getSiguiente();
            }

            if (nodoPrevio == null) {
                // El nodo actual será el nuevo primero de la lista
                nodoInicial.setSiguiente(nodoActual.getSiguiente());
                nodoActual.setSiguiente(nodoInicial);
                nodoInicial = nodoActual;
            } else {
                nodoPrevio.setSiguiente(nodoActual);
                nodoActual.setSiguiente(nodoComparado);
            }
        }
    }
    //----------------------REVISA CADA ELEMENTO DE LA LISTA Y LO ORDENA-----------------------------------
    public void ordenarPorDniBurbuja() {
        boolean intercambio;
        NodoCliente nodoActual, nodoSiguiente;
        Cliente temp;

        do {
            intercambio = false;
            nodoActual = nodoInicial;

            while (nodoActual != null && nodoActual.getSiguiente() != null) {
                nodoSiguiente = nodoActual.getSiguiente();

                if (nodoActual.getCliente().getDni() > nodoSiguiente.getCliente().getDni()) {
                    // Intercambiar los datos de los clientes, no los nodos
                    temp = nodoActual.getCliente();
                    nodoActual.setCliente(nodoSiguiente.getCliente());
                    nodoSiguiente.setCliente(temp);

                    intercambio = true;
                }

                nodoActual = nodoSiguiente;
            }
        } while (intercambio);
    }
}
