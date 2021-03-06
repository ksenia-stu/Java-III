/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleinput;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SimpleInput extends javax.swing.JFrame {

    /**
     * Creates new form SimpleInput
     */
    public SimpleInput() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lblDisplayName = new javax.swing.JLabel();
        tfDisplayName = new javax.swing.JTextField();
        btDisplayname = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setText("Name:");

        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        tfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNameKeyReleased(evt);
            }
        });

        lblDisplayName.setText("......");

        btDisplayname.setText("Display name");
        btDisplayname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDisplaynameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblName)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDisplayName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblDisplayName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btDisplayname)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(tfDisplayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblDisplayName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDisplayname)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameKeyReleased
       
    }//GEN-LAST:event_tfNameKeyReleased

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
     
    }//GEN-LAST:event_tfNameActionPerformed

    
    private void tfNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameKeyPressed
       
    }//GEN-LAST:event_tfNameKeyPressed

    private void btDisplaynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDisplaynameActionPerformed
       String name = tfName.getText();
        if(!name.matches("[-. A-Za-z]{1,20}"))
       {
           JOptionPane.showMessageDialog(this,"Name must be between 1 and 20 characters (capital or small letters) \n"
                   + "-, . signs and spaces accepted","Input error",  
                       JOptionPane.ERROR_MESSAGE);
       }
       else
        {
            if(tfName.getText().length() >=5)
           {
               tfDisplayName.setText("Long name:" + tfName.getText());
               lblDisplayName.setText("");
           }
           else
           {
               lblDisplayName.setText("Short name:" + tfName.getText());
               tfDisplayName.setText("");
           }
        }
    }//GEN-LAST:event_btDisplaynameActionPerformed

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
            java.util.logging.Logger.getLogger(SimpleInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimpleInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimpleInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimpleInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDisplayname;
    private javax.swing.JLabel lblDisplayName;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField tfDisplayName;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
