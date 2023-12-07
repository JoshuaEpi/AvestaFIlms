/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Formulario_Utilidades;


import A_Clases.Sala;
import A_Estructura_Datos_Metodos.HashTable_Salas;
import Conexion.ConexionBD;
import Formatos.Mensajes;
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

public class Formulario_Sala_Utilidades {

    DefaultTableModel model;
    HashTable_Salas listaSalas;

    public Formulario_Sala_Utilidades(DefaultTableModel model, HashTable_Salas listaSalas) {
        this.model = model;
        this.listaSalas = listaSalas;
    }

    public void CargarDatosDesdeBaseDeDatos() {
        Connection con = ConexionBD.establecerConexion();

        if (con != null) {
            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM SALA";
                ResultSet rs = stmt.executeQuery(sql);
                model.setRowCount(0);

                while (rs.next()) {
                    int NumeroSala = rs.getInt("NumeroSala");
                    int Capacidad = rs.getInt("Capacidad");
                    String TipoSala = rs.getString("TipoSala");

                    model.addRow(new Object[]{NumeroSala, Capacidad, TipoSala});
                }
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Mensajes.M1("La conexión a la base de datos falló");
        }
    }

    public void AgregarSalaTabla(DefaultTableModel model, JTextField jtxtNumeroSala, JTextField jtxtCapacidad, JComboBox<String> jcbxTipoSala) {
        try {
            int NumeroSala = Integer.parseInt(jtxtNumeroSala.getText());
            int Capacidad = Integer.parseInt(jtxtCapacidad.getText());
            String TipoSala = (String) jcbxTipoSala.getSelectedItem();

            Sala nuevaSala = new Sala(NumeroSala, Capacidad, TipoSala);

            listaSalas.InsertarSala(nuevaSala);

            model.addRow(new Object[]{NumeroSala, Capacidad, TipoSala});

            jtxtNumeroSala.setText("");
            jtxtCapacidad.setText("");
            jcbxTipoSala.setSelectedIndex(-1);

            Mensajes.M1("Se agregó la sala con éxito");
        } catch (NumberFormatException e) {
            Mensajes.M2("Error: Ingresa valores numéricos válidos para el Numero de la sala y el tipo de sala.");
        }
    }

    public void EliminarSalaPorNumero(DefaultTableModel model, JTextField jtxtNumeroSala, JLabel jlblCantidad) {

        int NumeroSala = Integer.parseInt(jtxtNumeroSala.getText());

        listaSalas.EliminarSalaPorNumero(NumeroSala);

        for (int row = 0; row < model.getRowCount(); row++) {
            int NumeroEnTabla = (int) model.getValueAt(row, 0);
            if (NumeroEnTabla == NumeroSala) {
                model.removeRow(row);
                break;
            }
        }

        jtxtNumeroSala.setText("");

        //    jlblCantidad.setText("Número de Elementos: " + listaEmpleadosHashTable.toString().numElementos);
        Mensajes.M1("Se eliminó la sala con éxito");
    }

    public void BuscarSalaPorNumero(DefaultTableModel model, JTable jTable, JTextField jtxtNumeroSala, JTextField jtxtCapacidad, JComboBox<String> jcbxTipoSala, JLabel jlblCantidad) {

        try {
            int NumeroSala = Integer.parseInt(jtxtNumeroSala.getText());
            boolean NumeroEncontrado = false;

            for (int row = 0; row < model.getRowCount(); row++) {
                int NumeroEnTabla = (int) model.getValueAt(row, 0);
                if (NumeroEnTabla == NumeroSala) {
                    jTable.setRowSelectionInterval(row, row);
                    NumeroEncontrado = true;
                    break;
                }
            }

            if (!NumeroEncontrado) {
                Sala sala = listaSalas.BuscarSalaporNumeroSala(NumeroSala);
                if (sala != null) {
                    jtxtNumeroSala.setText(String.valueOf(sala.getNumeroSala()));
                    jtxtCapacidad.setText(String.valueOf(sala.getCapacidad()));
                    jcbxTipoSala.setSelectedItem(sala.getTipoSala());
                } else {
 
                    jtxtNumeroSala.setText("");
                    jtxtCapacidad.setText("");
                    jcbxTipoSala.setSelectedIndex(-1);
                    Mensajes.M1("La sala no se encontró en la lista");
                }
            }
        } catch (NumberFormatException e) {
            Mensajes.M1("Por favor, ingrese un Número de Sala válido para la búsqueda.");
        }
    }

    public void OrdenarTabla(JRadioButton jrtbColumnaTipoSala, JComboBox<String> jcbxOrdenamiento) {
        int columnaOrdenamiento = jrtbColumnaTipoSala.isSelected() ? 2 : 1; // Cambiado a 3 para ordenar por sueldo si no es por nombre
        String algoritmoSeleccionado = (String) jcbxOrdenamiento.getSelectedItem();

        switch (algoritmoSeleccionado) {
            case "Seleccion" -> {
                if (columnaOrdenamiento == 2) {
                    OrdenamientoSeleccionPorTipoSala();
                } else {
                    OrdenamientoSeleccionPorCapacidad();
                }
            }
            case "Burbuja" -> {
                if (columnaOrdenamiento == 2) {
                    OrdenamientoBurbujaPorTipoSala();
                } else {
                    OrdenamientoBurbujaPorCapacidad();
                }
            }
            case "QuickSort" -> {
                if (columnaOrdenamiento == 2) {
                    OrdenamientoQuicksortTipoSala();
                } else {
                    OrdenamientoQuicksortPorCapacidad();
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

    public void OrdenamientoSeleccionPorTipoSala() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                String tiposala1 = (String) model.getValueAt(j, 2); // Columna del nombre
                String tiposala2 = (String) model.getValueAt(minIndex, 2); // Columna del nombre

                if (tiposala1.compareToIgnoreCase(tiposala2) < 0) {
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
    public void OrdenamientoSeleccionPorCapacidad() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < rowCount; j++) {
                int capacidad1 = (int) model.getValueAt(j, 1); // Columna del sueldo
                int capacidad2 = (int) model.getValueAt(minIndex, 1); // Columna del sueldo

                if (capacidad1 < capacidad2) {
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
    public void OrdenamientoBurbujaPorTipoSala() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                String tiposala1 = (String) model.getValueAt(j, 2); // Columna del nombre
                String tiposala2 = (String) model.getValueAt(j + 1, 2); // Columna del nombre

                if (tiposala1.compareToIgnoreCase(tiposala2) > 0) {

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
    public void OrdenamientoBurbujaPorCapacidad() {
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount - 1; i++) {
            for (int j = 0; j < rowCount - 1 - i; j++) {
                int capacidad1 = (int) model.getValueAt(j, 1); // Columna del sueldo
                int capacidad2 = (int) model.getValueAt(j + 1, 1); // Columna del sueldo

                if (capacidad1 > capacidad2) {

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
    public void OrdenamientoQuicksortTipoSala() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorTipoSala(low, high);
    }

    private void QuicksortPorTipoSala(int low, int high) {
        if (low < high) {
            int pi = partitionPorTipoSala(low, high);

            QuicksortPorTipoSala(low, pi - 1);
            QuicksortPorTipoSala(pi + 1, high);
        }
    }

    private int partitionPorTipoSala(int low, int high) {
        String pivot = (String) model.getValueAt(high, 2);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            String tiposalaJ = (String) model.getValueAt(j, 2);

            if (tiposalaJ.compareToIgnoreCase(pivot) < 0) {
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
    public void OrdenamientoQuicksortPorCapacidad() {
        int rowCount = model.getRowCount();
        int low = 0;
        int high = rowCount - 1;

        QuicksortPorCapacidad(low, high);
    }

    private void QuicksortPorCapacidad(int low, int high) {
        if (low < high) {
            int pi = partitionPorCapacidad(low, high);

            QuicksortPorCapacidad(low, pi - 1);
            QuicksortPorCapacidad(pi + 1, high);
        }
    }

    private int partitionPorCapacidad(int low, int high) {
        int pivot = (int) model.getValueAt(high, 2);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            int capacidadJ = (int) model.getValueAt(j, 2);

            if (capacidadJ < pivot) {
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
