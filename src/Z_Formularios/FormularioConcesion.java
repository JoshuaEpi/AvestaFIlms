package Z_Formularios;

import A_Estructura_Datos_Metodos.Arbol_Concesion;
import A_Formulario_Utilidades.Formulario_Concesion_Utilidades;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class FormularioConcesion extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_Concesion_Utilidades listaArbolConcesionUtilidades;
    Arbol_Concesion listaConcesionArbol;

    public FormularioConcesion() {
        initComponents();

        listaConcesionArbol = new Arbol_Concesion();
        ButtonGroup group = new ButtonGroup();
        group.add(jrtbColumnaNombreProducto);
        group.add(jrtbColumnaPrecio);
        model = (DefaultTableModel) jTable.getModel();
        listaArbolConcesionUtilidades = new Formulario_Concesion_Utilidades(model, listaConcesionArbol);
        listaArbolConcesionUtilidades.CargarDatosDesdeBaseDeDatos();

        //jlblCantidad.setText("Número de Elementos: " + listaEmpleadosHashTable.numElementos);
    }

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
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jrtbColumnaPrecio = new javax.swing.JRadioButton();
        jbtnOrdenar = new javax.swing.JButton();
        jtxtNombre = new javax.swing.JTextField();
        jtxtPrecio = new javax.swing.JTextField();
        jtxtDescripcion = new javax.swing.JTextField();
        jtxtStock = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jrtbColumnaNombreProducto = new javax.swing.JRadioButton();
        jtxtCodigoProducto = new javax.swing.JTextField();
        jlblCantidad = new javax.swing.JLabel();
        jbtnContinuar = new javax.swing.JToggleButton();
        jbtnVolver = new javax.swing.JToggleButton();
        jbtnCargar = new javax.swing.JButton();

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
                "Codigo Producto", "Nombre Producto", "Descripcion Producto", "Precio", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 200, 700, 510);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("CONCESION");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(370, 20, 204, 48);

        jLabel3.setText("Descripcion");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(360, 150, 80, 20);

        jLabel1.setText("Codigo del Producto");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 100, 130, 20);

        jLabel5.setText("Precio");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(390, 100, 50, 20);

        jLabel2.setText("Nombres del Producto");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 150, 140, 20);

        jLabel4.setText("Stock");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(580, 100, 50, 20);

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jPanel1.add(jcbxOrdenamiento);
        jcbxOrdenamiento.setBounds(810, 310, 120, 40);

        jrtbColumnaPrecio.setText("Precio");
        jPanel1.add(jrtbColumnaPrecio);
        jrtbColumnaPrecio.setBounds(810, 280, 80, 21);

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar);
        jbtnOrdenar.setBounds(810, 370, 120, 40);
        jPanel1.add(jtxtNombre);
        jtxtNombre.setBounds(180, 150, 110, 30);
        jPanel1.add(jtxtPrecio);
        jtxtPrecio.setBounds(440, 100, 90, 30);
        jPanel1.add(jtxtDescripcion);
        jtxtDescripcion.setBounds(440, 150, 280, 30);
        jPanel1.add(jtxtStock);
        jtxtStock.setBounds(630, 100, 90, 30);

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar);
        jbtnAgregar.setBounds(810, 80, 120, 40);

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEliminar);
        jbtnEliminar.setBounds(810, 140, 120, 40);

        jbtnBuscar.setText("Buscar");
        jPanel1.add(jbtnBuscar);
        jbtnBuscar.setBounds(810, 200, 120, 40);

        jrtbColumnaNombreProducto.setText("NombreProducto");
        jPanel1.add(jrtbColumnaNombreProducto);
        jrtbColumnaNombreProducto.setBounds(810, 250, 130, 21);
        jPanel1.add(jtxtCodigoProducto);
        jtxtCodigoProducto.setBounds(180, 100, 110, 30);

        jlblCantidad.setText("0");
        jPanel1.add(jlblCantidad);
        jlblCantidad.setBounds(40, 730, 140, 30);

        jbtnContinuar.setText("CONTINUAR");
        jbtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnContinuar);
        jbtnContinuar.setBounds(620, 730, 97, 23);

        jbtnVolver.setText("VOLVER");
        jbtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnVolver);
        jbtnVolver.setBounds(530, 730, 72, 23);

        jbtnCargar.setText("Cargar");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar);
        jbtnCargar.setBounds(810, 420, 120, 40);

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

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
        listaArbolConcesionUtilidades.OrdenarTabla(jrtbColumnaNombreProducto, jcbxOrdenamiento);
    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        listaArbolConcesionUtilidades.AgregarProductoTabla(model, jtxtCodigoProducto, jtxtNombre, jtxtDescripcion, jtxtPrecio, jtxtStock);
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        listaArbolConcesionUtilidades.EliminarProductoPorCodigo(model, jtxtCodigoProducto, jlblCantidad);
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnContinuarActionPerformed

    }//GEN-LAST:event_jbtnContinuarActionPerformed

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed

    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaArbolConcesionUtilidades.CargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JRadioButton jrtbColumnaNombreProducto;
    private javax.swing.JRadioButton jrtbColumnaPrecio;
    private javax.swing.JTextField jtxtCodigoProducto;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxtStock;
    // End of variables declaration//GEN-END:variables
}
