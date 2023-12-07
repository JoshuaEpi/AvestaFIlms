package Z_Formularios;

import A_Estructura_Datos_Metodos.Colas_OrdenConcesion;
import A_Formulario_Utilidades.Formulario_OrdenConcesion_Utilidades;
import Formatos.Mensajes;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;

public class FormularioOrdenConcesion extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_OrdenConcesion_Utilidades listaOrdenConcesionUtilidades;
    Colas_OrdenConcesion listaOrdenConcesion_Colas = new Colas_OrdenConcesion();

    public FormularioOrdenConcesion() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jrtbColumnaNombreCliente);
        group.add(jrtbColumnaPrecioTotal);
        model = (DefaultTableModel) jTable.getModel();
        listaOrdenConcesionUtilidades = new Formulario_OrdenConcesion_Utilidades(model, listaOrdenConcesion_Colas);
        listaOrdenConcesionUtilidades.cargarDatosDesdeBaseDeDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtPrecioUnitario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtNumeroOrden = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtNombreCliente = new javax.swing.JTextField();
        jtxtProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtnDesencolar = new javax.swing.JButton();
        jbtnEncolar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jtxtTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbtnVolver = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jbtnCargar = new javax.swing.JButton();
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jrtbColumnaNombreCliente = new javax.swing.JRadioButton();
        jrtbColumnaPrecioTotal = new javax.swing.JRadioButton();
        jbtnOrdenar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("ORDEN CONCESION");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 347, -1));
        jPanel1.add(jtxtPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 100, -1));

        jLabel2.setText("Nro Orden");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 20));

        jLabel6.setText("Nombre del Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));
        jPanel1.add(jtxtNumeroOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 119, -1));

        jLabel4.setText("Producto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));
        jPanel1.add(jtxtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 134, -1));
        jPanel1.add(jtxtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 138, -1));

        jLabel3.setText("Total");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 70, -1));

        jbtnDesencolar.setText("Eliminar");
        jbtnDesencolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDesencolarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnDesencolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 100, 30));

        jbtnEncolar.setText("Agregar");
        jbtnEncolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEncolarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEncolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 100, 30));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numero de Orden", "Nombre Cliente", "Producto", "Cantidad", "Precio Unitario", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 880, 470));

        jLabel5.setText("Precio Unitario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 90, -1));

        jLabel1.setText("Cantidad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, 20));
        jPanel1.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 122, -1));
        jPanel1.add(jtxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 110, -1));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 100, 30));

        jbtnVolver.setText("VOLVER");
        jPanel1.add(jbtnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 740, 110, 30));

        jToggleButton2.setText("HOME");
        jPanel1.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 740, 100, 30));

        jbtnCargar.setText("CARGAR");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, -1, -1));

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jPanel1.add(jcbxOrdenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 80, -1, -1));

        jrtbColumnaNombreCliente.setText("Nombre");
        jPanel1.add(jrtbColumnaNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, 100, -1));

        jrtbColumnaPrecioTotal.setText("Precio Total");
        jPanel1.add(jrtbColumnaPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 100, -1));

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDesencolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDesencolarActionPerformed
        listaOrdenConcesionUtilidades.DesencolarOrdenEnTabla(jTable, model);
    }//GEN-LAST:event_jbtnDesencolarActionPerformed

    private void jbtnEncolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEncolarActionPerformed
        listaOrdenConcesionUtilidades.EnColarOrdenEnTabla(model, jtxtNumeroOrden, jtxtNombreCliente, jtxtProducto, jtxtCantidad, jtxtPrecioUnitario, jtxtTotal, listaOrdenConcesion_Colas);
    }//GEN-LAST:event_jbtnEncolarActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaOrdenConcesionUtilidades.cargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
        if (jrtbColumnaNombreCliente.isSelected() || jrtbColumnaPrecioTotal.isSelected()) {
            listaOrdenConcesionUtilidades.OrdenarTabla(jrtbColumnaNombreCliente, jrtbColumnaPrecioTotal, jcbxOrdenamiento);
        } else {
            Mensajes.M1("Por favor, seleccione una columna para ordenar.");
        }
        listaOrdenConcesionUtilidades.OrdenarTabla(jrtbColumnaNombreCliente, jrtbColumnaPrecioTotal, jcbxOrdenamiento);
    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    listaOrdenConcesionUtilidades.buscarPorNumeroOrdenSecuencial(jTable, jtxtNumeroOrden);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton jbtnCargar;
    private javax.swing.JButton jbtnDesencolar;
    private javax.swing.JButton jbtnEncolar;
    private javax.swing.JButton jbtnOrdenar;
    private javax.swing.JToggleButton jbtnVolver;
    private javax.swing.JComboBox<String> jcbxOrdenamiento;
    private javax.swing.JRadioButton jrtbColumnaNombreCliente;
    private javax.swing.JRadioButton jrtbColumnaPrecioTotal;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtNombreCliente;
    private javax.swing.JTextField jtxtNumeroOrden;
    private javax.swing.JTextField jtxtPrecioUnitario;
    private javax.swing.JTextField jtxtProducto;
    private javax.swing.JTextField jtxtTotal;
    // End of variables declaration//GEN-END:variables
}
