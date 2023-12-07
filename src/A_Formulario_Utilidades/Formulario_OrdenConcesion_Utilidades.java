package A_Formulario_Utilidades;

import A_Clases.OrdenConcesion;
import Conexion.ConexionBD;
import Formatos.Mensajes;
import A_Estructura_Datos_Metodos.Colas_OrdenConcesion;
import A_Nodos.NodoOrdenConcesion;
import java.awt.Point;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.sql.Statement;
import javax.swing.SwingUtilities;

public class Formulario_OrdenConcesion_Utilidades {

    DefaultTableModel model;
    Colas_OrdenConcesion listaOrdenConcesion_Colas;

    public Formulario_OrdenConcesion_Utilidades(DefaultTableModel model, Colas_OrdenConcesion listaOrdenConcesion_Colas) {
        this.model = model;
        this.listaOrdenConcesion_Colas = listaOrdenConcesion_Colas;
    }

    public void cargarDatosDesdeBaseDeDatos() {
        listaOrdenConcesion_Colas = new Colas_OrdenConcesion();
        try (Connection con = ConexionBD.establecerConexion()) {
            if (con != null) {
                String sql = "SELECT * FROM OrdenConcesion";
                try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

                    while (rs.next()) {
                        int NumeroOrden = rs.getInt("NumeroOrden");
                        String NombreCliente = rs.getString("NombreCliente");
                        String Producto = rs.getString("Producto");
                        int Cantidad = rs.getInt("Cantidad");
                        double PrecioUnitario = rs.getDouble("PrecioUnitario");
                        double Total = rs.getDouble("Total");

                        OrdenConcesion ordenConcesion = new OrdenConcesion(NumeroOrden, NombreCliente, Producto, Cantidad, PrecioUnitario, Total);
                        listaOrdenConcesion_Colas.encolar(ordenConcesion);
                    }
                }

            } else {
                Mensajes.M1("La conexión a la base de datos falló");
            }
        } catch (SQLException e) {
            // Manejo de la excepción: muestra un mensaje o realiza el registro según sea necesario
            e.printStackTrace();
        }
        actualizarTabla();
    }

    public void EnColarOrdenEnTabla(DefaultTableModel model, JTextField jtxtNumeroOrden, JTextField jtxtNombreCliente, JTextField jtxtProducto, JTextField jtxtCantidad, JTextField jtxtPrecioUnitario, JTextField jtxtTotal, Colas_OrdenConcesion listaOrdenConcesion_Colas) {
        int NumeroOrden = Integer.parseInt(jtxtNumeroOrden.getText());
        String NombreCliente = jtxtNombreCliente.getText();
        String Producto = jtxtProducto.getText();
        int Cantidad = Integer.parseInt(jtxtCantidad.getText());
        double PrecioUnitario = Double.parseDouble(jtxtPrecioUnitario.getText());
        double Total = Double.parseDouble(jtxtTotal.getText());

        OrdenConcesion ordenConcesion = new OrdenConcesion(NumeroOrden, NombreCliente, Producto, Cantidad, PrecioUnitario, Total);

        listaOrdenConcesion_Colas.encolarRecursivo(ordenConcesion);

        model.addRow(new Object[]{NumeroOrden, NombreCliente, Producto, Cantidad, PrecioUnitario, Total});

        model.fireTableDataChanged();

        jtxtNumeroOrden.setText("");
        jtxtNombreCliente.setText("");
        jtxtProducto.setText("");
        jtxtCantidad.setText("");
        jtxtPrecioUnitario.setText("");
        jtxtTotal.setText("");

        Mensajes.M1("Se agregó la orden con éxito a la cola");
    }

    public void DesencolarOrdenEnTabla(JTable jTable, DefaultTableModel model) {

        if (listaOrdenConcesion_Colas.EstaVacia()) {
            Mensajes.M1("La cola está vacía");
        } else {
            OrdenConcesion ordenConcesion = listaOrdenConcesion_Colas.desencolar();
            System.out.println("Orden desencolada: " + ordenConcesion);

            model = (DefaultTableModel) jTable.getModel();
            if (model.getRowCount() > 0) {
                model.removeRow(0);
                model.fireTableDataChanged();
            }
            System.out.println("Después de desencolar: Cola vacía = " + listaOrdenConcesion_Colas.EstaVacia());
        }
    }

    private void actualizarTabla() {
        model.setRowCount(0);

        NodoOrdenConcesion nodoActual = listaOrdenConcesion_Colas.getPrimeraOrden();
        while (nodoActual != null) {
            OrdenConcesion ordenConcesion = nodoActual.getOrdenConcesion();
            model.addRow(new Object[]{ordenConcesion.getNumeroOrden(), ordenConcesion.getNombreCliente(),
                ordenConcesion.getProducto(), ordenConcesion.getCantidad(), ordenConcesion.getPrecioUnitario(),
                ordenConcesion.getTotal()});
            nodoActual = nodoActual.getSiguiente();
        }
    }

    public void buscarPorNumeroOrdenSecuencial(JTable jTable, JTextField jtxtNumeroOrden) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rowCount = model.getRowCount();
        int numeroOrden = Integer.parseInt(jtxtNumeroOrden.getText());
        boolean encontrado = false;
        for (int i = 0; i < rowCount; i++) {
            int numOrdenTabla = (int) model.getValueAt(i, 0);
            if (numOrdenTabla == numeroOrden) {
                jTable.setRowSelectionInterval(i, i);
                scrollToVisible(jTable, i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            Mensajes.M1("El pedido con el número de orden " + numeroOrden + " ya se atendió.");
        }
        jtxtNumeroOrden.setText("");
    }

    public void buscarPorNumeroOrdenBinaria(JTable jTable, JTextField jtxtNumeroOrden) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int rowCount = model.getRowCount();
        int numeroOrden = Integer.parseInt(jtxtNumeroOrden.getText());
        int low = 0, high = rowCount - 1;
        boolean encontrado = false;
        while (low <= high) {
            int mid = (low + high) / 2;
            int numOrdenTabla = (int) model.getValueAt(mid, 0);
            if (numOrdenTabla == numeroOrden) {
                jTable.setRowSelectionInterval(mid, mid);
                scrollToVisible(jTable, mid);
                encontrado = true;
                break;
            } else if (numOrdenTabla < numeroOrden) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (!encontrado) {
            Mensajes.M1("El pedido con el número de orden " + numeroOrden + " ya se atendió.");
        }
        jtxtNumeroOrden.setText("");
    }

    private void scrollToVisible(JTable jTable, int rowIndex) {
        if (jTable.getParent() instanceof JViewport) {
            JViewport viewport = (JViewport) jTable.getParent();
            Rectangle rect = jTable.getCellRect(rowIndex, 0, true);
            Point pt = viewport.getViewPosition();
            rect.setLocation(rect.x - pt.x, rect.y - pt.y);
            viewport.scrollRectToVisible(rect);
        }
    }

    public void OrdenarTabla(JRadioButton jrtbColumnaNombreCliente, JRadioButton jrtbColumnaPrecioTotal, JComboBox<String> jcbxOrdenamiento) {

        int columnaOrdenamiento = jrtbColumnaNombreCliente.isSelected() ? 1 : 5;
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoSeleccionPorNombre();
                } else {
                    OrdenamientoSeleccionPorPrecioTotal();
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoBurbujaPorNombre();
                } else {
                    OrdenamientoBurbujaPorPrecioTotal();
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 1) {
                    OrdenamientoQuicksortPorNombre();
                } else {
                    OrdenamientoQuicksortPorPrecioTotal();
                }
            }
        }
    }

    // ____________________________ORDENAR POR SELECCION________________________________
    public void OrdenamientoSeleccionPorNombre() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                String nombre1 = (String) model.getValueAt(j, 1);
                String nombre2 = (String) model.getValueAt(minIndex, 1);

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

    // -------------------------
    public void OrdenamientoSeleccionPorPrecioTotal() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                double PrecioTotal1 = (double) model.getValueAt(j, 5);
                double PrecioTotal2 = (double) model.getValueAt(minIndex, 5);

                if (PrecioTotal1 < PrecioTotal2) {
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
    public void OrdenamientoBurbujaPorNombre() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                String nombre1 = (String) model.getValueAt(j, 1);
                String nombre2 = (String) model.getValueAt(j + 1, 1);
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
    public void OrdenamientoBurbujaPorPrecioTotal() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                double PrecioTotal1 = (double) model.getValueAt(j, 5);
                double PrecioTotal2 = (double) model.getValueAt(j + 1, 5);

                if (PrecioTotal1 > PrecioTotal2) {
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

                //                Intercambiar las filas
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

    // --------
    public void OrdenamientoQuicksortPorPrecioTotal() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorPrecioTotal(low, high);
    }

    private void QuicksortPorPrecioTotal(int low, int high) {
        if (low < high) {
            int pi = partitionPorPrecioTotal(low, high);

            QuicksortPorPrecioTotal(low, pi - 1);
            QuicksortPorPrecioTotal(pi + 1, high);
        }
    }

    private int partitionPorPrecioTotal(int low, int high) {
        double pivot = (double) model.getValueAt(high, 5);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            double sueldoJ = (double) model.getValueAt(j, 5);

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
}
