package Z_Formularios;

import A_Estructura_Datos_Metodos.ListaEnlazada_Cines;
import A_Formulario_Utilidades.Formulario_Cine_Utilidades;
import Z_Principal.INICIO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

public class FormularioCine extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_Cine_Utilidades listaCinesUtilidades;
    ListaEnlazada_Cines listaCines;


public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/PROYECTO_FINAL_ALGORITMO";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

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
public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new FormularioCine().setVisible(true);
        }
    });
}
    public FormularioCine() {
        initComponents();

        listaCines = new ListaEnlazada_Cines();
        
        model = (DefaultTableModel) jTable.getModel();
        listaCinesUtilidades = new Formulario_Cine_Utilidades(model, listaCines);
        listaCinesUtilidades.CargarDatosDesdeBaseDeDatos();

        jlblCantidad.setText("Número de Elementos: " + listaCines.numElementos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtDistrito = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtGerente = new javax.swing.JTextField();
        jtxtDireccion = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jtxtRUC = new javax.swing.JTextField();
        jbtnEliminar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jlblCantidad = new javax.swing.JLabel();
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jRadioButton2 = new javax.swing.JRadioButton();
        jbtnOrdenar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jrtbColumnaDistrito = new javax.swing.JRadioButton();
        jbtnCargar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("CINES");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 20, 210, 48);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Direccion");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(500, 100, 60, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("RUC");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 100, 40, 30);
        jPanel1.add(jtxtDistrito);
        jtxtDistrito.setBounds(410, 100, 80, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Gerente");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(160, 100, 60, 30);
        jPanel1.add(jtxtGerente);
        jtxtGerente.setBounds(230, 100, 120, 30);
        jPanel1.add(jtxtDireccion);
        jtxtDireccion.setBounds(570, 100, 200, 30);

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar);
        jbtnAgregar.setBounds(810, 100, 90, 40);
        jPanel1.add(jtxtRUC);
        jtxtRUC.setBounds(70, 100, 90, 30);

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEliminar);
        jbtnEliminar.setBounds(810, 160, 90, 40);

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscar);
        jbtnBuscar.setBounds(810, 220, 90, 40);
        jPanel1.add(jlblCantidad);
        jlblCantidad.setBounds(30, 610, 200, 30);

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jPanel1.add(jcbxOrdenamiento);
        jcbxOrdenamiento.setBounds(810, 360, 90, 40);

        jRadioButton2.setText("RUC");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(810, 320, 80, 21);

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar);
        jbtnOrdenar.setBounds(810, 420, 90, 40);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Distrito");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(350, 100, 50, 30);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC", "GERENTE", "DISTRITO", "DIRECCION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setToolTipText("");
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 170, 740, 440);

        jrtbColumnaDistrito.setText("Distrito");
        jPanel1.add(jrtbColumnaDistrito);
        jrtbColumnaDistrito.setBounds(810, 280, 61, 21);

        jbtnCargar.setText("Cargar");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar);
        jbtnCargar.setBounds(810, 480, 90, 40);

        jButton1.setText("Distancias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(810, 540, 90, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
listaCinesUtilidades.AgregarCineTabla(model, jtxtRUC, jtxtDireccion, jtxtGerente, jtxtDistrito);
    }//GEN-LAST:event_jbtnAgregarActionPerformed
    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
listaCinesUtilidades.EliminarCinePorRUC(model, jtxtRUC, jtxtDireccion, jtxtGerente, jtxtDistrito);

    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
 listaCinesUtilidades.BuscarCinesPorRUC(model, jTable, jtxtRUC, jtxtGerente, jtxtDistrito, jtxtDireccion, jlblCantidad);
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
      listaCinesUtilidades.OrdenarTabla(jrtbColumnaDistrito, jcbxOrdenamiento);

    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaCinesUtilidades.CargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
Grafos.Window newframe = new Grafos.Window();
newframe.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCargar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnOrdenar;
    private javax.swing.JComboBox<String> jcbxOrdenamiento;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JRadioButton jrtbColumnaDistrito;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtDistrito;
    private javax.swing.JTextField jtxtGerente;
    private javax.swing.JTextField jtxtRUC;
    // End of variables declaration//GEN-END:variables
}
