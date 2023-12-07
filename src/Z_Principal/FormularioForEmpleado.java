package Z_Principal;

import Z_Formularios.FormularioCliente;
import Z_Formularios.FormularioConcesion;
import Z_Formularios.FormularioOrdenConcesion;
import Z_Formularios.FormularioPelicula;
import Z_Formularios.FormularioSala;
import Z_Formularios.FormularioCine;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
//import static java.awt.image.ImageObserver.HEIGHT;
//import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class FormularioForEmpleado extends javax.swing.JFrame {

    private JMenuItem mniClientes;
    private JMenuItem mniPeliculas;
    private JMenuItem mniCine;
    private JMenuItem mniSalas;
    private JMenuItem mniProductos;
    private JMenuItem mniOrdenes;
    private JMenuItem mniSalir;

    private String logo_Salir = "/Iconos/salir.png";
    private String logo_Productos = "/Iconos/productos.png";
    private String logo_Empleados = "/Iconos/user.png";
    private String logo_Cine = "/Iconos/busqueda.png";
    private String logo_Peliculas = "/Iconos/ticket.png";
    private String logo_Clientes = "/Iconos/clientes.png";
    private String logo_Ordenes = "/Iconos/ventas.png";
    private String logo_Salas = "/Iconos/inventario.png";

    private javax.swing.JInternalFrame formularioActual;

    public FormularioForEmpleado() {
        initComponents();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) screenSize.getWidth() / 2 - getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2 - getHeight() / 2;

        setLocation(centerX, centerY);

//      setSize(1010, 890);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mniClientes = new JMenuItem(" CLIENTES", getIcono(logo_Clientes));
        mniCine = new JMenuItem ("CINES", getIcono(logo_Cine));
        mniPeliculas = new JMenuItem(" PELICULAS", getIcono(logo_Peliculas));
        mniSalas = new JMenuItem(" SALAS", getIcono(logo_Salas));
        mniProductos = new JMenuItem(" PRODUCTOS", getIcono(logo_Productos));
        mniOrdenes = new JMenuItem(" ORDENES", getIcono(logo_Ordenes));
        mniSalir = new JMenuItem(" SALIR", getIcono(logo_Salir));


        jmbMenuPrincipal.add(mniClientes);
        jmbMenuPrincipal.add(mniCine);        
        jmbMenuPrincipal.add(mniPeliculas);
        jmbMenuPrincipal.add(mniSalas);
        jmbMenuPrincipal.add(mniProductos);
        jmbMenuPrincipal.add(mniOrdenes);
        jmbMenuPrincipal.add(mniSalir);

        mniClientes.addActionListener((ActionEvent e) -> {
            mostrarFormulario(new FormularioCliente());
        });
                mniCine.addActionListener((ActionEvent e) -> {
            mostrarFormulario(new FormularioCine());
        });
        mniPeliculas.addActionListener((ActionEvent e) -> {
            mostrarFormulario(new FormularioPelicula());
        });
        mniSalas.addActionListener((ActionEvent e) -> {
            mostrarFormulario(new FormularioSala());
        });
        mniProductos.addActionListener((ActionEvent e) -> {
            mostrarFormulario(new FormularioConcesion());
        });
        mniOrdenes.addActionListener((ActionEvent e) -> {
            mostrarFormulario(new FormularioOrdenConcesion());
        });
        mniSalir.addActionListener((ActionEvent e) -> { dispose();
            FormularioLogin formularioLogin = new FormularioLogin();
            formularioLogin.setVisible(true);
        });
    }

    private Icon getIcono(String ruta) {
        return new ImageIcon(new ImageIcon(getClass().getResource(ruta))
                .getImage().getScaledInstance(30, 30, 0));
    }

    private void mostrarFormulario(javax.swing.JInternalFrame formulario) {

        if (formularioActual != null && formularioActual != formulario) {
            formularioActual.dispose();
        }

        jdpPrincipal.removeAll();
        formularioActual = formulario;
        formulario.setVisible(true);
        jdpPrincipal.add(formulario);

//        jdpPrincipal.repaint();
//        this.setVisible(true);
//        formularioActual = formulario;
//        formulario.setVisible(true);
//        jdpPrincipal.add(formulario.getContentPane());
//        jdpPrincipal.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        jmbMenuPrincipal = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        setJMenuBar(jmbMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioForEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioForEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioForEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioForEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioForEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JMenuBar jmbMenuPrincipal;
    // End of variables declaration//GEN-END:variables
}