package A_Formulario_Utilidades;
import A_Clases.Cines;
import Conexion.ConexionBD;
import Formatos.Mensajes;
import A_Estructura_Datos_Metodos.ListaEnlazada_Cines;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Formulario_Cine_Utilidades {
    

    DefaultTableModel model;
    ListaEnlazada_Cines listaCines;

    public Formulario_Cine_Utilidades(DefaultTableModel model, ListaEnlazada_Cines listaCines) {
        this.model = model;
        this.listaCines = listaCines;
    }

    public void CargarDatosDesdeBaseDeDatos() {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM CINES";
                ResultSet rs = stmt.executeQuery(sql);
                model.setRowCount(0);

                while (rs.next()) {
                    int RUC = rs.getInt("RUC");
                    String Gerente = rs.getString("Gerente");
                    String Distrito = rs.getString("Distrito");
                    String Direccion = rs.getString("Direccion");

                    model.addRow(new Object[]{RUC, Gerente, Distrito, Direccion});
                }

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Mensajes.M1("La conexion a la base de datos falló");

        }
    }

    public void AgregarCineTabla(DefaultTableModel model,JTextField jtxtRUC, JTextField jtxtDireccion, JTextField jtxtGerente, JTextField jtxtDistrito ) {

        int RUC = Integer.parseInt(jtxtRUC.getText());
        String Gerente = jtxtGerente.getText();
        String Distrito = jtxtDistrito.getText();
        String Direccion = jtxtDireccion.getText();

        Cines nuevoCines = new Cines(RUC, Gerente, Distrito, Direccion);

        listaCines.agregarCines(nuevoCines);

        model.addRow(new Object[]{RUC, Gerente, Distrito, Direccion});

        jtxtRUC.setText("");
        jtxtGerente.setText("");
        jtxtDistrito.setText("");
        jtxtDireccion.setText("");

//        jlblCantidad.setText("Número de Elementos: " + listaPeliculas.numElementos);
        Mensajes.M1("Se agregó el cine con éxito");
    }

    public void EliminarCinePorRUC(DefaultTableModel model, JTextField jtxtRUC, JTextField jlblCantidad, JTextField jtxtGerente, JTextField jtxtDistrito) {

        int RUC = Integer.parseInt(jtxtRUC.getText());

        listaCines.eliminarCines(RUC);
        // Actualizar la tabla
        for (int row = 0; row < model.getRowCount(); row++) {
            int RucEnTabla = (int) model.getValueAt(row, 0);
            if (RucEnTabla == RUC) {
                model.removeRow(row);
                break;
            }
        }

        jtxtRUC.setText("");

        jlblCantidad.setText("Número de Elementos: " + listaCines.numElementos);
        Mensajes.M1("Se eliminó el cine con éxito");
    }

    public void BuscarCinesPorRUC(DefaultTableModel model, JTable jTable, JTextField jtxtRUC, JTextField jtxtGerente, JTextField jtxtDistrito, JTextField jtxtDireccion,JLabel jlblCantidad) {
        try {
            int RUC = Integer.parseInt(jtxtRUC.getText());
            boolean RUCEncontrado = false;

            for (int row = 0; row < model.getRowCount(); row++) {
                int RucEnTabla = (int) model.getValueAt(row, 0);
                if (RucEnTabla == RUC) {
                    jTable.setRowSelectionInterval(row, row); // Selecciona la fila
                   RUCEncontrado = true;
                    break;
                }
            }

            if (!RUCEncontrado) {
                Cines Cines = listaCines.buscarCinesPorRUC(RUC);
                if (Cines != null) {
                    // Si se encontró el cine en la lista, muestra los datos en los campos correspondientes
                    jtxtRUC.setText(String.valueOf(Cines.getRUC()));
                    jtxtGerente.setText(Cines.getGerente());
                    jtxtDistrito.setText(Cines.getDistrito());
                    jtxtDireccion.setText(Cines.getDireccion());
                } else {

                    jtxtRUC.setText("");
                    jtxtGerente.setText("");
                    jtxtDistrito.setText("");
                    jtxtDireccion.setText("");
                    Mensajes.M1("El cine no se encontró en la lista");
                }
            }
        } catch (NumberFormatException e) {
            Mensajes.M1("Por favor, ingrese un RUC válido para la búsqueda.");
        }
    }
    public void OrdenarTabla(JRadioButton jrtbColumnaDistrito, JComboBox<String> jcbxOrdenamiento) {
        int columnaOrdenamiento = jrtbColumnaDistrito.isSelected() ? 2 : 0; // Cambiado a 3 para ordenar por sueldo si no es por nombre
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 2) {
                    OrdenamientoSeleccionPorDistrito();
                } else {
                    OrdenamientoSeleccionPorRuc();
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 2) {
                    OrdenamientoBurbujaPorDistrito();
                } else {
                    OrdenamientoBurbujaPorRuc();
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 2) {
                    OrdenamientoQuicksortPorDistrito();
                } else {
                    OrdenamientoQuicksortPorRuc();
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

    public void OrdenamientoSeleccionPorDistrito() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                String distrito1 = (String) model.getValueAt(j, 2); // Columna del nombre
                String distrito2 = (String) model.getValueAt(minIndex, 2); // Columna del nombre

                if (distrito1.compareToIgnoreCase(distrito2) < 0) {
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
    public void OrdenamientoSeleccionPorRuc() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                int Ruc1 = (int) model.getValueAt(j, 0); // Columna del sueldo
                int Ruc2 = (int) model.getValueAt(minIndex, 0); // Columna del sueldo

                if (Ruc1 < Ruc2) {
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
    public void OrdenamientoBurbujaPorDistrito() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                String distrito1 = (String) model.getValueAt(j, 2); // Columna del nombre
                String distrito2 = (String) model.getValueAt(j + 1, 2); // Columna del nombre

                if (distrito1.compareToIgnoreCase(distrito2) > 0) {

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
    public void OrdenamientoBurbujaPorRuc() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                int Ruc1 = (int) model.getValueAt(j, 0); // Columna del sueldo
                int Ruc2 = (int) model.getValueAt(j + 1, 0); // Columna del sueldo

                if (Ruc1 > Ruc2) {

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
    public void OrdenamientoQuicksortPorDistrito() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorDistrito(low, high);
    }

    private void QuicksortPorDistrito(int low, int high) {
        if (low < high) {
            int pi = partitionPorDistrito(low, high);

            QuicksortPorDistrito(low, pi - 1);
            QuicksortPorDistrito(pi + 1, high);
        }
    }

    private int partitionPorDistrito(int low, int high) {
        String pivot = (String) model.getValueAt(high, 2);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            String distritoJ = (String) model.getValueAt(j, 2);

            if (distritoJ.compareToIgnoreCase(pivot) < 0) {
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

    //--------
    public void OrdenamientoQuicksortPorRuc() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorRuc(low, high);
    }

    private void QuicksortPorRuc(int low, int high) {
        if (low < high) {
            int pi = partitionPorRuc(low, high);

            QuicksortPorRuc(low, pi - 1);
            QuicksortPorRuc(pi + 1, high);
        }
    }

    private int partitionPorRuc(int low, int high) {
        int pivot = (int) model.getValueAt(high, 0);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int RucJ = (int) model.getValueAt(j, 0);

            if (RucJ < pivot) {
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
