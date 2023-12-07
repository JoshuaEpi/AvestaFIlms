package A_Formulario_Utilidades;

import A_Clases.Producto;
import Conexion.ConexionBD;
import Formatos.Mensajes;
import A_Estructura_Datos_Metodos.Arbol_Concesion;
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

public class Formulario_Concesion_Utilidades {

    DefaultTableModel model;
    Arbol_Concesion listaConcesionArbol;

    public Formulario_Concesion_Utilidades(DefaultTableModel model, Arbol_Concesion listaConcesionArbol) {
        this.model = model;
        this.listaConcesionArbol = listaConcesionArbol;
    }

    public void CargarDatosDesdeBaseDeDatos() {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM CONCESION";
                ResultSet rs = stmt.executeQuery(sql);
                model.setRowCount(0);

                while (rs.next()) {
                    int CodigoProducto = rs.getInt("CodigoProducto");
                    String Nombre = rs.getString("Nombre");
                    String Descripcion = rs.getString("Descripcion");
                    double Precio = rs.getDouble("Precio");
                    int Stock = rs.getInt("Stock");

                    model.addRow(new Object[]{CodigoProducto, Nombre, Descripcion, Precio, Stock});
                }

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Mensajes.M1("La conexion a la base de datos falló");
        }
    }

    public void AgregarProductoTabla(DefaultTableModel model, JTextField jtxtCodigoProducto, JTextField jtxtNombre, JTextField jtxtDescripcion, JTextField jtxtPrecio, JTextField jtxtStock) {

        int CodigoProducto = Integer.parseInt(jtxtCodigoProducto.getText());
        String Nombre = jtxtNombre.getText();
        String Descripcion = jtxtDescripcion.getText();
        double Precio = Double.parseDouble(jtxtPrecio.getText());
        int Stock = Integer.parseInt(jtxtStock.getText());

        Producto nuevoProducto = new Producto(CodigoProducto, Nombre, Descripcion, Precio, Stock);

        listaConcesionArbol.InsertarProducto(nuevoProducto);

        model.addRow(new Object[]{CodigoProducto, Nombre, Descripcion, Precio, Stock});

        jtxtCodigoProducto.setText("");
        jtxtNombre.setText("");
        jtxtDescripcion.setText("");
        jtxtPrecio.setText("");
        jtxtStock.setText("");

//        jlblCantidad.setText("Número de Elementos: " + listaPeliculas.numElementos);
        Mensajes.M1("Se agregó el producto con éxito");
    }

    public void EliminarProductoPorCodigo(DefaultTableModel model, JTextField jtxtCodigoProducto, JLabel jlblCantidad) {

        int CodigoProducto = Integer.parseInt(jtxtCodigoProducto.getText());

        listaConcesionArbol.EliminarProducto(CodigoProducto);

        for (int row = 0; row < model.getRowCount(); row++) {
            int CodigoProductoenTabla = (int) model.getValueAt(row, 0);
            if (CodigoProductoenTabla == CodigoProducto) {
                model.removeRow(row);
                break;
            }
        }

        jtxtCodigoProducto.setText("");

        jlblCantidad.setText("Número de Elementos: " + listaConcesionArbol.numElementos);
        Mensajes.M1("Se eliminó el cliente con éxito");
    }

    public void BuscarProductoPorCodigo(DefaultTableModel model, JTable jTable, JTextField jtxtCodigoProducto, JTextField jtxtNombre, JTextField jtxtDescripcion, JTextField jtxtPrecio, JTextField jtxtStock, JLabel jlblCantidad) {
        try {
            int CodigoProducto = Integer.parseInt(jtxtCodigoProducto.getText());
            boolean CodigoProductoEncontrado = false;

            for (int row = 0; row < model.getRowCount(); row++) {
                int CodigoProductoEnTabla = (int) model.getValueAt(row, 0);
                if (CodigoProductoEnTabla == CodigoProducto) {
                    jTable.setRowSelectionInterval(row, row); // Selecciona la fila
                    CodigoProductoEncontrado = true;
                    break;
                }
            }

            if (!CodigoProductoEncontrado) {
                Producto producto = listaConcesionArbol.BuscarProducto(CodigoProducto);
                if (producto != null) {

                    jtxtCodigoProducto.setText(String.valueOf(producto.getCodigoProducto()));
                    jtxtNombre.setText(producto.getNombre());
                    jtxtDescripcion.setText(producto.getDescripcion());
                    jtxtPrecio.setText(String.valueOf(producto.getPrecio()));
                    jtxtStock.setText(String.valueOf(producto.getStock()));
                } else {

                    jtxtCodigoProducto.setText("");
                    jtxtNombre.setText("");
                    jtxtDescripcion.setText("");
                    jtxtPrecio.setText("");
                    jtxtStock.setText("");
                    Mensajes.M1("El producto no se encontró en la lista");
                }
            }
        } catch (NumberFormatException e) {
            Mensajes.M1("Por favor, ingrese un Codigo válido para la búsqueda.");
        }
    }

    public void OrdenarTabla(JRadioButton jrtbColumnaNombreProducto, JComboBox<String> jcbxOrdenamiento) {
        int columnaOrdenamiento = jrtbColumnaNombreProducto.isSelected() ? 1 : 4;
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoSeleccionPorNombre();
                } else {
                    OrdenamientoSeleccionPorPrecio(); // Cambiado a la versión por sueldo
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoBurbujaPorNombre();
                } else {
                    OrdenamientoBurbujaPorPrecio(); // Cambiado a la versión por sueldo
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoQuicksortPorNombre();
                } else {
                    OrdenamientoQuicksortPorPrecio(); // Cambiado a la versión por sueldo
                }
            }
//            case "Insercion" -> {
//                if (columnaOrdenamiento == 1) {
//                    OrdenamientoInsercionPorNombre();
//                } else {
//                    OrdenamientoInsercionPorSueldo(); // Cambiado a la versión por sueldo
//                }
//            }
//            case "Shell" -> {
//                if (columnaOrdenamiento == 1) {
//                    OrdenamientoShellPorNombre();
//                } else {
//                    OrdenamientoShellPorSueldo(); // Cambiado a la versión por sueldo
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

            // Intercambiar las filas
            for (int k = 0; k < model.getColumnCount(); k++) {
                Object temp = model.getValueAt(i, k);
                model.setValueAt(model.getValueAt(minIndex, k), i, k);
                model.setValueAt(temp, minIndex, k);
            }
        }
    }

    //-------------------------
    public void OrdenamientoSeleccionPorPrecio() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                double precio1 = (double) model.getValueAt(j, 3); // Columna del sueldo
                double precio2 = (double) model.getValueAt(minIndex, 3); // Columna del sueldo

                if (precio1 < precio2) {
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
    public void OrdenamientoBurbujaPorPrecio() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                double precio1 = (double) model.getValueAt(j, 3); // Columna del sueldo
                double precio2 = (double) model.getValueAt(j + 1, 3); // Columna del sueldo

                if (precio1 > precio2) {
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
    public void OrdenamientoQuicksortPorPrecio() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorPrecio(low, high);
    }

    private void QuicksortPorPrecio(int low, int high) {
        if (low < high) {
            int pi = partitionPorPrecio(low, high);

            QuicksortPorPrecio(low, pi - 1);
            QuicksortPorPrecio(pi + 1, high);
        }
    }

    private int partitionPorPrecio(int low, int high) {
        double pivot = (double) model.getValueAt(high, 3);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            double precioJ = (double) model.getValueAt(j, 3);

            if (precioJ < pivot) {
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
}
