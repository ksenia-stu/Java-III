/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortinglist;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SortingList extends javax.swing.JFrame {

    
  DefaultListModel<Dog> modelDogsList = new DefaultListModel<>();
  
  ArrayList <Dog> dogsList = new ArrayList<>();

  //sorting
  Comparator<Dog> sortOrder = Dog.compareByName;
 
    /**
     * Creates new form SortingList
     */
    public SortingList() {
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

        dlgAddEdit = new javax.swing.JDialog();
        lblName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        sliderAge = new javax.swing.JSlider();
        lblBirthday = new javax.swing.JLabel();
        tfBirthday = new javax.swing.JTextField();
        btCancel = new javax.swing.JButton();
        btAddUpdate = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstDogs = new javax.swing.JList<>();
        lblSortBy = new javax.swing.JLabel();
        rbSortByName = new javax.swing.JRadioButton();
        rbSortByAge = new javax.swing.JRadioButton();
        rbSortByBirthday = new javax.swing.JRadioButton();
        btAdd = new javax.swing.JButton();

        dlgAddEdit.setModal(true);

        lblName.setText("Name:");

        lblAge.setText("Age:");

        sliderAge.setMajorTickSpacing(5);
        sliderAge.setMaximum(25);
        sliderAge.setPaintLabels(true);
        sliderAge.setPaintTicks(true);
        sliderAge.setValue(10);

        lblBirthday.setText("Birthday:");

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btAddUpdate.setText("Add/Update");
        btAddUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAddEditLayout = new javax.swing.GroupLayout(dlgAddEdit.getContentPane());
        dlgAddEdit.getContentPane().setLayout(dlgAddEditLayout);
        dlgAddEditLayout.setHorizontalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(btCancel)
                        .addGap(64, 64, 64)
                        .addComponent(btAddUpdate))
                    .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(dlgAddEditLayout.createSequentialGroup()
                            .addComponent(lblBirthday)
                            .addGap(18, 18, 18)
                            .addComponent(tfBirthday))
                        .addGroup(dlgAddEditLayout.createSequentialGroup()
                            .addComponent(lblAge)
                            .addGap(18, 18, 18)
                            .addComponent(sliderAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(dlgAddEditLayout.createSequentialGroup()
                            .addComponent(lblName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfName))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        dlgAddEditLayout.setVerticalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAge)
                    .addComponent(sliderAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBirthday)
                    .addComponent(tfBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancel)
                    .addComponent(btAddUpdate))
                .addGap(38, 38, 38))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstDogs.setModel(modelDogsList);
        lstDogs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstDogs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDogsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstDogs);

        lblSortBy.setText("Sort by:");

        buttonGroup1.add(rbSortByName);
        rbSortByName.setSelected(true);
        rbSortByName.setText("Name");
        rbSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSortByNameActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSortByAge);
        rbSortByAge.setText("Age");
        rbSortByAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSortByAgeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSortByBirthday);
        rbSortByBirthday.setText("Birthday");
        rbSortByBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSortByBirthdayActionPerformed(evt);
            }
        });

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(lblSortBy))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSortByAge)
                                    .addComponent(rbSortByName)
                                    .addComponent(rbSortByBirthday)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btAdd)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lblSortBy)
                        .addGap(18, 18, 18)
                        .addComponent(rbSortByName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbSortByAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbSortByBirthday)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAdd)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
       btAddUpdate.setText("Add");
       tfName.setText("");
       sliderAge.setValue(10);
       tfBirthday.setText("");
       
       dlgAddEdit.pack();
       dlgAddEdit.setLocationRelativeTo(this);
       dlgAddEdit.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
       dlgAddEdit.setVisible(false);
    }//GEN-LAST:event_btCancelActionPerformed

    
    
    
    private void btAddUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddUpdateActionPerformed
      
        int selectedIndex = lstDogs.getSelectedIndex();
       if(selectedIndex == -1)
       {
           String name = tfName.getText();
           int age = sliderAge.getValue();
           Date birthday = null;
           try
           {
               birthday = Dog.dateFormat.parse(tfBirthday.getText());
           }
           catch(ParseException ex)
           {
                JOptionPane.showMessageDialog(this,"Date is unparseable", "Input error",
                    JOptionPane.ERROR_MESSAGE);
           }
           
           //add to list
           Dog dog = new Dog(name, age, birthday);
           dogsList.add(dog);
           
           //update model
           updateModelFromList();
       }   
       else
       {
            
            
            //add to list
           Dog dog = lstDogs.getSelectedValue();
           dog.setName(tfName.getText());
           dog.setAge(sliderAge.getValue());
            try {
                dog.setBirthday(Dog.dateFormat.parse(tfBirthday.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(SortingList.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           dogsList.set(lstDogs.getSelectedIndex(), dog);
           updateModelFromList();
       }
       
    }//GEN-LAST:event_btAddUpdateActionPerformed

    private void lstDogsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDogsMouseClicked
       

    if(evt.getClickCount() == 2 && evt.getButton() == evt.BUTTON1)
        {
            btAddUpdate.setText("Update");
            tfName.setText(lstDogs.getSelectedValue().getName());
            sliderAge.setValue(lstDogs.getSelectedValue().getAge());
            tfBirthday.setText(Dog.dateFormat.format(lstDogs.getSelectedValue().getBirthday()));

            dlgAddEdit.pack();
            dlgAddEdit.setLocationRelativeTo(this);
            dlgAddEdit.setVisible(true);
            
        }
    }//GEN-LAST:event_lstDogsMouseClicked

    private void rbSortByAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSortByAgeActionPerformed
       sortOrder = Dog.compareByAge;
      // Collections.sort(dogsList, sortOrder);
       updateModelFromList();
       
    }//GEN-LAST:event_rbSortByAgeActionPerformed

    private void rbSortByBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSortByBirthdayActionPerformed
       sortOrder = Dog.compareByBirthday;
      // Collections.sort(dogsList, sortOrder);
       
       updateModelFromList();
    }//GEN-LAST:event_rbSortByBirthdayActionPerformed

    private void rbSortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSortByNameActionPerformed
       sortOrder = Dog.compareByName;
      // Collections.sort(dogsList, sortOrder);
      
       
       updateModelFromList();
    }//GEN-LAST:event_rbSortByNameActionPerformed

    
    private void updateModelFromList()
    {
        Collections.sort(dogsList, sortOrder);
        
        //clear what's in model
         modelDogsList.clear();
        modelDogsList.addAll(dogsList);
    }
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
            java.util.logging.Logger.getLogger(SortingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SortingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SortingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SortingList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortingList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAddUpdate;
    private javax.swing.JButton btCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog dlgAddEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSortBy;
    private javax.swing.JList<Dog> lstDogs;
    private javax.swing.JRadioButton rbSortByAge;
    private javax.swing.JRadioButton rbSortByBirthday;
    private javax.swing.JRadioButton rbSortByName;
    private javax.swing.JSlider sliderAge;
    private javax.swing.JTextField tfBirthday;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
