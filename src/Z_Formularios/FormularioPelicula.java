package Z_Formularios;

import A_Estructura_Datos_Metodos.ListaEnlazadas_Peliculas;
import A_Formulario_Utilidades.Formulario_Pelicula_Utilidades;
import Z_Formularios.FormularioPelicula;
import Z_Principal.INICIO;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

public class FormularioPelicula extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    Formulario_Pelicula_Utilidades listaPeliculaUtilidades;
    ListaEnlazadas_Peliculas listaPeliculas;

    public FormularioPelicula() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jrtbColumnaTituloPelicula);
        group.add(jrtbColumnaDuracion);
        listaPeliculas = new ListaEnlazadas_Peliculas();
        model = (DefaultTableModel) jTable.getModel();
        listaPeliculaUtilidades = new Formulario_Pelicula_Utilidades(model, listaPeliculas);
        listaPeliculaUtilidades.CargarDatosDesdeBaseDeDatos();

        jlblCantidad.setText("Número de Elementos: " + listaPeliculas.numElementos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtDirector = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtxtGenero = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jtxtCodigo = new javax.swing.JTextField();
        jbtnEliminar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jlblCantidad = new javax.swing.JLabel();
        jbtnVolver = new javax.swing.JToggleButton();
        jbtnContinuar = new javax.swing.JToggleButton();
        jcbxOrdenamiento = new javax.swing.JComboBox<>();
        jrtbColumnaTituloPelicula = new javax.swing.JRadioButton();
        jrtbColumnaDuracion = new javax.swing.JRadioButton();
        jbtnOrdenar = new javax.swing.JButton();
        jtxtClasificacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtDuracion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbtnCargar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("PELICULAS");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(390, 20, 210, 48);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Titulo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 150, 60, 30);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 100, 40, 30);
        jPanel1.add(jtxtTitulo);
        jtxtTitulo.setBounds(100, 150, 100, 30);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Clasificacion");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(440, 150, 80, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Director");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 100, 80, 30);
        jPanel1.add(jtxtDirector);
        jtxtDirector.setBounds(290, 100, 140, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Duracion");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(440, 100, 80, 30);
        jPanel1.add(jtxtGenero);
        jtxtGenero.setBounds(290, 150, 140, 30);

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar);
        jbtnAgregar.setBounds(830, 100, 90, 40);
        jPanel1.add(jtxtCodigo);
        jtxtCodigo.setBounds(100, 100, 100, 30);

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnEliminar);
        jbtnEliminar.setBounds(830, 160, 90, 40);

        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscar);
        jbtnBuscar.setBounds(830, 220, 90, 40);

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
        jbtnVolver.setBounds(740, 730, 72, 30);

        jbtnContinuar.setText("CONTINUAR");
        jbtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnContinuar);
        jbtnContinuar.setBounds(860, 730, 97, 30);

        jcbxOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Burbuja", "QuickSort" }));
        jcbxOrdenamiento.setSelectedIndex(-1);
        jPanel1.add(jcbxOrdenamiento);
        jcbxOrdenamiento.setBounds(830, 360, 90, 40);

        jrtbColumnaTituloPelicula.setText("Titulo");
        jPanel1.add(jrtbColumnaTituloPelicula);
        jrtbColumnaTituloPelicula.setBounds(830, 280, 53, 21);

        jrtbColumnaDuracion.setText("Duracion");
        jPanel1.add(jrtbColumnaDuracion);
        jrtbColumnaDuracion.setBounds(830, 320, 80, 21);

        jbtnOrdenar.setText("Ordenar");
        jbtnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOrdenarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnOrdenar);
        jbtnOrdenar.setBounds(830, 420, 90, 40);
        jPanel1.add(jtxtClasificacion);
        jtxtClasificacion.setBounds(540, 150, 180, 30);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Genero");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(210, 150, 70, 30);
        jPanel1.add(jtxtDuracion);
        jtxtDuracion.setBounds(540, 100, 180, 30);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TÍTULO", "GÉNERO", "DIRECTOR", "DURACIÓN", "CLASIFICACIÓN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setToolTipText("");
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 750, 500);

        jbtnCargar.setText("Cargar");
        jbtnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCargarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCargar);
        jbtnCargar.setBounds(830, 480, 90, 40);

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
        listaPeliculaUtilidades.AgregarPeliculaTabla(model, jtxtCodigo, jtxtTitulo, jtxtDirector, jtxtGenero, jtxtDuracion, jtxtClasificacion, jlblCantidad);
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        listaPeliculaUtilidades.EliminarPeliculaPorCodigo(model, jtxtCodigo, jlblCantidad);
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVolverActionPerformed
        INICIO inicio = new INICIO();

        // Hacer visible el nuevo formulario
        inicio.setVisible(true);

        // Ocultar el formulario INICIO
        this.setVisible(false);
    }//GEN-LAST:event_jbtnVolverActionPerformed

    private void jbtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnContinuarActionPerformed
        FormularioCliente formulariocliente = new FormularioCliente();

        // Hacer visible el nuevo formulario
        formulariocliente.setVisible(true);

        // Ocultar el formulario INICIO
        this.setVisible(false);
    }//GEN-LAST:event_jbtnContinuarActionPerformed

    private void jbtnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOrdenarActionPerformed
        listaPeliculaUtilidades.OrdenarTabla(jrtbColumnaTituloPelicula, jcbxOrdenamiento);
    }//GEN-LAST:event_jbtnOrdenarActionPerformed

    private void jbtnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCargarActionPerformed
        listaPeliculaUtilidades.CargarDatosDesdeBaseDeDatos();
    }//GEN-LAST:event_jbtnCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCargar;
    private javax.swing.JToggleButton jbtnContinuar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnOrdenar;
    private javax.swing.JToggleButton jbtnVolver;
    private javax.swing.JComboBox<String> jcbxOrdenamiento;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JRadioButton jrtbColumnaDuracion;
    private javax.swing.JRadioButton jrtbColumnaTituloPelicula;
    private javax.swing.JTextField jtxtClasificacion;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDirector;
    private javax.swing.JTextField jtxtDuracion;
    private javax.swing.JTextField jtxtGenero;
    private javax.swing.JTextField jtxtTitulo;
    // End of variables declaration//GEN-END:variables
}
