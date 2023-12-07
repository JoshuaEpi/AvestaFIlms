package Z_Formularios;

import A_Estructura_Datos_Metodos.HashTable_Salas;
import A_Formulario_Utilidades.Formulario_Sala_Utilidades;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class FormularioSala extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_Sala_Utilidades listaSalaUtilidades;
    HashTable_Salas listaSalas;

    public FormularioSala() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jrtbColumnaTipoSala);
        group.add(jrtbColumnaCapacidad);
        listaSalas = new HashTable_Salas(101);

        model = (DefaultTableModel) jTable.getModel();
        listaSalaUtilidades = new Formulario_Sala_Utilidades(model, listaSalas);
        listaSalaUtilidades.CargarDatosDesdeBaseDeDatos();

        //jlblCantidad.setText("Número de Elementos: " + listaEmpleadosHashTable.numElementos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLab_ListaSalas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtCapacidad = new javax.swing.JTextField();
        jtxtNumeroSala = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jrtbColumnaTipoSala = new javax.swing.JRadioButton();
        jrtbColumnaCapacidad = new javax.swing.JRadioButton();
        jbtnAgregar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jbtnOrdenar = new javax.swing.JButton();
        jcbxTipoSala = new javax.swing.JComboBox<>();
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jlblCantidad = new javax.swing.JLabel();
        jbtnVolver = new javax.swing.JToggleButton();
        jbtnContinuar = new javax.swing.JToggleButton();
        jbtnCargar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLab_ListaSalas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLab_ListaSalas.setText("LISTA DE SALAS");
        jPanel1.add(jLab_ListaSalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tipo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 60, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Sala N°");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 80, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Capacidad");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 90, 30));
        jPanel1.add(jtxtCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 100, 40));
        jPanel1.add(jtxtNumeroSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 100, 40));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero de Sala", "Capacidad", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 750, 470));

        jrtbColumnaTipoSala.setText("TipoSala");
        jPanel1.add(jrtbColumnaTipoSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jrtbColumnaCapacidad.setText("Capacidad");
        jPanel1.add(jrtbColumnaCapacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 110, 40));

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 110, 40));

        jbtnBuscar.setText("Buscar");
        jPanel1.add(jbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 110, 40));

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 110, 40));

        jcbxTipoSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2D", "3D", "D-BOX", " " }));
        jcbxTipoSala.setSelectedIndex(-1);
        jPanel1.add(jcbxTipoSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 140, 40));

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jPanel1.add(jcbxOrdenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 110, 40));

        jlblCantidad.setText("0");
        jPanel1.add(jlblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 720, 120, 40));

        jbtnVolver.setText("VOLVER");
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(692, 730, 100, 40));

        jbtnContinuar.setText("CONTINUAR");
        jbtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 730, -1, 40));

        jbtnCargar.setText("Cargar");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        listaSalaUtilidades.AgregarSalaTabla(model, jtxtNumeroSala, jtxtCapacidad, jcbxTipoSala);
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        listaSalaUtilidades.EliminarSalaPorNumero(model, jtxtNumeroSala, jlblCantidad);
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
        listaSalaUtilidades.OrdenarTabla(jrtbColumnaTipoSala, jcbxOrdenamiento);
    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed

    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jbtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnContinuarActionPerformed

    }//GEN-LAST:event_jbtnContinuarActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaSalaUtilidades.CargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLab_ListaSalas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JComboBox<String> jcbxTipoSala;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JRadioButton jrtbColumnaCapacidad;
    private javax.swing.JRadioButton jrtbColumnaTipoSala;
    private javax.swing.JTextField jtxtCapacidad;
    private javax.swing.JTextField jtxtNumeroSala;
    // End of variables declaration//GEN-END:variables
}
