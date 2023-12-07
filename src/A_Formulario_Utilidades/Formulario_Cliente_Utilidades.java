package A_Formulario_Utilidades;

import A_Clases.Cliente;
import Conexion.ConexionBD;
import Formatos.Mensajes;
import A_Estructura_Datos_Metodos.ListaEnlazada_Clientes;
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

public class Formulario_Cliente_Utilidades {

    DefaultTableModel model;
    ListaEnlazada_Clientes listaClientes;

    public Formulario_Cliente_Utilidades(DefaultTableModel model, ListaEnlazada_Clientes listaClientes) {
        this.model = model;
        this.listaClientes = listaClientes;
    }

    public void CargarDatosDesdeBaseDeDatos() {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM CLIENTE";
                ResultSet rs = stmt.executeQuery(sql);
                model.setRowCount(0);

                while (rs.next()) {
                    int Dni = rs.getInt("Dni");
                    String Nombre = rs.getString("Nombre");
                    String Apellido = rs.getString("Apellido");
                    String Correo = rs.getString("Correo");
                    String NumeroContacto = rs.getString("NumeroContacto");

                    model.addRow(new Object[]{Dni, Nombre, Apellido, Correo, NumeroContacto});
                }

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Mensajes.M1("La conexion a la base de datos falló");

        }
    }

    public void AgregarClienteTabla(DefaultTableModel model, JTextField jtxtDni, JTextField jtxtNombre, JTextField jtxtApellido, JTextField jtxtCorreo, JTextField jtxtNumeroContacto) {

        int Dni = Integer.parseInt(jtxtDni.getText());
        String Nombre = jtxtNombre.getText();
        String Apellido = jtxtApellido.getText();
        String Correo = jtxtCorreo.getText();
        String NumeroContacto = jtxtNumeroContacto.getText();

        Cliente nuevoCliente = new Cliente(Dni, Nombre, Apellido, Correo, NumeroContacto);

        listaClientes.agregarCliente(nuevoCliente);

        model.addRow(new Object[]{Dni, Nombre, Apellido, Correo, NumeroContacto});

        jtxtDni.setText("");
        jtxtNombre.setText("");
        jtxtApellido.setText("");
        jtxtCorreo.setText("");
        jtxtNumeroContacto.setText("");

//        jlblCantidad.setText("Número de Elementos: " + listaPeliculas.numElementos);
        Mensajes.M1("Se agregó el cliente con éxito");
    }

    public void EliminarClientePorDni(DefaultTableModel model, JTextField jtxtDni, JLabel jlblCantidad) {

        int Dni = Integer.parseInt(jtxtDni.getText());

        listaClientes.elimanrCliente(Dni);
        // Actualizar la tabla
        for (int row = 0; row < model.getRowCount(); row++) {
            int DniEnTabla = (int) model.getValueAt(row, 0);
            if (DniEnTabla == Dni) {
                model.removeRow(row);
                break;
            }
        }

        jtxtDni.setText("");

        jlblCantidad.setText("Número de Elementos: " + listaClientes.numElementos);
        Mensajes.M1("Se eliminó el cliente con éxito");
    }

    public void BuscarClientePorDni(DefaultTableModel model, JTable jTable, JTextField jtxtDni, JTextField jtxtNombre, JTextField jtxtApellido, JTextField jtxtCorreo, JTextField jtxtNumeroContacto, JLabel jlblCantidad) {
        try {
            int Dni = Integer.parseInt(jtxtDni.getText());
            boolean DniEncontrado = false;

            for (int row = 0; row < model.getRowCount(); row++) {
                int codigoEnTabla = (int) model.getValueAt(row, 0);
                if (codigoEnTabla == Dni) {
                    jTable.setRowSelectionInterval(row, row); // Selecciona la fila
                    DniEncontrado = true;
                    break;
                }
            }

            if (!DniEncontrado) {
                Cliente cliente = listaClientes.buscarClientePorDni(Dni);
                if (cliente != null) {
                    // Si se encontró la película en la lista, muestra los datos en los campos correspondientes
                    jtxtDni.setText(String.valueOf(cliente.getDni()));
                    jtxtNombre.setText(cliente.getNombre());
                    jtxtApellido.setText(cliente.getApellido());
                    jtxtCorreo.setText(cliente.getCorreo());
                    jtxtNumeroContacto.setText(cliente.getNumeroContacto());
                } else {

                    jtxtDni.setText("");
                    jtxtNombre.setText("");
                    jtxtApellido.setText("");
                    jtxtCorreo.setText("");
                    jtxtNumeroContacto.setText("");
                    Mensajes.M1("El cliente no se encontró en la lista");
                }
            }
        } catch (NumberFormatException e) {
            Mensajes.M1("Por favor, ingrese un DNI válido para la búsqueda.");
        }
    }
    
        public void OrdenarTabla(JRadioButton jrtbColumnaNombreCliente, JComboBox<String> jcbxOrdenamiento) {
        int columnaOrdenamiento = jrtbColumnaNombreCliente.isSelected() ? 1 : 0; // Cambiado a 3 para ordenar por sueldo si no es por nombre
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoSeleccionPorNombre();
                } else {
                    OrdenamientoSeleccionPorDni();
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoBurbujaPorNombre();
                } else {
                    OrdenamientoBurbujaPorDni();
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoQuicksortPorNombre();
                } else {
                    OrdenamientoQuicksortPorDni();
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

    public void OrdenamientoSeleccionPorNombre() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                String nombre1 = (String) model.getValueAt(j, 1); // Columna del nombre
                String nombre2 = (String) model.getValueAt(minIndex, 1); // Columna del nombre

                if (nombre1.compareToIgnoreCase(nombre2) < 0) {
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
    public void OrdenamientoSeleccionPorDni() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                int Dni1 = (int) model.getValueAt(j, 0); // Columna del sueldo
                int Dni2 = (int) model.getValueAt(minIndex, 0); // Columna del sueldo

                if (Dni1 < Dni2) {
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
    public void OrdenamientoBurbujaPorNombre() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                String nombre1 = (String) model.getValueAt(j, 1); // Columna del nombre
                String nombre2 = (String) model.getValueAt(j + 1, 1); // Columna del nombre

                if (nombre1.compareToIgnoreCase(nombre2) > 0) {

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
    public void OrdenamientoBurbujaPorDni() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                int Dni1 = (int) model.getValueAt(j, 0); // Columna del sueldo
                int Dni2 = (int) model.getValueAt(j + 1, 0); // Columna del sueldo

                if (Dni1 > Dni2) {

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
    public void OrdenamientoQuicksortPorNombre() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorNombre(low, high);
    }

    private void QuicksortPorNombre(int low, int high) {
        if (low < high) {
            int pi = partitionPorNombre(low, high);

            QuicksortPorNombre(low, pi - 1);
            QuicksortPorNombre(pi + 1, high);
        }
    }

    private int partitionPorNombre(int low, int high) {
        String pivot = (String) model.getValueAt(high, 1);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            String nombreJ = (String) model.getValueAt(j, 1);

            if (nombreJ.compareToIgnoreCase(pivot) < 0) {
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
    public void OrdenamientoQuicksortPorDni() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorDni(low, high);
    }

    private void QuicksortPorDni(int low, int high) {
        if (low < high) {
            int pi = partitionPorDni(low, high);

            QuicksortPorDni(low, pi - 1);
            QuicksortPorDni(pi + 1, high);
        }
    }

    private int partitionPorDni(int low, int high) {
        int pivot = (int) model.getValueAt(high, 0);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int DniJ = (int) model.getValueAt(j, 0);

            if (DniJ < pivot) {
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