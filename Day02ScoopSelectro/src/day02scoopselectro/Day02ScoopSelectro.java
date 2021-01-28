/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02scoopselectro;

import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Day02ScoopSelectro extends javax.swing.JFrame {

    /**
     * Creates new form Day02ScoopSelectro
     */
    public Day02ScoopSelectro() {
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

        lblFlavours = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFlavours = new javax.swing.JList<>();
        btAdd = new javax.swing.JButton();
        lblSelected = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSelectedFlavours = new javax.swing.JList<>();
        btDeleteScoop = new javax.swing.JButton();
        btClearAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scoop Selector");
        setResizable(false);

        lblFlavours.setText("Flavours :");

        lstFlavours.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Vanilla", "Chocolate", "Strawberry", "Peach" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstFlavours);

        btAdd.setText("Add   =>");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        lblSelected.setText("Selected :");

        jScrollPane2.setViewportView(lstSelectedFlavours);

        btDeleteScoop.setText("Delete Scoop");
        btDeleteScoop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteScoopActionPerformed(evt);
            }
        });

        btClearAll.setText("Clear All");
        btClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFlavours)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btClearAll)
                    .addComponent(btDeleteScoop)
                    .addComponent(lblSelected)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFlavours)
                    .addComponent(lblSelected))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))))
                .addGap(35, 35, 35)
                .addComponent(btDeleteScoop)
                .addGap(30, 30, 30)
                .addComponent(btClearAll)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //cteate object of default list model
    //MODEL IS THE DATA (KIND OF ARRAY LIST)
    DefaultListModel listModel = new DefaultListModel();
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
       
     //get selected value from list of flavours(left list) and save it to string flavour
     
     
        String flavour =  lstFlavours.getSelectedValue();
        if (lstFlavours.isSelectionEmpty() == true)
        {
            JOptionPane.showMessageDialog(this, "No items selected", "Internal error",JOptionPane.ERROR_MESSAGE);    
    
        }
        if (lstFlavours.isSelectionEmpty() == false)
        {
            int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to confirm your selection?",
             "Confirmation needed",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION)
        {
      //add value of string flavour to delault list model
          listModel.addElement(flavour);  
          
      //set listModel to lstSelectedFlavours (right list)
          lstSelectedFlavours.setModel(listModel);
        }
        

          
        }
        
     
    
     

    
    
     
     
       
  
       
       
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteScoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteScoopActionPerformed
        String flavourToDelete =  lstSelectedFlavours.getSelectedValue();
        
        if (lstSelectedFlavours.isSelectionEmpty() == true)
        {
            JOptionPane.showMessageDialog(this, "No items selected to be deleted", "Internal error",JOptionPane.ERROR_MESSAGE);    
    
        }
        if (lstSelectedFlavours.isSelectionEmpty() == false)
        {
            int dialogAnswer = JOptionPane.showConfirmDialog (null, "Would you like to confirm item to be deleted?",
             "Confirmation needed",JOptionPane.YES_NO_OPTION);
        if(dialogAnswer == JOptionPane.YES_OPTION)
        {
      //add value of string flavour to delault list model
            int selectedIndex = lstSelectedFlavours.getSelectedIndex();
            if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
} 
          
      //set default list model to lstSelectedFlavours (right list)
       //   lstSelectedFlavours.setModel(listModel);
        }
        }
    }//GEN-LAST:event_btDeleteScoopActionPerformed

    private void btClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearAllActionPerformed
        listModel.removeAllElements();
    }//GEN-LAST:event_btClearAllActionPerformed

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
            java.util.logging.Logger.getLogger(Day02ScoopSelectro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day02ScoopSelectro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day02ScoopSelectro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day02ScoopSelectro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day02ScoopSelectro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btClearAll;
    private javax.swing.JButton btDeleteScoop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFlavours;
    private javax.swing.JLabel lblSelected;
    private javax.swing.JList<String> lstFlavours;
    private javax.swing.JList<String> lstSelectedFlavours;
    // End of variables declaration//GEN-END:variables
}