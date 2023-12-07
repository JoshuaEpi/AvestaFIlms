package A_Formulario_Utilidades;

import A_Clases.Pelicula;
import Conexion.ConexionBD;
import Formatos.Mensajes;
import A_Estructura_Datos_Metodos.ListaEnlazadas_Peliculas;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Formulario_Pelicula_Utilidades {

    DefaultTableModel model;
    ListaEnlazadas_Peliculas listaPeliculas; // Debes crear una instancia de tu lista de películas

    public Formulario_Pelicula_Utilidades(DefaultTableModel model, ListaEnlazadas_Peliculas listaPeliculas) {
        this.model = model;
        this.listaPeliculas = listaPeliculas;
    }

    public void CargarDatosDesdeBaseDeDatos() {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM PELICULA";
                ResultSet rs = stmt.executeQuery(sql);
                model.setRowCount(0);

                while (rs.next()) {
                    int CodigoPelicula = rs.getInt("CodigoPelicula");
                    String Titulo = rs.getString("Titulo");
                    String Director = rs.getString("Director");
                    String Genero = rs.getString("Genero");
                    int Duracion = rs.getInt("Duracion");
                    String ClasificacionEdad = rs.getString("ClasificacionEdad");

                    model.addRow(new Object[]{CodigoPelicula, Titulo, Director, Genero, Duracion, ClasificacionEdad});
                }

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // La conexión falló, maneja el error apropiadamente
        }
    }

    public void AgregarPeliculaTabla(DefaultTableModel model, JTextField jtxtCodigo, JTextField jtxtTitulo, JTextField jtxtDirector, JTextField jtxtGenero, JTextField jtxtDuracion, JTextField jtxtClasificacion, JLabel jlblCantidad) {

        int CodigoPelicula = Integer.parseInt(jtxtCodigo.getText());
        String Titulo = jtxtTitulo.getText();
        String Director = jtxtDirector.getText();
        String Genero = jtxtGenero.getText();
        int Duracion = Integer.parseInt(jtxtDuracion.getText());
        String ClasificacionEdad = jtxtClasificacion.getText();

        Pelicula nuevaPelicula = new Pelicula(CodigoPelicula, Titulo, Director, Genero, Duracion, ClasificacionEdad);

        listaPeliculas.agregarPelicula(nuevaPelicula);

        model.addRow(new Object[]{CodigoPelicula, Titulo, Director, Genero, Duracion, ClasificacionEdad});

        jtxtCodigo.setText("");
        jtxtTitulo.setText("");
        jtxtDirector.setText("");
        jtxtGenero.setText("");
        jtxtDuracion.setText("");
        jtxtClasificacion.setText("");

//        jlblCantidad.setText("Número de Elementos: " + listaPeliculas.numElementos);
        Mensajes.M1("Se agregó la película con éxito");
    }

    public void EliminarPeliculaPorCodigo(DefaultTableModel model, JTextField jtxtCodigo, JLabel jlblCantidad) {

        int CodigoPelicula = Integer.parseInt(jtxtCodigo.getText());

        listaPeliculas.eliminarPelicula(CodigoPelicula);
        // Actualizar la tabla
        for (int row = 0; row < model.getRowCount(); row++) {
            int codigoEnTabla = (int) model.getValueAt(row, 0);
            if (codigoEnTabla == CodigoPelicula) {
                model.removeRow(row);
                break;
            }
        }

        jtxtCodigo.setText("");

        jlblCantidad.setText("Número de Elementos: " + listaPeliculas.numElementos);
        Mensajes.M1("Se eliminó la película con éxito");
    }

    public void BuscarPeliculaPorCodigo(DefaultTableModel model, JTable jTable, JTextField jtxtCodigo, JTextField jtxtTitulo, JTextField jtxtDirector, JTextField jtxtGenero, JTextField jtxtDuracion, JTextField jtxtClasificacion, JLabel jlblCantidad) {
        try {
            int CodigoPelicula = Integer.parseInt(jtxtCodigo.getText());
            boolean peliculaEncontrada = false;

            for (int row = 0; row < model.getRowCount(); row++) {
                int codigoEnTabla = (int) model.getValueAt(row, 0);
                if (codigoEnTabla == CodigoPelicula) {
                    jTable.setRowSelectionInterval(row, row); // Selecciona la fila
                    peliculaEncontrada = true;
                    break;
                }
            }

            if (!peliculaEncontrada) {
                Pelicula pelicula = listaPeliculas.buscarPeliculaPorCodigo(CodigoPelicula);
                if (pelicula != null) {
                    // Si se encontró la película en la lista, muestra los datos en los campos correspondientes
                    jtxtTitulo.setText(pelicula.getTitulo());
                    jtxtDirector.setText(pelicula.getDirector());
                    jtxtGenero.setText(pelicula.getGenero());
                    jtxtDuracion.setText(String.valueOf(pelicula.getDuracion()));
                    jtxtClasificacion.setText(pelicula.getClasificacionEdad());
                } else {
                    // Si no se encontró la película ni en la tabla ni en la lista, limpia los campos
                    jtxtTitulo.setText("");
                    jtxtDirector.setText("");
                    jtxtGenero.setText("");
                    jtxtDuracion.setText("");
                    jtxtClasificacion.setText("");
                    Mensajes.M1("La película no se encontró en la lista");
                }
            }
        } catch (NumberFormatException e) {
            Mensajes.M1("Por favor, ingrese un código válido para la búsqueda.");
        }
    }
    
    public void OrdenarTabla(JRadioButton jrtbColumnaTituloPelicula, JComboBox<String> jcbxOrdenamiento) {
        int columnaOrdenamiento = jrtbColumnaTituloPelicula.isSelected() ? 1 : 4;
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoSeleccionPorTitulo();
                } else {
                    OrdenamientoSeleccionPorDuracion();
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoBurbujaPorTitulo();
                } else {
                    OrdenamientoBurbujaPorDuracion();
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoQuicksortTitulo();
                } else {
                    OrdenamientoQuicksortPorDuracion();
                }
            }
//            case "Insercion" -> {
//                if (columnaOrdenamiento == 1) {
//                    OrdenamientoInsercionPorNombre();
//                } else {
//                    OrdenamientoInsercionPorSueldo();
//                }
//            }
//            case "Shell" -> {
//                if (columnaOrdenamiento == 1) {
//                    OrdenamientoShellPorNombre();
//                } else {
//                    OrdenamientoShellPorSueldo();
//                }
//            }
        }

    }
    //____________________________ORDENAR POR SELECCION________________________________
    //

    public void OrdenamientoSeleccionPorTitulo() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                String titulo1 = (String) model.getValueAt(j, 1); // Columna del nombre
                String titulo2 = (String) model.getValueAt(minIndex, 1); // Columna del nombre

                if (titulo1.compareToIgnoreCase(titulo2) < 0) {
                    minIndex = j;
                }
            }

            for (int k = 0; k < model.getColumnCount(); k++) {
                Object temp = model.getValueAt(i, k);
                model.setValueAt(model.getValueAt(minIndex, k), i, k);
                model.setValueAt(temp, minIndex, k);
            }
        }
    }

    //-------------------------
    public void OrdenamientoSeleccionPorDuracion() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                int duracion1 = (int) model.getValueAt(j, 4); // Columna del sueldo
                int duracion2 = (int) model.getValueAt(minIndex, 4); // Columna del sueldo

                if (duracion1 < duracion2) {
                    minIndex = j;
                }
            }

            for (int k = 0; k < model.getColumnCount(); k++) {
                Object temp = model.getValueAt(i, k);
                model.setValueAt(model.getValueAt(minIndex, k), i, k);
                model.setValueAt(temp, minIndex, k);
            }
        }
    }

    //____________________________ORDENAR POR BURBUJA________________________________
    //
    public void OrdenamientoBurbujaPorTitulo() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                String titulo1 = (String) model.getValueAt(j, 1); // Columna del nombre
                String titulo2 = (String) model.getValueAt(j + 1, 1); // Columna del nombre

                if (titulo1.compareToIgnoreCase(titulo2) > 0) {

                    for (int k = 0; k < model.getColumnCount(); k++) {
                        Object temp = model.getValueAt(j, k);
                        model.setValueAt(model.getValueAt(j + 1, k), j, k);
                        model.setValueAt(temp, j + 1, k);
                    }
                }
            }
        }
    }

    //--------------------
    public void OrdenamientoBurbujaPorDuracion() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                int duracion1 = (int) model.getValueAt(j, 4); // Columna del sueldo
                int duracion2 = (int) model.getValueAt(j + 1, 4); // Columna del sueldo

                if (duracion1 > duracion2) {

                    for (int k = 0; k < model.getColumnCount(); k++) {
                        Object temp = model.getValueAt(j, k);
                        model.setValueAt(model.getValueAt(j + 1, k), j, k);
                        model.setValueAt(temp, j + 1, k);
                    }
                }
            }
        }
    }

    //____________________________ORDENAR POR QUICKSORT________________________________
    //
    public void OrdenamientoQuicksortTitulo() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorTitulo(low, high);
    }

    private void QuicksortPorTitulo(int low, int high) {
        if (low < high) {
            int pi = partitionPorTitulo(low, high);

            QuicksortPorTitulo(low, pi - 1);
            QuicksortPorTitulo(pi + 1, high);
        }
    }

    private int partitionPorTitulo(int low, int high) {
        String pivot = (String) model.getValueAt(high, 1);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            String tituloJ = (String) model.getValueAt(j, 1);

            if (tituloJ.compareToIgnoreCase(pivot) < 0) {
                i++;

                // Intercambiar las filas
                for (int k = 0; k < model.getColumnCount(); k++) {
                    Object temp = model.getValueAt(i, k);
                    model.setValueAt(model.getValueAt(j, k), i, k);
                    model.setValueAt(temp, j, k);
                }
            }
        }

        for (int k = 0; k < model.getColumnCount(); k++) {
            Object temp = model.getValueAt(i + 1, k);
            model.setValueAt(model.getValueAt(high, k), i + 1, k);
            model.setValueAt(temp, high, k);
        }
        return i + 1;
    }

    //--------
    public void OrdenamientoQuicksortPorDuracion() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorDuracion(low, high);
    }

    private void QuicksortPorDuracion(int low, int high) {
        if (low < high) {
            int pi = partitionPorDuracion(low, high);

            QuicksortPorDuracion(low, pi - 1);
            QuicksortPorDuracion(pi + 1, high);
        }
    }

    private int partitionPorDuracion(int low, int high) {
        int pivot = (int) model.getValueAt(high, 4);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int duracionJ = (int) model.getValueAt(j, 4);

            if (duracionJ < pivot) {
                i++;

                for (int k = 0; k < model.getColumnCount(); k++) {
                    Object temp = model.getValueAt(i, k);
                    model.setValueAt(model.getValueAt(j, k), i, k);
                    model.setValueAt(temp, j, k);
                }
            }
        }

        for (int k = 0; k < model.getColumnCount(); k++) {
            Object temp = model.getValueAt(i + 1, k);
            model.setValueAt(model.getValueAt(high, k), i + 1, k);
            model.setValueAt(temp, high, k);
        }
        return i + 1;
    }

    //____________________________ORDENAR POR INSERCION________________________________
    //
}
