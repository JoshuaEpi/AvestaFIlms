package ArbolPeliculas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/proyecto_final_algoritmo";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection establecerConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
}
