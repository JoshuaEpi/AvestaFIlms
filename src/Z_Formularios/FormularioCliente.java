/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Z_Formularios;

import A_Estructura_Datos_Metodos.ListaEnlazada_Clientes;
import A_Formulario_Utilidades.Formulario_Cliente_Utilidades;
import Z_Formularios.FormularioCliente;
import Z_Principal.INICIO;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;

public class FormularioCliente extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_Cliente_Utilidades listaClienteUtilidades;
    ListaEnlazada_Clientes listaClientes;

    public FormularioCliente() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jrtbColumnaNombreCliente);
        group.add(jrtbColumnaDNI);
        listaClientes = new ListaEnlazada_Clientes();
        model = (DefaultTableModel) jTable.getModel();
        listaClienteUtilidades = new Formulario_Cliente_Utilidades(model, listaClientes);
        listaClienteUtilidades.CargarDatosDesdeBaseDeDatos();

        jlblCantidad.setText("Número de Elementos: " + listaClientes.numElementos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtNumeroContacto = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jtxtDni = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jbtnEliminar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jlblCantidad = new javax.swing.JLabel();
        jbtnVolver = new javax.swing.JToggleButton();
        jbtnContinuar = new javax.swing.JToggleButton();
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jrtbColumnaNombreCliente = new javax.swing.JRadioButton();
        jrtbColumnaDNI = new javax.swing.JRadioButton();
        jbtnOrdenar = new javax.swing.JButton();
        jbtnCargar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellidos", "Correo", "Numero Contacto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 220, 940, 480);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("CLIENTES");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(400, 20, 160, 48);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CORREO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 160, 60, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("DNI");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 100, 40, 30);
        jPanel1.add(jtxtCorreo);
        jtxtCorreo.setBounds(100, 160, 280, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("NUMERO DE CONTACTO");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 160, 150, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("NOMBRES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 100, 80, 30);
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(290, 100, 170, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("APELLIDOS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(460, 100, 80, 30);
        jPanel1.add(jtxtNumeroContacto);
        jtxtNumeroContacto.setBounds(550, 160, 170, 30);

        jbtnAgregar.setText("AGREGAR");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar);
        jbtnAgregar.setBounds(750, 70, 90, 30);
        jPanel1.add(jtxtDni);
        jtxtDni.setBounds(100, 100, 100, 30);
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(550, 100, 170, 30);

        jbtnEliminar.setText("ELIMINAR");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEliminar);
        jbtnEliminar.setBounds(750, 120, 90, 30);

        jbtnBuscar.setText("BUSCAR");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscar);
        jbtnBuscar.setBounds(750, 170, 90, 30);

        jlblCantidad.setText("0");
        jPanel1.add(jlblCantidad);
        jlblCantidad.setBounds(30, 730, 200, 30);

        jbtnVolver.setText("VOLVER");
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVolver);
        jbtnVolver.setBounds(710, 730, 110, 30);

        jbtnContinuar.setText("CONTINUAR");
        jbtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnContinuar);
        jbtnContinuar.setBounds(847, 730, 110, 30);

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jPanel1.add(jcbxOrdenamiento);
        jcbxOrdenamiento.setBounds(860, 70, 86, 30);

        jrtbColumnaNombreCliente.setText("Nombre");
        jPanel1.add(jrtbColumnaNombreCliente);
        jrtbColumnaNombreCliente.setBounds(860, 140, 90, 20);

        jrtbColumnaDNI.setText("DNI");
        jPanel1.add(jrtbColumnaDNI);
        jrtbColumnaDNI.setBounds(860, 120, 90, 21);

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar);
        jbtnOrdenar.setBounds(860, 170, 90, 30);

        jbtnCargar.setText("CARGAR");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar);
        jbtnCargar.setBounds(810, 20, 90, 30);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        listaClienteUtilidades.AgregarClienteTabla(model, jtxtDni, jtxtNombre, jtxtApellido, jtxtCorreo, jtxtNumeroContacto);
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        listaClienteUtilidades.EliminarClientePorDni(model, jtxtDni, jlblCantidad);
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed

    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jbtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnContinuarActionPerformed

    }//GEN-LAST:event_jbtnContinuarActionPerformed

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
        listaClienteUtilidades.OrdenarTabla(jrtbColumnaNombreCliente, jcbxOrdenamiento);
    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaClienteUtilidades.CargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCargar;
    private javax.swing.JToggleButton jbtnContinuar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnOrdenar;
    private javax.swing.JToggleButton jbtnVolver;
    private javax.swing.JComboBox<String> jcbxOrdenamiento;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JRadioButton jrtbColumnaDNI;
    private javax.swing.JRadioButton jrtbColumnaNombreCliente;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtDni;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNumeroContacto;
    // End of variables declaration//GEN-END:variables
}
