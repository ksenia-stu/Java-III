
package day01icecreamcalc;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Ksenia Studilina
 */
public class Day01IceCreamCalc extends javax.swing.JFrame {

    
    public Day01IceCreamCalc() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        lblArsenioTitle = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        rbVanilla = new javax.swing.JRadioButton();
        rbStrawberry = new javax.swing.JRadioButton();
        rbChocolate = new javax.swing.JRadioButton();
        Panel2 = new javax.swing.JPanel();
        cbSprinkles = new javax.swing.JCheckBox();
        cbPeanuts = new javax.swing.JCheckBox();
        cbFudge = new javax.swing.JCheckBox();
        lblSubtotal = new javax.swing.JLabel();
        lblTax = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        tfSubtotal = new javax.swing.JTextField();
        tfTax = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        btCalculate = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        btExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ice Cream Store");
        setResizable(false);

        lblArsenioTitle.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        lblArsenioTitle.setText("Arsenio's Ice Cream");

        Panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup.add(rbVanilla);
        rbVanilla.setSelected(true);
        rbVanilla.setText("Vanilla $1.00");
        rbVanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVanillaActionPerformed(evt);
            }
        });

        buttonGroup.add(rbStrawberry);
        rbStrawberry.setText("Strawberry $1.50");
        rbStrawberry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbStrawberryActionPerformed(evt);
            }
        });

        buttonGroup.add(rbChocolate);
        rbChocolate.setText("Chocolate $2.00");
        rbChocolate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbChocolateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbChocolate)
                    .addComponent(rbStrawberry)
                    .addComponent(rbVanilla)))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(rbVanilla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbStrawberry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbChocolate)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Panel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbSprinkles.setText("Sprinkles $.25");
        cbSprinkles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSprinklesActionPerformed(evt);
            }
        });

        cbPeanuts.setText("Peanuts $.50");

        cbFudge.setText("Fudge $.75");

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbFudge)
                    .addComponent(cbPeanuts)
                    .addComponent(cbSprinkles))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cbSprinkles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPeanuts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFudge)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblSubtotal.setText("Subtotal");

        lblTax.setText("Tax");

        lblTotal.setText("Total");

        tfSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSubtotalActionPerformed(evt);
            }
        });

        btCalculate.setText("Calculate");
        btCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalculateActionPerformed(evt);
            }
        });

        btReset.setText("Reset Form");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCalculate)
                        .addGap(18, 18, 18)
                        .addComponent(btReset)
                        .addGap(18, 18, 18)
                        .addComponent(btExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtotal)
                            .addComponent(lblTax)
                            .addComponent(lblTotal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSubtotal)
                            .addComponent(tfTax, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(tfTotal))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblArsenioTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(165, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblArsenioTitle)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(tfSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTax)
                            .addComponent(tfTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btCalculate)
                            .addComponent(btReset)
                            .addComponent(btExit))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSubtotalActionPerformed
  
         
    }//GEN-LAST:event_tfSubtotalActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
   // System.exit(0);        // to use only if there is no way to continue running program (ex. program cant connect to database)
   dispose();
    }//GEN-LAST:event_btExitActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
    rbVanilla.setSelected(true);   //unselect Vanilla
    rbChocolate.setSelected(false); //unselect Chocolate
    rbStrawberry.setSelected(false);  //unselect Strawberry
    cbSprinkles.setSelected(false);  //uncheck Sprinkles
    cbPeanuts.setSelected(false);   //uncheck Peanut
    cbFudge.setSelected(false);    //uncheck Fudge
    tfSubtotal.setText(" ");    //set Subtotal to " "
    tfTax.setText(" "); //set Tax to " "
    tfTotal.setText(" "); //set Total to " "  */
    // TODO add your handling code here:
    }//GEN-LAST:event_btResetActionPerformed

    private void rbVanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVanillaActionPerformed
        //can be done with button group
        /*  if (rbVanilla.isSelected())
        rbChocolate.setSelected(false);
    rbStrawberry.setSelected(false); */ // if Vanilla is selected, unselect Strawberry and Chocolate  
    }//GEN-LAST:event_rbVanillaActionPerformed

    private void rbStrawberryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbStrawberryActionPerformed
       //can be done with button group
     /*   if (rbStrawberry.isSelected())
        rbVanilla.setSelected(false);
    rbChocolate.setSelected(false); */ // if Strawberry is selected, unselect Vanilla and Chocolate 
    }//GEN-LAST:event_rbStrawberryActionPerformed

    private void rbChocolateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbChocolateActionPerformed
     //can be done with button group
        /*   if (rbChocolate.isSelected())
        rbVanilla.setSelected(false);
    rbStrawberry.setSelected(false);  */ // if Chocolate is selected, unselect Vanilla and Strawberry  
    }//GEN-LAST:event_rbChocolateActionPerformed

    private void btCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalculateActionPerformed
        //declaring variables   
           double subtotal = 0;
           final double TAX_PERCENT = .13;  // 13% tax (constant)
           double tax;
           double total;
           
           //radio buttons (oan be selected one at a time if, else if, else if)
           if (rbVanilla.isSelected()){
               subtotal += 1.00;
           } 
           else if (rbStrawberry.isSelected()){
               subtotal += 1.50;
           }
           else if (rbChocolate.isSelected()){
               subtotal += 2.00;
           }
           else {
               //internal error
               JOptionPane.showMessageDialog(this, "Internal error. No radio button is selected");
           }
           
           //checkboxes (can be selected several at a time if if if)
           if (cbSprinkles.isSelected()) {
               subtotal += .25;
           }
           if (cbPeanuts.isSelected()) {
               subtotal += .50;
           }
           if (cbFudge.isSelected()) {
               subtotal += .75;
           }
           
           
           tfSubtotal.setText(Double.toString(subtotal));  
           subtotal = Double.parseDouble(tfSubtotal.getText());
           tax = subtotal*TAX_PERCENT;
           total = subtotal + tax;
           
           tfTax.setText(String.format("%.2f",tax));
           tfTotal.setText(String.format("%.2f", total));
           
    
// TODO add your handling code here:
    }//GEN-LAST:event_btCalculateActionPerformed

    private void cbSprinklesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSprinklesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSprinklesActionPerformed

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
            java.util.logging.Logger.getLogger(Day01IceCreamCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day01IceCreamCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day01IceCreamCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day01IceCreamCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day01IceCreamCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JButton btCalculate;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btReset;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JCheckBox cbFudge;
    private javax.swing.JCheckBox cbPeanuts;
    private javax.swing.JCheckBox cbSprinkles;
    private javax.swing.JLabel lblArsenioTitle;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbChocolate;
    private javax.swing.JRadioButton rbStrawberry;
    private javax.swing.JRadioButton rbVanilla;
    private javax.swing.JTextField tfSubtotal;
    private javax.swing.JTextField tfTax;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
