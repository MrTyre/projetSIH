/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet.UI;
    
import javax.swing.JFrame;
import javax.swing.JOptionPane;

   

/**
 *
 * @author Manounette
 */
public class ServiceInformatiqueIU extends javax.swing.JFrame {
    
     private ServiceInformatiqueAjouterPersonnelIU siap;
     private ServiceInformatiqueAjouterServiceIU sias;
     private ServiceInformatiqueModifierPersonnel simp;
    /**
     * Creates new form ServiceInformatiqueIU
     */
    public ServiceInformatiqueIU() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
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
        jLabelServiceInformatique = new javax.swing.JLabel();
        jButtonAjouterService = new javax.swing.JButton();
        jButtonAjouterPersonnel = new javax.swing.JButton();
        jButtonModifierPersonnel = new javax.swing.JButton();
        jButtonDeconnexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelServiceInformatique.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelServiceInformatique.setForeground(new java.awt.Color(0, 51, 153));
        jLabelServiceInformatique.setText("Service Informatique");

        jButtonAjouterService.setBackground(new java.awt.Color(0, 51, 153));
        jButtonAjouterService.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAjouterService.setText("Ajouter service");
        jButtonAjouterService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterServiceActionPerformed(evt);
            }
        });

        jButtonAjouterPersonnel.setBackground(new java.awt.Color(0, 51, 153));
        jButtonAjouterPersonnel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAjouterPersonnel.setText("Ajouter personnel");
        jButtonAjouterPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterPersonnelActionPerformed(evt);
            }
        });

        jButtonModifierPersonnel.setBackground(new java.awt.Color(0, 51, 153));
        jButtonModifierPersonnel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonModifierPersonnel.setText("Modifier personnel");
        jButtonModifierPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierPersonnelActionPerformed(evt);
            }
        });

        jButtonDeconnexion.setBackground(new java.awt.Color(0, 51, 153));
        jButtonDeconnexion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonDeconnexion.setText("Deconnexion");
        jButtonDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeconnexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelServiceInformatique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAjouterPersonnel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAjouterService, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonModifierPersonnel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDeconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelServiceInformatique)
                .addGap(37, 37, 37)
                .addComponent(jButtonAjouterService)
                .addGap(35, 35, 35)
                .addComponent(jButtonAjouterPersonnel)
                .addGap(35, 35, 35)
                .addComponent(jButtonModifierPersonnel)
                .addGap(35, 35, 35)
                .addComponent(jButtonDeconnexion)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterServiceActionPerformed
        sias = new ServiceInformatiqueAjouterServiceIU();
        sias.setLocationRelativeTo(null);
        setVisible(false);
        sias.setVisible(true);
        sias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sias.setResizable(false);
    }//GEN-LAST:event_jButtonAjouterServiceActionPerformed

    private void jButtonAjouterPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterPersonnelActionPerformed
        siap = new ServiceInformatiqueAjouterPersonnelIU();
        siap.setLocationRelativeTo(null);
        setVisible(false);
        siap.setVisible(true);
        siap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        siap.setResizable(false);
    }//GEN-LAST:event_jButtonAjouterPersonnelActionPerformed

    private void jButtonModifierPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierPersonnelActionPerformed
        simp = new ServiceInformatiqueModifierPersonnel();
        simp.setLocationRelativeTo(null);
        setVisible(false);
        simp.setVisible(true);
        simp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        simp.setResizable(false);
    }//GEN-LAST:event_jButtonModifierPersonnelActionPerformed

    private void jButtonDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeconnexionActionPerformed
       JOptionPane j=new JOptionPane();
         int retour =j.showConfirmDialog(this, "Êtes-vous sûr de vouloir vous déconnecter ?","Confirmation",JOptionPane.OK_CANCEL_OPTION);
         if(retour == JOptionPane.OK_OPTION){
            
        }
        else {
            j.setVisible(false);
        }
    }//GEN-LAST:event_jButtonDeconnexionActionPerformed

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
            java.util.logging.Logger.getLogger(ServiceInformatiqueIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceInformatiqueIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceInformatiqueIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceInformatiqueIU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceInformatiqueIU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouterPersonnel;
    private javax.swing.JButton jButtonAjouterService;
    private javax.swing.JButton jButtonDeconnexion;
    private javax.swing.JButton jButtonModifierPersonnel;
    private javax.swing.JLabel jLabelServiceInformatique;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
