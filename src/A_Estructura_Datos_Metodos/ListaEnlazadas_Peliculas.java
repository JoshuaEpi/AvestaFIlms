package A_Estructura_Datos_Metodos;

import A_Nodos.NodoPelicula;
import A_Clases.Pelicula;
import Conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListaEnlazadas_Peliculas {

    private NodoPelicula nodoInicial;
    public int numElementos;

    public ListaEnlazadas_Peliculas() {
        this.nodoInicial = null;
        this.numElementos = 0;
    }

    public void agregarPelicula(Pelicula pelicula) {
        NodoPelicula nuevoNodo = new NodoPelicula(pelicula);
        if (nodoInicial == null) {
            nodoInicial = nuevoNodo;
        } else {
            NodoPelicula actual = nodoInicial;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }

        // Ahora, agrega la película a la base de datos usando la conexión
        agregarPeliculaBD(pelicula);
    }

    public void eliminarPelicula(int CodigoPelicula) {
        if (nodoInicial == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (nodoInicial.getPelicula().getCodigoPelicula() == CodigoPelicula) {
            nodoInicial = nodoInicial.getSiguiente();
            eliminarPeliculaBD(CodigoPelicula);
            return;
        }

        NodoPelicula actual = nodoInicial;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getPelicula().getCodigoPelicula() == CodigoPelicula) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                eliminarPeliculaBD(CodigoPelicula);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("La película no se encontró en la lista");
    }

    private void agregarPeliculaBD(Pelicula pelicula) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "INSERT INTO peliculas (CodigoPelicula, Titulo, Director, Genero, Duracion, ClasificacionEdad) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, pelicula.getCodigoPelicula());
                statement.setString(2, pelicula.getTitulo());
                statement.setString(3, pelicula.getDirector());
                statement.setString(4, pelicula.getGenero());
                statement.setInt(5, pelicula.getDuracion());
                statement.setString(6, pelicula.getClasificacionEdad());
                statement.executeUpdate();
                System.out.println("Pelicula agregada a la base de datos.");
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

    private void eliminarPeliculaBD(int CodigoPelicula) {
        Connection conexion = ConexionBD.establecerConexion();
        if (conexion != null) {
            String query = "DELETE FROM peliculas WHERE CodigoPelicula = ?";
            try {
                PreparedStatement statement = conexion.prepareStatement(query);
                statement.setInt(1, CodigoPelicula);
                int rowCount = statement.executeUpdate();
                if (rowCount > 0) {
                    System.out.println("Pelicula eliminada de la base de datos.");
                } else {
                    System.out.println("La película no se encontró en la base de datos.");
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

    public Pelicula buscarPeliculaPorCodigo(int CodigoPelicula) {

        NodoPelicula actual = nodoInicial;

        while (actual != null) {
            if (actual.getPelicula().getCodigoPelicula() == CodigoPelicula) {
                return actual.getPelicula();
            }
            actual = actual.getSiguiente();
        }

        return null;
    }
    
    //------------------------------------------------------------------------------------------------------------------------------------------------
    
    public Pelicula buscarPeliculaPorCodigoRecursivo(NodoPelicula nodoActual, int CodigoPelicula) {

        if (nodoActual == null) {
            return null;
        }

        if (nodoActual.getPelicula().getCodigoPelicula() == CodigoPelicula) {
            return nodoActual.getPelicula();
        }

        return buscarPeliculaPorCodigoRecursivo(nodoActual.getSiguiente(), CodigoPelicula);
    }

    public void EliminarPeliculamodoRecursivo(int CodigoPelicula) {
        nodoInicial = EliminarPeliculaRecursivo(nodoInicial, CodigoPelicula);
    }

    private NodoPelicula EliminarPeliculaRecursivo(NodoPelicula nodoActual, int CodigoPelicula) {

        if (nodoActual == null) {
            System.out.println("La Pelicula no se encontró en la lista");
            return null;
        }

        if (nodoActual.getPelicula().getCodigoPelicula() == CodigoPelicula) {
            eliminarPeliculaBD(CodigoPelicula);
            return nodoActual.getSiguiente();
        }

        nodoActual.setSiguiente(EliminarPeliculaRecursivo(nodoActual.getSiguiente(), CodigoPelicula));
        return nodoActual;
    }
}
