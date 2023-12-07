package A_Estructura_Datos_Metodos;

import A_Clases.Empleado;
import A_Nodos.NodoEmpleado;
import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HashTable_Empleados {

    private int tamano;
    private int numElementos;
    private NodoEmpleado[] tabla;

    public HashTable_Empleados(int tamano) {
        this.tamano = tamano;
        this.numElementos = 0;
        this.tabla = new NodoEmpleado[tamano];
    }

    private int Hash(int CodigoEmpleado) {
        return CodigoEmpleado % tamano;
    }

    //---------------------------------------------------------------------------------------
    public void InsertarEmpleado(Empleado empleado) {
        int indice = Hash(empleado.getCodigoEmpleado());
        NodoEmpleado nodoEmpleado = tabla[indice];
        NodoEmpleado nuevoNodo = new NodoEmpleado();
        if (nodoEmpleado == null) {
            tabla[indice] = nuevoNodo;
        } else {
            InsertarEmpleadoRecursivo(nodoEmpleado, nuevoNodo);

            //while (nodoEmpleado.getSiguiente()!=null){
            //    nodoEmpleado = nodoEmpleado.getSiguiente();
            //}
            //nodoEmpleado.setSiguiente(nuevoNodo);
        }
        agregarEmpleadoBD(empleado);
    }

    public void InsertarEmpleadoRecursivo(NodoEmpleado nodoActual, NodoEmpleado nuevoNodo) {
        if (nodoActual.getSiguiente() == null) {
            nodoActual.setSiguiente(nuevoNodo);
            return;
        }
        InsertarEmpleadoRecursivo(nodoActual.getSiguiente(), nuevoNodo);
    }

    //---------------------------------------------------------------------------------------
    public Empleado BusquedaSecuencialCodigoEmpleado(int CodigoEmpleado) {
        for (int i = 0; i < tamano; i++) {
            NodoEmpleado nodoEmpleado = tabla[i];
            while (nodoEmpleado != null) {
                if (nodoEmpleado.getValor().getCodigoEmpleado() == CodigoEmpleado) {
                    return nodoEmpleado.getValor();
                }
                nodoEmpleado = nodoEmpleado.getSiguiente();
            }
        }
        return null;
    }

    public Empleado BusquedaSecuencialNombre(String Nombre) {
        for (int i = 0; i < tamano; i++) {
            NodoEmpleado nodoEmpleado = tabla[i];
            while (nodoEmpleado != null) {
                if (nodoEmpleado.getValor().getNombre().equalsIgnoreCase(Nombre)) {
                    return nodoEmpleado.getValor();
                }
                nodoEmpleado = nodoEmpleado.getSiguiente();
            }
        }
        return null;
    }

    public Empleado BuscarEmpleadoporCodigo(int CodigoEmpleado) {
        int indice = Hash(CodigoEmpleado);
        NodoEmpleado nodoEmpleado = tabla[indice];
        while (nodoEmpleado != null) {
            if (nodoEmpleado.getValor().getCodigoEmpleado() == CodigoEmpleado) {
                return nodoEmpleado.getValor();
            }
            nodoEmpleado = nodoEmpleado.getSiguiente();
        }
        return null;
    }

    //---------------------------------------------------------------------------------------
    public void EliminarEmpleadoporCodigo(int CodigoEmpleado) {
        int indice = Hash(CodigoEmpleado);
        NodoEmpleado nodoEmpleado = tabla[indice];
        NodoEmpleado nodoAnterior = null;
        while (nodoEmpleado != null) {
            if (nodoEmpleado.getValor().getCodigoEmpleado() == CodigoEmpleado) {
                if (nodoAnterior == null) {
                    tabla[indice] = nodoEmpleado.getSiguiente();
                } else {
                    nodoAnterior.setSiguiente(nodoEmpleado.getSiguiente());
                }
                return;
            }
            nodoAnterior = nodoEmpleado;
            nodoEmpleado = nodoEmpleado.getSiguiente();
        }
        eliminarEmpleadoBD(CodigoEmpleado);
    }

    //----------------------------------------------------------------------------------------------
    private void agregarEmpleadoBD(Empleado empleado) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO EMPLEADO (CodigoEmpleado, Nombre, Apellido, Sueldo, Telefono, Cargo) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                // Verifica que el nombre no sea null antes de insertar en la base de datos
                if (empleado.getNombre() != null) {
                    PreparedStatement statement = conexion.prepareStatement(query);
                    statement.setInt(1, empleado.getCodigoEmpleado());
                    statement.setString(2, empleado.getNombre());
                    statement.setString(3, empleado.getApellido());
                    statement.setDouble(4, empleado.getSueldo());
                    statement.setString(5, empleado.getTelefono());
                    statement.setString(6, empleado.getCargo());
                    statement.executeUpdate();
                    System.out.println("Empleado se agregó a la base de datos!!!");
                } else {
                    System.out.println("Error: El nombre del empleado no puede ser null");
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

    //---------------------------------------------------------------------------------------
    private void eliminarEmpleadoBD(int CodigoEmpleado) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "DELETE FROM EMPLEADO WHERE CodigoEmpleado = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, CodigoEmpleado);
                int rowCount = statement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Empleado eliminado de la base de datos!!!");
                } else {
                    System.out.println("ERROR!! El Empleado no se encontró en la base de datos!!!!");
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
