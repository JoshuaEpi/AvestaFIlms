package Z_Principal;

import A_Formulario_Utilidades.Formulario_Login_Utilidades;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class FormularioLogin extends javax.swing.JFrame {

    Formulario_Login_Utilidades loginUtilidades;

    public FormularioLogin() {
        initComponents();

        loginUtilidades = new Formulario_Login_Utilidades(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int centerX = (int) screenSize.getWidth() / 2 - getWidth() / 2;
        int centerY = (int) screenSize.getHeight() / 2 - getHeight() / 2;

        setLocation(centerX, centerY);

//        setSize(460, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplBackground = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtContraseña = new javax.swing.JPasswordField();
        jtxtUsuario = new javax.swing.JTextField();
        jlblContraseña = new javax.swing.JLabel();
        jlblUsuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jspContraseña = new javax.swing.JSeparator();
        jSpUsuario = new javax.swing.JSeparator();
        jpnlIngresar = new javax.swing.JPanel();
        jlblIngresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jplBackground.setBackground(new java.awt.Color(255, 255, 255));
        jplBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 50)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LOGIN");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jplBackground.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 250, -1));

        jtxtContraseña.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jtxtContraseña.setForeground(new java.awt.Color(204, 204, 204));
        jtxtContraseña.setText("********");
        jtxtContraseña.setToolTipText("");
        jtxtContraseña.setBorder(null);
        jtxtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtxtContraseñaMousePressed(evt);
            }
        });
        jplBackground.add(jtxtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, 30));

        jtxtUsuario.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jtxtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        jtxtUsuario.setText("Ingrese su nombre de usuario");
        jtxtUsuario.setBorder(null);
        jtxtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtxtUsuarioMousePressed(evt);
            }
        });
        jplBackground.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 250, 30));

        jlblContraseña.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jlblContraseña.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblContraseña.setText("CONTRASEÑA");
        jplBackground.add(jlblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 150, 30));

        jlblUsuario.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jlblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblUsuario.setText("USUARIO");
        jplBackground.add(jlblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 30));

        jLabel3.setBackground(new java.awt.Color(51, 255, 255));
        jLabel3.setForeground(new java.awt.Color(153, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/open.png"))); // NOI18N
        jplBackground.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 520, 500));

        jspContraseña.setForeground(new java.awt.Color(0, 0, 0));
        jplBackground.add(jspContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 240, 20));

        jSpUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jplBackground.add(jSpUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 240, 20));

        jpnlIngresar.setBackground(new java.awt.Color(153, 153, 153));
        jpnlIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblIngresar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jlblIngresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblIngresar.setText("INICIAR SESION");
        jlblIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblIngresarMouseClicked(evt);
            }
        });
        jpnlIngresar.add(jlblIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jplBackground.add(jpnlIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtUsuarioMousePressed

        if (jtxtUsuario.getText().equalsIgnoreCase("Ingrese su nombre de usuario")) {
            jtxtUsuario.setText("");
            jtxtUsuario.setForeground(Color.black);
        }
        if (String.valueOf(jtxtContraseña.getPassword()).isEmpty()) {
            jtxtContraseña.setText("*********");
            jtxtContraseña.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jtxtUsuarioMousePressed

    private void jtxtContraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtxtContraseñaMousePressed

        if (jtxtUsuario.getText().isEmpty()) {
            jtxtUsuario.setText("Ingrese su nombre de usuario");
            jtxtUsuario.setForeground(Color.gray);
        }
        if (String.valueOf(jtxtContraseña.getPassword()).equals("********")) {
            jtxtContraseña.setText("");
            jtxtContraseña.setForeground(Color.black);
        }
    }//GEN-LAST:event_jtxtContraseñaMousePressed

    private void jlblIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblIngresarMouseClicked
        loginUtilidades.IniciarSesion(jtxtUsuario, jtxtContraseña);
    }//GEN-LAST:event_jlblIngresarMouseClicked

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
            java.util.logging.Logger.getLogger(FormularioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSpUsuario;
    private javax.swing.JLabel jlblContraseña;
    private javax.swing.JLabel jlblIngresar;
    private javax.swing.JLabel jlblUsuario;
    private javax.swing.JPanel jplBackground;
    private javax.swing.JPanel jpnlIngresar;
    private javax.swing.JSeparator jspContraseña;
    private javax.swing.JPasswordField jtxtContraseña;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables

}
