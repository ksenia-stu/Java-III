/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2.complete;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Quiz2Complete extends javax.swing.JFrame {

  DefaultListModel<EmployeeSchedule> modelEmployeesList = new DefaultListModel<>();
   DefaultListModel<Weekday> modelWorkdaysList = new DefaultListModel<>();
  
  
   //file name
   public final String FILE_NAME = "emps.txt";
   
   //array list to get infro and sort it
   ArrayList<EmployeeSchedule> initialList = new ArrayList<>();
   
   
   //current sort order
   Comparator<EmployeeSchedule> currSortOrder = EmployeeSchedule.compareByName;
    /**
     * Creates new form Quiz2Complete
     */
    public Quiz2Complete() {
        Date date;
      
          initComponents();
          
          for(int i =0; i < Weekday.values().length; i++)
          {
              modelWorkdaysList.addElement(Weekday.values()[i]); 
          }
         
         
                try
          {
          loadDataFromFile();
          }
          catch(InvalidValueException ex)
          {
          JOptionPane.showMessageDialog(this, ex.getMessage(),
          "Import error",JOptionPane.INFORMATION_MESSAGE);
          }  
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        dlgAddEdit = new javax.swing.JDialog();
        dlgAddEdit_lblName = new javax.swing.JLabel();
        dlgAddEdit_tfName = new javax.swing.JTextField();
        dlgAddEdit_cbIsManager = new javax.swing.JCheckBox();
        dlgAddEdit_lblHiredDate = new javax.swing.JLabel();
        dlgAddEdit_tfHiredDate = new javax.swing.JTextField();
        dlgAddEdit_lblDepartment = new javax.swing.JLabel();
        dlgAddEdit_tfDepartment = new javax.swing.JTextField();
        dlgAddEdit_lblWorkDays = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dlgAddEdit_lstWorkDays = new javax.swing.JList<>();
        dlgAddEdit_btCancel = new javax.swing.JButton();
        dlgAddEdit_btAddUpdate = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmployees = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        miFileExport = new javax.swing.JMenuItem();
        miFileExit = new javax.swing.JMenuItem();
        menuSortBy = new javax.swing.JMenu();
        miSortByName = new javax.swing.JRadioButtonMenuItem();
        rbSortByHiredDate = new javax.swing.JRadioButtonMenuItem();
        menuAdd = new javax.swing.JMenu();

        dlgAddEdit.setModal(true);

        dlgAddEdit_lblName.setText("Name:");

        dlgAddEdit_cbIsManager.setText("is Manager");

        dlgAddEdit_lblHiredDate.setText("Hired date:");

        dlgAddEdit_lblDepartment.setText("Department:");

        dlgAddEdit_lblWorkDays.setText("Works on days:");

        dlgAddEdit_lstWorkDays.setModel(modelWorkdaysList);
        jScrollPane2.setViewportView(dlgAddEdit_lstWorkDays);

        dlgAddEdit_btCancel.setText("Cancel");

        dlgAddEdit_btAddUpdate.setText("Add/Update");
        dlgAddEdit_btAddUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAddEdit_btAddUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgAddEditLayout = new javax.swing.GroupLayout(dlgAddEdit.getContentPane());
        dlgAddEdit.getContentPane().setLayout(dlgAddEditLayout);
        dlgAddEditLayout.setHorizontalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblHiredDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dlgAddEdit_tfHiredDate))
                    .addComponent(dlgAddEdit_cbIsManager)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblName)
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dlgAddEdit_btCancel)
                            .addComponent(dlgAddEdit_tfDepartment))))
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddEditLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgAddEditLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(dlgAddEdit_lblWorkDays))
                            .addGroup(dlgAddEditLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(dlgAddEdit_btAddUpdate)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        dlgAddEditLayout.setVerticalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAddEdit_lblName)
                            .addComponent(dlgAddEdit_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_cbIsManager)
                        .addGap(25, 25, 25)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAddEdit_lblHiredDate)
                            .addComponent(dlgAddEdit_tfHiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAddEdit_lblDepartment)
                            .addComponent(dlgAddEdit_tfDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblWorkDays)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAddEdit_btCancel)
                    .addComponent(dlgAddEdit_btAddUpdate))
                .addGap(24, 24, 24))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStatus.setText("jLabel1");
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        lstEmployees.setModel(modelEmployeesList);
        lstEmployees.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstEmployees);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        menuFile.setText("File");

        miFileExport.setText("Export to .csv ...");
        menuFile.add(miFileExport);

        miFileExit.setText("Exit");
        miFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileExitActionPerformed(evt);
            }
        });
        menuFile.add(miFileExit);

        jMenuBar1.add(menuFile);

        menuSortBy.setText("Sort by");

        buttonGroup1.add(miSortByName);
        miSortByName.setSelected(true);
        miSortByName.setText("Name");
        miSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortByNameActionPerformed(evt);
            }
        });
        menuSortBy.add(miSortByName);

        buttonGroup1.add(rbSortByHiredDate);
        rbSortByHiredDate.setText("Hired date");
        rbSortByHiredDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSortByHiredDateActionPerformed(evt);
            }
        });
        menuSortBy.add(rbSortByHiredDate);

        jMenuBar1.add(menuSortBy);

        menuAdd.setText("Add");
        menuAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAddMouseClicked(evt);
            }
        });
        menuAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuAdd);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileExitActionPerformed
        dispose();
    }//GEN-LAST:event_miFileExitActionPerformed

    private void menuAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddActionPerformed
       
    }//GEN-LAST:event_menuAddActionPerformed

    private void menuAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAddMouseClicked
      if(evt.getClickCount() == 1 && evt.getButton() == MouseEvent.BUTTON1)
      {
          
              dlgAddEdit_btAddUpdate.setText("Add");
              dlgAddEdit_tfName.setText("");
            dlgAddEdit_tfHiredDate.setText("");
            dlgAddEdit_tfDepartment.setText("");
            dlgAddEdit_cbIsManager.setSelected(false);
            dlgAddEdit_lstWorkDays.clearSelection();
            

            dlgAddEdit.pack();
            dlgAddEdit.setLocationRelativeTo(this);
            dlgAddEdit.setVisible(true);
          
          
          
            
      }
    }//GEN-LAST:event_menuAddMouseClicked

    private void lstEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEmployeesMouseClicked
         if(evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1)
         {
           
              dlgAddEdit_btAddUpdate.setText("Update");
              dlgAddEdit_tfName.setText(lstEmployees.getSelectedValue().getName());
            dlgAddEdit_tfHiredDate.setText(EmployeeSchedule.dateFormat.format(lstEmployees.getSelectedValue().getDateHired()));
            dlgAddEdit_tfDepartment.setText(lstEmployees.getSelectedValue().getDepartment());
            dlgAddEdit_cbIsManager.setSelected(lstEmployees.getSelectedValue().getIsManager());
            
            //copy hashset to list
            ArrayList<Weekday> days = new ArrayList<>(lstEmployees.getSelectedValue().getWorkdaysList());
            //access each object from arraylist
          /*  for(int i =0; i < days.size(); i++)
            {
              
               dlgAddEdit_lstWorkDays.setSelectedIndices();
            } */

            dlgAddEdit.pack();
            dlgAddEdit.setLocationRelativeTo(this);
            dlgAddEdit.setVisible(true);
            
            
            
            
           
          
         }
    }//GEN-LAST:event_lstEmployeesMouseClicked

    private void dlgAddEdit_btAddUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAddEdit_btAddUpdateActionPerformed
        String name = dlgAddEdit_tfName.getText();
            boolean isManager = dlgAddEdit_cbIsManager.isSelected();
            Date dateHired = null;
            try
            {
                 dateHired = EmployeeSchedule.dateFormat.parse(dlgAddEdit_tfHiredDate.getText());
            }
           catch(ParseException ex)
           {
               JOptionPane.showMessageDialog(this, "Date is unparseabble",
                 "Input error",JOptionPane.INFORMATION_MESSAGE); 
           }
            
            String department = dlgAddEdit_tfDepartment.getText();
            
            //work days
            //get list of selected days
            List<Weekday> days = dlgAddEdit_lstWorkDays.getSelectedValuesList();
            
            HashSet<Weekday> workdaysList = new HashSet<Weekday>(days);
        
            EmployeeSchedule empSched = null;
            try
            {
                empSched = new EmployeeSchedule(name, isManager,
                    department, dateHired, workdaysList);  //throws InvalidValueException
            }
            catch(InvalidValueException ex)
            {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                 "Input error",JOptionPane.INFORMATION_MESSAGE);
            }
            
        if(lstEmployees.getSelectedIndex() == -1)
        {
           
            initialList.add(empSched);
            updateModelFromList();
        }
        else
        {
             initialList.set(lstEmployees.getSelectedIndex(), empSched);
            updateModelFromList();
        }
        dlgAddEdit.setVisible(false);
    }//GEN-LAST:event_dlgAddEdit_btAddUpdateActionPerformed

    private void miSortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortByNameActionPerformed
       currSortOrder = EmployeeSchedule.compareByName;
       // Collections.sort(initialList, currSortOrder);
        updateModelFromList();
    }//GEN-LAST:event_miSortByNameActionPerformed

    private void rbSortByHiredDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSortByHiredDateActionPerformed
       currSortOrder = EmployeeSchedule.compareByDateHired;
       // Collections.sort(initialList, currSortOrder);
        updateModelFromList();
    }//GEN-LAST:event_rbSortByHiredDateActionPerformed

    private void loadDataFromFile() throws InvalidValueException
    {
        try(Scanner fileInput = new Scanner(new File(FILE_NAME)))
        {
            while(fileInput.hasNextLine())
            {
                String data = fileInput.nextLine();
                EmployeeSchedule empSched = new EmployeeSchedule(data);  //throws InvalidValueException
                initialList.add(empSched);
                updateModelFromList();

            }
        }
        catch(IOException ex)
        {
             throw new InvalidValueException ("Problems reading file " + FILE_NAME);   
        }
        catch(InvalidValueException ex)
        {
            throw new InvalidValueException ("Errors reading file " + FILE_NAME + " " + ex.getMessage()); 

        }
            
    }
    
    private void updateModelFromList()
    {
        //sort list
        Collections.sort(initialList, currSortOrder);
        
        //clear model before loading info from initialList
        modelEmployeesList.clear();
        
        //add items from initialList to model
        modelEmployeesList.addAll(initialList);


    }
    
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
            java.util.logging.Logger.getLogger(Quiz2Complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz2Complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz2Complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz2Complete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz2Complete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDialog dlgAddEdit;
    private javax.swing.JButton dlgAddEdit_btAddUpdate;
    private javax.swing.JButton dlgAddEdit_btCancel;
    private javax.swing.JCheckBox dlgAddEdit_cbIsManager;
    private javax.swing.JLabel dlgAddEdit_lblDepartment;
    private javax.swing.JLabel dlgAddEdit_lblHiredDate;
    private javax.swing.JLabel dlgAddEdit_lblName;
    private javax.swing.JLabel dlgAddEdit_lblWorkDays;
    private javax.swing.JList<Weekday> dlgAddEdit_lstWorkDays;
    private javax.swing.JTextField dlgAddEdit_tfDepartment;
    private javax.swing.JTextField dlgAddEdit_tfHiredDate;
    private javax.swing.JTextField dlgAddEdit_tfName;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList<EmployeeSchedule> lstEmployees;
    private javax.swing.JMenu menuAdd;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuSortBy;
    private javax.swing.JMenuItem miFileExit;
    private javax.swing.JMenuItem miFileExport;
    private javax.swing.JRadioButtonMenuItem miSortByName;
    private javax.swing.JRadioButtonMenuItem rbSortByHiredDate;
    // End of variables declaration//GEN-END:variables
}
