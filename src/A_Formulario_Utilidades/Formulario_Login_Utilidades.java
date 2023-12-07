package A_Formulario_Utilidades;

import Conexion.ConexionBD;
import Formatos.Mensajes;
import Z_Principal.FormularioForAdministrador;
import Z_Principal.FormularioForEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Formulario_Login_Utilidades {

    Connection connection;
    JFrame FormularioLogin;

    public Formulario_Login_Utilidades(JFrame FormularioLogin) {
        this.FormularioLogin = FormularioLogin;
    }

    public void IniciarSesion(JTextField jtxtUsuario, JPasswordField jtxtContraseña) {

        connection = ConexionBD.establecerConexion();

        String usuario = jtxtUsuario.getText();
        String contraseña = new String(jtxtContraseña.getPassword());

        boolean loginSuccessful = verificarCredenciales(usuario, contraseña);

        if (loginSuccessful) {
            abrirSiguienteFormulario(usuario);
            Mensajes.M1("BIENVENIDO DE VUELTA!!!!");
        } else {
            Mensajes.M1("Error de inicio de sesión!!! Nombre de usuario o contraseña incorrectos");
        }
    }

    private boolean verificarCredenciales(String usuario, String contraseña) {
        try (Connection connection = ConexionBD.establecerConexion()) {
            String query = "SELECT * FROM USUARIOS WHERE Usuario = ? AND Contraseña = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, usuario);
                pstmt.setString(2, contraseña);
                try (ResultSet rs = pstmt.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void abrirSiguienteFormulario(String Usuario) {
        // Implementa la lógica para abrir el siguiente formulario según el rol del usuario
        // Puedes utilizar condicionales para determinar si es un administrador o un empleado.

        if (esAdministrador(Usuario)) {
            abrirFormularioAdministrador(Usuario);
        } else {
            abrirFormularioEmpleado(Usuario);
        }
    }

    private boolean esAdministrador(String Usuario) {
        try {
            String query = "SELECT Rol FROM USUARIOS WHERE Usuario = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, Usuario);
            ResultSet rs = pstmt.executeQuery();

            // Verifica el rol del usuario
            if (rs.next()) {
                String rol = rs.getString("Rol");
                return "Administrador".equals(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private void abrirFormularioAdministrador(String Usuario) {
        FormularioForAdministrador formularioParaAdministrador = new FormularioForAdministrador();
        formularioParaAdministrador.setVisible(true);
        FormularioLogin.dispose();  // Cierra la ventana actual (FormularioLogin)
    }

    private void abrirFormularioEmpleado(String Usuario) {
        FormularioForEmpleado formularioParaEmpleado = new FormularioForEmpleado();
        formularioParaEmpleado.setVisible(true);
    }

    public String obtenerNombreUsuarioDesdeBD(String nombreusuario) {
        try {
            String query = "SELECT Nombre FROM USUARIOS WHERE Usuario = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, nombreusuario);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("NombreUsuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Manejar el caso cuando no se puede obtener el nombre de usuario
    }
}
