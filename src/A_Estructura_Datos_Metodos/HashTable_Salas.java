package A_Estructura_Datos_Metodos;

import A_Clases.Sala;
import A_Nodos.NodoSala;
import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HashTable_Salas {

    private int tamano;
    private int numElementos;
    private NodoSala[] tabla;

    public HashTable_Salas(int tamano) {
        this.tamano = tamano;
        this.numElementos = 0;
        this.tabla = new NodoSala[tamano];
    }

    private int Hash(int NumeroSala) {
        return NumeroSala % tamano;
    }

    public void InsertarSala(Sala sala) {
        int indice = Hash(sala.getNumeroSala());
        NodoSala nodoSala = tabla[indice];
        NodoSala nuevoNodo = new NodoSala();
        if (nodoSala == null) {
            tabla[indice] = nuevoNodo;
        } else {
            InsertarSalaRecursivo(nodoSala, nuevoNodo);

            //while (nodoEmpleado.getSiguiente()!=null){
            //    nodoEmpleado = nodoEmpleado.getSiguiente();
            //}
            //nodoEmpleado.setSiguiente(nuevoNodo);
        }
        agregarSalaBD(sala);
    }

    public void InsertarSalaRecursivo(NodoSala nodoActual, NodoSala nuevoNodo) {
        if (nodoActual.getSiguiente() == null) {
            nodoActual.setSiguiente(nuevoNodo);
            return;
        }
        InsertarSalaRecursivo(nodoActual.getSiguiente(), nuevoNodo);
    }

    public Sala BusquedaSecuencialSala(int NumeroSala) {
        for (int i = 0; i < tamano; i++) {
            NodoSala nodoSala = tabla[i];
            while (nodoSala != null) {
                if (nodoSala.getValor().getNumeroSala() == NumeroSala) {
                    return nodoSala.getValor();
                }
                nodoSala = nodoSala.getSiguiente();
            }
        }
        return null;
    }

    public Sala BuscarSalaporNumeroSala(int NumeroSala) {
        int indice = Hash(NumeroSala);
        NodoSala nodoSala = tabla[indice];
        while (nodoSala != null) {
            if (nodoSala.getValor().getNumeroSala() == NumeroSala) {
                return nodoSala.getValor();
            }
            nodoSala = nodoSala.getSiguiente();
        }
        return null;
    }

    public void EliminarSalaPorNumero(int NumeroSala) {
        int indice = Hash(NumeroSala);
        NodoSala nodoSala = tabla[indice];
        NodoSala nodoAnterior = null;

        while (nodoSala != null) {
            if (nodoSala.getValor() != null && nodoSala.getValor().getNumeroSala() == NumeroSala) {
                if (nodoAnterior == null) {
                    tabla[indice] = nodoSala.getSiguiente();
                } else {
                    nodoAnterior.setSiguiente(nodoSala.getSiguiente());
                }
                return;
            }
            nodoAnterior = nodoSala;
            nodoSala = nodoSala.getSiguiente();
        }

        eliminarSalaBD(NumeroSala);
    }

    private void agregarSalaBD(Sala sala) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO SALA (NumeroSala, Capacidad, TipoSala) VALUES (?, ?, ?)";
            try {
                // Verifica que el nombre no sea null antes de insertar en la base de datos
                if (sala.getTipoSala() != null) {
                    PreparedStatement statement = conexion.prepareStatement(query);
                    statement.setInt(1, sala.getNumeroSala());
                    statement.setInt(2, sala.getCapacidad());
                    statement.setString(3, sala.getTipoSala());
                    statement.executeUpdate();
                    System.out.println("Sala se agregó a la base de datos!!!");
                } else {
                    System.out.println("Error: El tipo de sala no puede ser null");
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
    private void eliminarSalaBD(int NumeroSala) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "DELETE FROM SALA WHERE NumeroSala = ?";
            try (PreparedStatement statement = conexion.prepareStatement(query)) {
                statement.setInt(1, NumeroSala);
                int rowCount = statement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Sala eliminado de la base de datos!!!");
                } else {
                    System.out.println("ERROR!! La sala no se encontró en la base de datos!!!!");
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
