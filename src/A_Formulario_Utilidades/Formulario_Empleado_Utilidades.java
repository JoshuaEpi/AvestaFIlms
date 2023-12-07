package A_Formulario_Utilidades;

import A_Clases.Empleado;
import Conexion.ConexionBD;
import Formatos.Mensajes;
import A_Estructura_Datos_Metodos.HashTable_Empleados;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Formulario_Empleado_Utilidades {

    DefaultTableModel model;
    HashTable_Empleados listaEmpleadosHashTable;

    public Formulario_Empleado_Utilidades(DefaultTableModel model, HashTable_Empleados listaEmpleadosHashTable) {
        this.model = model;
        this.listaEmpleadosHashTable = listaEmpleadosHashTable;
    }

    public void CargarDatosDesdeBaseDeDatos() {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM EMPLEADO";
                ResultSet rs = stmt.executeQuery(sql);
                model.setRowCount(0);

                while (rs.next()) {
                    int CodigoEmpleado = rs.getInt("CodigoEmpleado");
                    String Nombre = rs.getString("Nombre");
                    String Apellido = rs.getString("Apellido");
                    double Sueldo = rs.getDouble("Sueldo");  // Cambiado a getDouble para obtener un valor Double
                    String Telefono = rs.getString("Telefono");
                    String Cargo = rs.getString("Cargo");

                    model.addRow(new Object[]{CodigoEmpleado, Nombre, Apellido, Sueldo, Telefono, Cargo});
                }

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Mensajes.M1("La conexión a la base de datos falló");
        }
    }

    public void AgregarEmpleadoTabla(DefaultTableModel model, JTextField jtxtCodigoEmpleado, JTextField jtxtNombre, JTextField jtxtApellido, JTextField jtxtSueldo, JTextField jtxtTelefono, JTextField jtxtCargo) {
        try {
            int CodigoEmpleado = Integer.parseInt(jtxtCodigoEmpleado.getText());
            String Nombre = jtxtNombre.getText();
            String Apellido = jtxtApellido.getText();
            double Sueldo = Double.parseDouble(jtxtSueldo.getText());
            String Telefono = jtxtTelefono.getText();
            String Cargo = jtxtCargo.getText();

            Empleado nuevoEmpleado = new Empleado(CodigoEmpleado, Nombre, Apellido, Sueldo, Telefono, Cargo);

            listaEmpleadosHashTable.InsertarEmpleado(nuevoEmpleado);

            model.addRow(new Object[]{CodigoEmpleado, Nombre, Apellido, Sueldo, Telefono, Cargo});

            jtxtCodigoEmpleado.setText("");
            jtxtNombre.setText("");
            jtxtApellido.setText("");
            jtxtSueldo.setText("");
            jtxtTelefono.setText("");
            jtxtCargo.setText("");

            Mensajes.M1("Se agregó el empleado con éxito");
        } catch (NumberFormatException e) {
            Mensajes.M2("Error: Ingresa valores numéricos válidos para el código de empleado y sueldo.");
        }
    }

    public void EliminarEmpleadoPorCodigo(DefaultTableModel model, JTextField jtxtCodigoEmpleado, JLabel jlblCantidad) {

        int CodigoEmpleado = Integer.parseInt(jtxtCodigoEmpleado.getText());

        listaEmpleadosHashTable.EliminarEmpleadoporCodigo(CodigoEmpleado);

        for (int row = 0; row < model.getRowCount(); row++) {
            int CodigoEnTabla = (int) model.getValueAt(row, 0);
            if (CodigoEnTabla == CodigoEmpleado) {
                model.removeRow(row);
                break;
            }
        }

        jtxtCodigoEmpleado.setText("");

        //    jlblCantidad.setText("Número de Elementos: " + listaEmpleadosHashTable.toString().numElementos);
        Mensajes.M1("Se eliminó el empleado con éxito");
    }

    public void BuscarEmpleadoPorCodigo(DefaultTableModel model, JTable jTable, JTextField jtxtCodigoEmpleado, JTextField jtxtNombre, JTextField jtxtApellido, JTextField jtxtSueldo, JTextField jtxtTelefono, JTextField jtxtCargo, JLabel jlblCantidad) {

        try {
            int CodigoEmpleado = Integer.parseInt(jtxtCodigoEmpleado.getText());
            boolean CodigoEncontrado = false;

            for (int row = 0; row < model.getRowCount(); row++) {
                int CodigoEnTabla = (int) model.getValueAt(row, 0);
                if (CodigoEnTabla == CodigoEmpleado) {
                    jTable.setRowSelectionInterval(row, row); // Selecciona la fila
                    CodigoEncontrado = true;
                    break;
                }
            }

            if (!CodigoEncontrado) {
                Empleado empleado = listaEmpleadosHashTable.BuscarEmpleadoporCodigo(CodigoEmpleado);
                if (empleado != null) {

                    jtxtCodigoEmpleado.setText(String.valueOf(empleado.getCodigoEmpleado()));
                    jtxtNombre.setText(empleado.getNombre());
                    jtxtApellido.setText(empleado.getApellido());
                    jtxtSueldo.setText(String.valueOf(empleado.getSueldo()));
                    jtxtTelefono.setText(empleado.getTelefono());
                    jtxtCargo.setText(empleado.getCargo());

                } else {

                    jtxtCodigoEmpleado.setText("");
                    jtxtNombre.setText("");
                    jtxtApellido.setText("");
                    jtxtSueldo.setText("");
                    jtxtTelefono.setText("");
                    jtxtCargo.setText("");
                    Mensajes.M1("El Empleado no se encontró en la lista");
                }
            }
        } catch (NumberFormatException e) {
            Mensajes.M1("Por favor, ingrese un CODIGO válido para la búsqueda.");
        }
    }

    //-----------------------------METODOS ORDENAMIENTO------------------------------------
    //
    public void OrdenarTabla(JRadioButton jrtbColumnaNombre, JComboBox<String> jcbxOrdenamiento) {
        int columnaOrdenamiento = jrtbColumnaNombre.isSelected() ? 1 : 3; // Cambiado a 3 para ordenar por sueldo si no es por nombre
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoSeleccionPorNombre();
                } else {
                    OrdenamientoSeleccionPorSueldo(); // Cambiado a la versión por sueldo
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoBurbujaPorNombre();
                } else {
                    OrdenamientoBurbujaPorSueldo(); // Cambiado a la versión por sueldo
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoQuicksortPorNombre();
                } else {
                    OrdenamientoQuicksortPorSueldo(); // Cambiado a la versión por sueldo
                }
            }
            case "Insercion" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoInsercionPorNombre();
                } else {
                    OrdenamientoInsercionPorSueldo(); // Cambiado a la versión por sueldo
                }
            }
            case "Shell" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoShellPorNombre();
                } else {
                    OrdenamientoShellPorSueldo(); // Cambiado a la versión por sueldo
                }
            }
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

            // Intercambiar las filas
            for (int k = 0; k < model.getColumnCount(); k++) {
                Object temp = model.getValueAt(i, k);
                model.setValueAt(model.getValueAt(minIndex, k), i, k);
                model.setValueAt(temp, minIndex, k);
            }
        }
    }

    //-------------------------
    public void OrdenamientoSeleccionPorSueldo() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                double sueldo1 = (double) model.getValueAt(j, 3); // Columna del sueldo
                double sueldo2 = (double) model.getValueAt(minIndex, 3); // Columna del sueldo

                if (sueldo1 < sueldo2) {
                    minIndex = j;
                }
            }

            // Intercambiar las filas
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
                    // Intercambiar las filas
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
    public void OrdenamientoBurbujaPorSueldo() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                double sueldo1 = (double) model.getValueAt(j, 3); // Columna del sueldo
                double sueldo2 = (double) model.getValueAt(j + 1, 3); // Columna del sueldo

                if (sueldo1 > sueldo2) {
                    // Intercambiar las filas
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
        String pivot = (String) model.getValueAt(high, 1); // Columna del nombre
        int i = low - 1;

        for (int j = low; j < high; j++) {
            String nombreJ = (String) model.getValueAt(j, 1); // Columna del nombre

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

        // Intercambiar las filas
        for (int k = 0; k < model.getColumnCount(); k++) {
            Object temp = model.getValueAt(i + 1, k);
            model.setValueAt(model.getValueAt(high, k), i + 1, k);
            model.setValueAt(temp, high, k);
        }

        return i + 1;
    }

    //--------
    public void OrdenamientoQuicksortPorSueldo() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorSueldo(low, high);
    }

    private void QuicksortPorSueldo(int low, int high) {
        if (low < high) {
            int pi = partitionPorSueldo(low, high);

            QuicksortPorSueldo(low, pi - 1);
            QuicksortPorSueldo(pi + 1, high);
        }
    }

    private int partitionPorSueldo(int low, int high) {
        double pivot = (double) model.getValueAt(high, 3); // Columna del sueldo
        int i = low - 1;

        for (int j = low; j < high; j++) {
            double sueldoJ = (double) model.getValueAt(j, 3); // Columna del sueldo

            if (sueldoJ < pivot) {
                i++;

                // Intercambiar las filas
                for (int k = 0; k < model.getColumnCount(); k++) {
                    Object temp = model.getValueAt(i, k);
                    model.setValueAt(model.getValueAt(j, k), i, k);
                    model.setValueAt(temp, j, k);
                }
            }
        }

        // Intercambiar las filas
        for (int k = 0; k < model.getColumnCount(); k++) {
            Object temp = model.getValueAt(i + 1, k);
            model.setValueAt(model.getValueAt(high, k), i + 1, k);
            model.setValueAt(temp, high, k);
        }

        return i + 1;
    }

    //____________________________ORDENAR POR INSERCION________________________________
    //
    public void OrdenamientoInsercionPorNombre() {
        int rowCount = model.getRowCount();

        for (int i = 1; i < rowCount; i++) {
            String key = (String) model.getValueAt(i, 1); // Columna del nombre
            int j = i - 1;

            while (j >= 0 && ((String) model.getValueAt(j, 1)).compareToIgnoreCase(key) > 0) {
                // Desplazar las filas hacia arriba
                for (int k = 0; k < model.getColumnCount(); k++) {
                    model.setValueAt(model.getValueAt(j, k), j + 1, k);
                }

                j--;
            }

            // Insertar la fila en la posición correcta
            model.setValueAt(key, i, 1); // Corregido para insertar correctamente en la columna del nombre
        }
    }

//----------------------
    public void OrdenamientoInsercionPorSueldo() {
        int rowCount = model.getRowCount();

        for (int i = 1; i < rowCount; i++) {
            double key = (double) model.getValueAt(i, 3); // Columna del sueldo
            int j = i - 1;

            while (j >= 0 && (double) model.getValueAt(j, 3) > key) {
                // Desplazar las filas hacia arriba
                for (int k = 0; k < model.getColumnCount(); k++) {
                    model.setValueAt(model.getValueAt(j, k), j + 1, k);
                }

                j--;
            }

            // Insertar la fila en la posición correcta
            model.setValueAt(key, i, 3); // Corregido para insertar correctamente en la columna del sueldo
        }
    }

    //____________________________ORDENAR POR SHELL________________________________
    //
    public void OrdenamientoShellPorNombre() {
        int rowCount = model.getRowCount();
        int n = rowCount;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                String temp = (String) model.getValueAt(i, 1); // Columna del nombre
                int j = i;

                while (j >= gap && ((String) model.getValueAt(j - gap, 1)).compareToIgnoreCase(temp) > 0) {
                    // Desplazar las filas hacia arriba
                    for (int k = 0; k < model.getColumnCount(); k++) {
                        model.setValueAt(model.getValueAt(j - gap, k), j, k);
                    }

                    j -= gap;
                }

                // Insertar la fila en la posición correcta
                model.setValueAt(temp, j, 1); // Corregido para insertar correctamente en la columna del nombre
            }
        }
    }

    //------------------
    public void OrdenamientoShellPorSueldo() {
        int rowCount = model.getRowCount();
        int n = rowCount;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                double temp = (double) model.getValueAt(i, 3); // Columna del sueldo
                int j = i;

                while (j >= gap && (double) model.getValueAt(j - gap, 3) > temp) {
                    // Desplazar las filas hacia arriba
                    for (int k = 0; k < model.getColumnCount(); k++) {
                        model.setValueAt(model.getValueAt(j - gap, k), j, k);
                    }

                    j -= gap;
                }

                // Insertar la fila en la posición correcta
                model.setValueAt(temp, j, 3); // Corregido para insertar correctamente en la columna del sueldo
            }
        }
    }
}
