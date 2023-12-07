/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CargarDatosDesdeBD {

    public static List<Pelicula> cargarPeliculasDesdeBD() {
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            // Establecer la conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_final_algoritmo", "root", "");

            // Consulta SQL para obtener los datos de las películas
            String consulta = "SELECT CodigoPelicula, Titulo, Director, Genero, Duracion, ClasificacionEdad FROM Pelicula";
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Ejecutar la consulta
            ResultSet resultSet = statement.executeQuery();

            // Recorrer los resultados y crear instancias de Pelicula
            while (resultSet.next()) {
                int codigoPelicula = resultSet.getInt("CodigoPelicula");
                String titulo = resultSet.getString("Titulo");
                String director = resultSet.getString("Director");
                String genero = resultSet.getString("Genero");
                int duracion = resultSet.getInt("Duracion");
                String clasificacionEdad = resultSet.getString("ClasificacionEdad");

                Pelicula pelicula = new Pelicula(codigoPelicula, titulo, director, genero, duracion, clasificacionEdad);
                peliculas.add(pelicula);
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return peliculas;
    }
}

