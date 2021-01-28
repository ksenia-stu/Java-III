/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2employees;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Quiz2Employees extends javax.swing.JFrame {

    
    DefaultListModel<EmployeeSchedule>  modelEmployeeSchedulesList = new DefaultListModel<>();
    DefaultListModel<Weekday>  modelWeekdaysList = new DefaultListModel<>();
    
    //possibilities of sorting
    enum SortOrder {Name, HiredDate}
    
     //initial sorting order by name
    private SortOrder currSortOrder = SortOrder.Name;  //initially null
    
    //create a map of posiible sortings
    Map<SortOrder, Comparator<EmployeeSchedule>> sortMap = Map.of(
            SortOrder.Name,EmployeeSchedule.compareByName,
            SortOrder.HiredDate,EmployeeSchedule.compareByHiredDate
    );
    
    //file name to save/export
    final String DATA_FILENAME = "employees.txt";
    
    //create array list to copy model content
    ArrayList<EmployeeSchedule> scheduleList = new ArrayList<>();
    /**
     * Creates new form Quiz2Employees
     */
    public Quiz2Employees() {
        initComponents();
      //  loadDataFromFile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dlgAddEdit = new javax.swing.JDialog();
        dlgAddEdit_lblName = new javax.swing.JLabel();
        dlgAddEdit_tfName = new javax.swing.JTextField();
        dlgAddEdit_cbIsManager = new javax.swing.JCheckBox();
        dlgAddEdit_lblHired = new javax.swing.JLabel();
        dlgAddEdit_tfHired = new javax.swing.JTextField();
        dlgAddEdit_lblDepartment = new javax.swing.JLabel();
        dlgAddEdit_tfDepartment = new javax.swing.JTextField();
        dlgAddEdit_lblWorkDays = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dlgAddEdit_lstWorkDays = new javax.swing.JList<>();
        dlgAddEdit_btCancel = new javax.swing.JButton();
        dlgAddEdit_btAddUpdate = new javax.swing.JButton();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSchedules = new javax.swing.JList<>();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        miFileExport = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        menuSortBy = new javax.swing.JMenu();
        miSortByName = new javax.swing.JRadioButtonMenuItem();
        miSortByHiredDate = new javax.swing.JRadioButtonMenuItem();
        menuAdd = new javax.swing.JMenu();

        dlgAddEdit.setModal(true);

        dlgAddEdit_lblName.setText("Name:");

        dlgAddEdit_cbIsManager.setText("is Manager");

        dlgAddEdit_lblHired.setText("Hired:");

        dlgAddEdit_lblDepartment.setText("Department:");

        dlgAddEdit_lblWorkDays.setText("Works on days:");

        dlgAddEdit_lstWorkDays.setModel(modelWeekdaysList);
        jScrollPane2.setViewportView(dlgAddEdit_lstWorkDays);

        dlgAddEdit_btCancel.setText("Cancel");
        dlgAddEdit_btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlgAddEdit_btCancelActionPerformed(evt);
            }
        });

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
                .addGap(34, 34, 34)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dlgAddEdit_tfDepartment))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblHired)
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_tfHired))
                    .addComponent(dlgAddEdit_cbIsManager)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addComponent(dlgAddEdit_lblName)
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(dlgAddEdit_lblWorkDays)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgAddEditLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(dlgAddEdit_btCancel)
                .addGap(52, 52, 52)
                .addComponent(dlgAddEdit_btAddUpdate)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dlgAddEditLayout.setVerticalGroup(
            dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgAddEditLayout.createSequentialGroup()
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAddEdit_lblName)
                            .addComponent(dlgAddEdit_tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(dlgAddEdit_cbIsManager)
                        .addGap(21, 21, 21)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAddEdit_lblHired)
                            .addComponent(dlgAddEdit_tfHired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlgAddEdit_lblDepartment)
                            .addComponent(dlgAddEdit_tfDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dlgAddEditLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(dlgAddEdit_lblWorkDays)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(dlgAddEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlgAddEdit_btCancel)
                    .addComponent(dlgAddEdit_btAddUpdate))
                .addGap(33, 33, 33))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lstSchedules.setModel(modelEmployeeSchedulesList);
        lstSchedules.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstSchedules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstSchedulesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstSchedules);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        lblStatus.setText("jLabel1");
        getContentPane().add(lblStatus, java.awt.BorderLayout.PAGE_END);

        menuFile.setText("File");

        miFileExport.setText("Export to .csv ...");
        miFileExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileExportActionPerformed(evt);
            }
        });
        menuFile.add(miFileExport);

        miExit.setText("Exit");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        menuFile.add(miExit);

        jMenuBar1.add(menuFile);

        menuSortBy.setText("Sort by");
        menuSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSortByActionPerformed(evt);
            }
        });

        buttonGroup1.add(miSortByName);
        miSortByName.setSelected(true);
        miSortByName.setText("Name");
        miSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortByNameActionPerformed(evt);
            }
        });
        menuSortBy.add(miSortByName);

        buttonGroup1.add(miSortByHiredDate);
        miSortByHiredDate.setText("Hired date");
        miSortByHiredDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortByHiredDateActionPerformed(evt);
            }
        });
        menuSortBy.add(miSortByHiredDate);

        jMenuBar1.add(menuSortBy);

        menuAdd.setText("Add");
        menuAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAddMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAdd);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     int currentlyEditedItemIndex = -1;
    
    private void menuAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAddMouseClicked
       if (evt.getButton() == MouseEvent.BUTTON1) {
            dlgAddEdit_btAddUpdate.setText("Add");
            currentlyEditedItemIndex = -1;
            dlgAddEdit_tfName.setText("");
            dlgAddEdit_cbIsManager.setSelected(false);
            dlgAddEdit_tfHired.setText("");
            dlgAddEdit_tfDepartment.setText("");
            
           List<Weekday> enumList = Arrays.asList(Weekday.class.getEnumConstants());
            modelWeekdaysList.addAll(enumList);
            dlgAddEdit.pack();
            dlgAddEdit.setLocationRelativeTo(this);
            dlgAddEdit.setVisible(true);
        }
    }//GEN-LAST:event_menuAddMouseClicked

    private void dlgAddEdit_btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAddEdit_btCancelActionPerformed
      dlgAddEdit.setVisible(false);
    }//GEN-LAST:event_dlgAddEdit_btCancelActionPerformed

    
    
     private void updateModelFromList()
    {
        //sorting
        Collections.sort(scheduleList,sortMap.get(currSortOrder));
        
        //clear what's in model
        modelEmployeeSchedulesList.clear();
        
        //add new objects from array list to model
        modelEmployeeSchedulesList.addAll(scheduleList); 
        
    }
    
     
  /*   private void loadDataFromFile() {
        
        try (Scanner fileInput = new Scanner(new File(DATA_FILENAME)))
        {
            while (fileInput.hasNextLine()) {
                try {
                    
                    String line = fileInput.nextLine();
                   EmployeeSchedule(line);
                } 
            
        catch (InvalidValueException ex) {
           
        }
       }
        }
    }  */
    
     
     
     private void exportDataToFile() throws InvalidValueException
    {
        File file = null;
        fileChooser.setDialogTitle("Export to file");
            int returnVal = fileChooser.showSaveDialog(this);
            if(returnVal == fileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();
                if(file == null)
                {
                    return;
                }
                //.means any character, + means 1 or more ({1, infinity}), \\. means dot 
                //{a-zA-Z0-9] it is extension of file, + means 1 or more characters
                if(!file.getName().matches(".+\\.[a-zA-Z0-9]+"))
                {
                    file = new File(file.getParentFile(), file.getName() + ".csv");
                }
            }
            saveDataToFile(file);
            JOptionPane.showMessageDialog(this, "File saved",
                 "Success",JOptionPane.INFORMATION_MESSAGE);   
    }
     
     
     private void saveDataToFile(File file) throws InvalidValueException //think of File as path
    {
        try(PrintWriter fileOutput = new PrintWriter(new FileWriter(file, false)))   //append false
        {
            for(int i =0; i < modelEmployeeSchedulesList.size(); i++)
                {
                    fileOutput.println(modelEmployeeSchedulesList.getElementAt(i).toDataString());
                }
        }
        catch(IOException ex)
        {
             throw new InvalidValueException (ex.getMessage());
        }
    }
     
     
    private void dlgAddEdit_btAddUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlgAddEdit_btAddUpdateActionPerformed
      String name = dlgAddEdit_tfName.getText();
      boolean isManager = dlgAddEdit_cbIsManager.isSelected();
      Date hiredDate = null;
      try
      {
         hiredDate = EmployeeSchedule.dateFormat.parse(dlgAddEdit_tfHired.getText()); 
      }
      catch(ParseException ex)
      {
          try {  
              throw new InvalidValueException("Hired date is unparseable " + ex.getMessage());
          } catch (InvalidValueException ex1) {
              JOptionPane.showMessageDialog(this,ex1.getMessage(),"Input error",  
                       JOptionPane.ERROR_MESSAGE);
          }
      }
      
      String department = dlgAddEdit_tfDepartment.getText();
      HashSet<Weekday> set = new HashSet<>();
      
      for(int i = 0; i < modelWeekdaysList.size(); i++)
      {
          set.add(modelWeekdaysList.getElementAt(i));
          
      }
      EmployeeSchedule empSched = null;
      try
         {
             empSched = new EmployeeSchedule(name,isManager,department, hiredDate, set);  //throws InvalidDataException
         }
         catch(InvalidValueException ex)
         {
             JOptionPane.showMessageDialog(this,ex.getMessage(),"Input error",  
                       JOptionPane.ERROR_MESSAGE);
         }
     
      
     
        if(currentlyEditedItemIndex == -1)
        {
            //add name  and birthday to bdayList
            scheduleList.add(empSched);
            //update model from list
            updateModelFromList();
        }
        else
        {
            
            scheduleList.set(currentlyEditedItemIndex, empSched);
            //update model from list
            updateModelFromList();
           
        }
       
        //hide dialog window
        dlgAddEdit.setVisible(false);
    }//GEN-LAST:event_dlgAddEdit_btAddUpdateActionPerformed

    private void menuSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSortByActionPerformed
       
    }//GEN-LAST:event_menuSortByActionPerformed

    private void miSortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortByNameActionPerformed
        currSortOrder = SortOrder.Name; 
        updateModelFromList();
    }//GEN-LAST:event_miSortByNameActionPerformed

    private void miSortByHiredDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortByHiredDateActionPerformed
       currSortOrder = SortOrder.HiredDate; 
        updateModelFromList();
    }//GEN-LAST:event_miSortByHiredDateActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        dispose();
    }//GEN-LAST:event_miExitActionPerformed

    private void miFileExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileExportActionPerformed
       if(modelEmployeeSchedulesList.isEmpty())
    {
        JOptionPane.showMessageDialog(this,"First add items to be saved",
                  "Action required",  
                       JOptionPane.ERROR_MESSAGE);
        return;
    }
        try {
            exportDataToFile();
        } catch (InvalidValueException ex) {
            Logger.getLogger(Quiz2Employees.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_miFileExportActionPerformed

    private void lstSchedulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstSchedulesMouseClicked
       //to check if mouse was clicked 2 times and only right button was clicked
        if(evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1)
       {
       
            dlgAddEdit.pack();
            dlgAddEdit.setLocationRelativeTo(this);
            dlgAddEdit.setVisible(true);
           
          
       }
    }//GEN-LAST:event_lstSchedulesMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          try
        {
            saveDataToFile(new File(DATA_FILENAME)); //throws InvalidDataException
        }
        catch(InvalidValueException ex)
                {
                        JOptionPane.showMessageDialog(this,ex.getMessage(),"Error",  
                       JOptionPane.ERROR_MESSAGE);
                }
        
        dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Quiz2Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz2Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz2Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz2Employees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz2Employees().setVisible(true);
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
    private javax.swing.JLabel dlgAddEdit_lblHired;
    private javax.swing.JLabel dlgAddEdit_lblName;
    private javax.swing.JLabel dlgAddEdit_lblWorkDays;
    private javax.swing.JList<Weekday> dlgAddEdit_lstWorkDays;
    private javax.swing.JTextField dlgAddEdit_tfDepartment;
    private javax.swing.JTextField dlgAddEdit_tfHired;
    private javax.swing.JTextField dlgAddEdit_tfName;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList<EmployeeSchedule> lstSchedules;
    private javax.swing.JMenu menuAdd;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuSortBy;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenuItem miFileExport;
    private javax.swing.JRadioButtonMenuItem miSortByHiredDate;
    private javax.swing.JRadioButtonMenuItem miSortByName;
    // End of variables declaration//GEN-END:variables
}
