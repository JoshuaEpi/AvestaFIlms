/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Z_Formularios;

import A_Estructura_Datos_Metodos.HashTable_Empleados;
import A_Formulario_Utilidades.Formulario_Empleado_Utilidades;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class FormularioEmpleado extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_Empleado_Utilidades listaEmpleadoUtilidades;
    HashTable_Empleados listaEmpleadosHashTable;

    /**
     * Creates new form FormularioEmpleadoss
     */
    public FormularioEmpleado() {
        initComponents();
        listaEmpleadosHashTable = new HashTable_Empleados(101);
        ButtonGroup group = new ButtonGroup();
        group.add(jrtbColumnaNombre);
        group.add(jrtbColumnaSueldo);
        model = (DefaultTableModel) jTable.getModel();
        listaEmpleadoUtilidades = new Formulario_Empleado_Utilidades(model, listaEmpleadosHashTable);
        listaEmpleadoUtilidades.CargarDatosDesdeBaseDeDatos();

        //jlblCantidad.setText("Número de Elementos: " + listaEmpleadosHashTable.numElementos);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtnEliminar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jbtnAgregar = new javax.swing.JButton();
        jlblCantidad = new javax.swing.JLabel();
        jbtnVolver = new javax.swing.JToggleButton();
        jbtnContinuar = new javax.swing.JToggleButton();
        jtxtCodigoEmpleado = new javax.swing.JTextField();
        jtxtTelefono = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jtxtSueldo = new javax.swing.JTextField();
        jtxtCargo = new javax.swing.JTextField();
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jbtnOrdenar = new javax.swing.JButton();
        jrtbColumnaSueldo = new javax.swing.JRadioButton();
        jrtbColumnaNombre = new javax.swing.JRadioButton();
        jbtnCargar = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jbtnEliminar1 = new javax.swing.JButton();
        jbtnBuscar1 = new javax.swing.JButton();
        jbtnAgregar1 = new javax.swing.JButton();
        jlblCantidad1 = new javax.swing.JLabel();
        jbtnVolver1 = new javax.swing.JToggleButton();
        jbtnContinuar1 = new javax.swing.JToggleButton();
        jtxtCodigoEmpleado1 = new javax.swing.JTextField();
        jtxtTelefono1 = new javax.swing.JTextField();
        jtxtNombre1 = new javax.swing.JTextField();
        jtxtApellido1 = new javax.swing.JTextField();
        jtxtSueldo1 = new javax.swing.JTextField();
        jtxtCargo1 = new javax.swing.JTextField();
        jcbxOrdenamiento1 = new javax.swing.JComboBox<>();
        jbtnOrdenar1 = new javax.swing.JButton();
        jrtbColumnaSueldo1 = new javax.swing.JRadioButton();
        jrtbColumnaNombre1 = new javax.swing.JRadioButton();
        jbtnCargar1 = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1000, 880));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(102, 255, 255));
        jPanel1.setLayout(null);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellidos", "Sueldo", "Cargo", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 230, 950, 480);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("EMPLEADOS");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 20, 211, 48);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TELEFONO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 160, 70, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("CODIGO");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 100, 60, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CARGO");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(510, 160, 60, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("NOMBRES");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 100, 70, 30);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("SUELDO");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 160, 60, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("APELLIDOS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(500, 100, 70, 30);

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEliminar);
        jbtnEliminar.setBounds(880, 30, 90, 40);

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscar);
        jbtnBuscar.setBounds(880, 80, 90, 30);

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar);
        jbtnAgregar.setBounds(780, 30, 90, 40);

        jlblCantidad.setText("0");
        jPanel1.add(jlblCantidad);
        jlblCantidad.setBounds(30, 740, 210, 30);

        jbtnVolver.setText("VOLVER");
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVolver);
        jbtnVolver.setBounds(700, 740, 120, 30);

        jbtnContinuar.setText("CONTINUAR");
        jbtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnContinuar);
        jbtnContinuar.setBounds(840, 740, 120, 30);
        jPanel1.add(jtxtCodigoEmpleado);
        jtxtCodigoEmpleado.setBounds(100, 100, 110, 30);
        jPanel1.add(jtxtTelefono);
        jtxtTelefono.setBounds(100, 160, 110, 30);
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(320, 100, 160, 30);
        jPanel1.add(jtxtApellido);
        jtxtApellido.setBounds(590, 100, 160, 30);
        jPanel1.add(jtxtSueldo);
        jtxtSueldo.setBounds(320, 160, 160, 30);
        jPanel1.add(jtxtCargo);
        jtxtCargo.setBounds(590, 160, 160, 30);

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort", "Insercion", "Shell" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jcbxOrdenamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jcbxOrdenamiento);
        jcbxOrdenamiento.setBounds(780, 120, 190, 30);

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar);
        jbtnOrdenar.setBounds(880, 170, 90, 30);

        jrtbColumnaSueldo.setText("Sueldo");
        jPanel1.add(jrtbColumnaSueldo);
        jrtbColumnaSueldo.setBounds(790, 190, 100, 21);

        jrtbColumnaNombre.setText("Nombre");
        jPanel1.add(jrtbColumnaNombre);
        jrtbColumnaNombre.setBounds(790, 160, 80, 21);

        jbtnCargar.setText("Cargar");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar);
        jbtnCargar.setBounds(780, 80, 90, 30);

        jInternalFrame1.setClosable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setForeground(new java.awt.Color(102, 255, 255));
        jPanel2.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellidos", "Sueldo", "Cargo", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 230, 950, 480);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setText("EMPLEADOS");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(390, 20, 211, 48);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("TELEFONO");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 160, 70, 30);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("CODIGO");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 100, 60, 30);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("CARGO");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(510, 160, 60, 30);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("NOMBRES");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(230, 100, 70, 30);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("SUELDO");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(240, 160, 60, 30);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("APELLIDOS");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(500, 100, 70, 30);

        jbtnEliminar1.setText("Eliminar");
        jbtnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnEliminar1);
        jbtnEliminar1.setBounds(880, 30, 90, 40);

        jbtnBuscar1.setText("Buscar");
        jbtnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnBuscar1);
        jbtnBuscar1.setBounds(880, 80, 90, 30);

        jbtnAgregar1.setText("Agregar");
        jbtnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnAgregar1);
        jbtnAgregar1.setBounds(780, 30, 90, 40);

        jlblCantidad1.setText("0");
        jPanel2.add(jlblCantidad1);
        jlblCantidad1.setBounds(30, 740, 210, 30);

        jbtnVolver1.setText("VOLVER");
        jbtnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolver1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnVolver1);
        jbtnVolver1.setBounds(740, 740, 100, 30);

        jbtnContinuar1.setText("CONTINUAR");
        jbtnContinuar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnContinuar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnContinuar1);
        jbtnContinuar1.setBounds(860, 740, 97, 30);
        jPanel2.add(jtxtCodigoEmpleado1);
        jtxtCodigoEmpleado1.setBounds(100, 100, 110, 30);
        jPanel2.add(jtxtTelefono1);
        jtxtTelefono1.setBounds(100, 160, 110, 30);
        jPanel2.add(jtxtNombre1);
        jtxtNombre1.setBounds(320, 100, 160, 30);
        jPanel2.add(jtxtApellido1);
        jtxtApellido1.setBounds(590, 100, 160, 30);
        jPanel2.add(jtxtSueldo1);
        jtxtSueldo1.setBounds(320, 160, 160, 30);
        jPanel2.add(jtxtCargo1);
        jtxtCargo1.setBounds(590, 160, 160, 30);

        jcbxOrdenamiento1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort", "Insercion", "Shell" }));
        jcbxOrdenamiento1.setSelectedIndex(-1);
        jcbxOrdenamiento1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jcbxOrdenamiento1);
        jcbxOrdenamiento1.setBounds(780, 120, 190, 30);

        jbtnOrdenar1.setText("Ordenar");
        jbtnOrdenar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnOrdenar1);
        jbtnOrdenar1.setBounds(880, 170, 90, 30);

        jrtbColumnaSueldo1.setText("Sueldo");
        jPanel2.add(jrtbColumnaSueldo1);
        jrtbColumnaSueldo1.setBounds(790, 190, 100, 21);

        jrtbColumnaNombre1.setText("Nombre");
        jPanel2.add(jrtbColumnaNombre1);
        jrtbColumnaNombre1.setBounds(790, 160, 80, 21);

        jbtnCargar1.setText("Cargar");
        jbtnCargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargar1ActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCargar1);
        jbtnCargar1.setBounds(780, 80, 90, 30);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 501, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 502, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 397, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 397, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        listaEmpleadoUtilidades.EliminarEmpleadoPorCodigo(model, jtxtCodigoEmpleado, jlblCantidad);
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        listaEmpleadoUtilidades.BuscarEmpleadoPorCodigo(model, jTable, jtxtCodigoEmpleado, jtxtNombre, jtxtApellido, jtxtSueldo, jtxtTelefono, jtxtCargo, jlblCantidad);
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        listaEmpleadoUtilidades.AgregarEmpleadoTabla(model, jtxtCodigoEmpleado, jtxtNombre, jtxtApellido, jtxtSueldo, jtxtTelefono, jtxtCargo);
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed

    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jbtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnContinuarActionPerformed

    }//GEN-LAST:event_jbtnContinuarActionPerformed

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
        listaEmpleadoUtilidades.OrdenarTabla(jrtbColumnaNombre, jcbxOrdenamiento);
    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaEmpleadoUtilidades.CargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed

    private void jbtnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnEliminar1ActionPerformed

    private void jbtnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscar1ActionPerformed

    private void jbtnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAgregar1ActionPerformed

    private void jbtnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolver1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnVolver1ActionPerformed

    private void jbtnContinuar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnContinuar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnContinuar1ActionPerformed

    private void jbtnOrdenar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnOrdenar1ActionPerformed

    private void jbtnCargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCargar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnAgregar1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnBuscar1;
    private javax.swing.JButton jbtnCargar;
    private javax.swing.JButton jbtnCargar1;
    private javax.swing.JToggleButton jbtnContinuar;
    private javax.swing.JToggleButton jbtnContinuar1;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnEliminar1;
    private javax.swing.JButton jbtnOrdenar;
    private javax.swing.JButton jbtnOrdenar1;
    private javax.swing.JToggleButton jbtnVolver;
    private javax.swing.JToggleButton jbtnVolver1;
    private javax.swing.JComboBox<String> jcbxOrdenamiento;
    private javax.swing.JComboBox<String> jcbxOrdenamiento1;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JLabel jlblCantidad1;
    private javax.swing.JRadioButton jrtbColumnaNombre;
    private javax.swing.JRadioButton jrtbColumnaNombre1;
    private javax.swing.JRadioButton jrtbColumnaSueldo;
    private javax.swing.JRadioButton jrtbColumnaSueldo1;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtApellido1;
    private javax.swing.JTextField jtxtCargo;
    private javax.swing.JTextField jtxtCargo1;
    private javax.swing.JTextField jtxtCodigoEmpleado;
    private javax.swing.JTextField jtxtCodigoEmpleado1;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNombre1;
    private javax.swing.JTextField jtxtSueldo;
    private javax.swing.JTextField jtxtSueldo1;
    private javax.swing.JTextField jtxtTelefono;
    private javax.swing.JTextField jtxtTelefono1;
    // End of variables declaration//GEN-END:variables
}
