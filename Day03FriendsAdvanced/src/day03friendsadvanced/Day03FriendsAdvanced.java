/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03friendsadvanced;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class Day03FriendsAdvanced extends javax.swing.JFrame {

    DefaultListModel <String> modelFriendsList = new DefaultListModel<String>();
    /**
     * Creates new form Day03FriendsAdvanced
     */
    public Day03FriendsAdvanced() {
        initComponents();
        //set a default filename (this is where you default extension first comes in)
        fileChooser.setSelectedFile(new File("*.dat"));
        //Set an extension filter, so the user sees other .dat files
        fileChooser.setFileFilter(new FileNameExtensionFilter("Data file","dat"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFriends = new javax.swing.JList<>();
        lblName = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miFileExport = new javax.swing.JMenuItem();
        miFileImport = new javax.swing.JMenuItem();
        miFileExit = new javax.swing.JMenuItem();

        fileChooser.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstFriends.setModel(modelFriendsList);
        lstFriends.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstFriends.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFriendsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFriends);

        lblName.setText("Enter name:");

        btAdd.setText("Add friend");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setText("Delete selected friend");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("Update selected friend");
        btUpdate.setEnabled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        miFileExport.setText("Export to file (.dat)");
        miFileExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileExportActionPerformed(evt);
            }
        });
        jMenu1.add(miFileExport);

        miFileImport.setText("Import from file (.dat)");
        miFileImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileImportActionPerformed(evt);
            }
        });
        jMenu1.add(miFileImport);

        miFileExit.setText("Exit");
        miFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileExitActionPerformed(evt);
            }
        });
        jMenu1.add(miFileExit);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblName)
                        .addGap(31, 31, 31)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(btAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btUpdate)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
       String name;
       if(!tfName.getText().matches("[ A-Za-z]{1,20}"))
       {
           JOptionPane.showMessageDialog(this,"Name should be between 1 and 20 characters.\n"
                   + "Capital/small letters and spaces allowed only. ","Input error",  
                       JOptionPane.ERROR_MESSAGE);
            return;
       }
       name = tfName.getText();
       
       modelFriendsList.addElement(name);
       tfName.setText("");
       
    }//GEN-LAST:event_btAddActionPerformed

    private void lstFriendsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFriendsValueChanged
       if(lstFriends.getSelectedIndex() != -1)
       {
         btDelete.setEnabled(true);
         btUpdate.setEnabled(true);
       }
       else
       {
         btDelete.setEnabled(false);
         btUpdate.setEnabled(false);
       }
        
    }//GEN-LAST:event_lstFriendsValueChanged

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
       modelFriendsList.remove(lstFriends.getSelectedIndex());
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
       String name;
       if(!tfName.getText().matches("[ A-Za-z]{1,20}"))
       {
          JOptionPane.showMessageDialog(this,"New name should be between 1 and 20 characters.\n"
                   + "Capital/small letters and spaces allowed only. ","Input error",  
                       JOptionPane.ERROR_MESSAGE); 
          return;
       }
       name = tfName.getText();
       modelFriendsList.setElementAt(name, lstFriends.getSelectedIndex());
    }//GEN-LAST:event_btUpdateActionPerformed

    private void miFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileExitActionPerformed
      dispose();
    }//GEN-LAST:event_miFileExitActionPerformed

    private void miFileExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileExportActionPerformed
       //to open fileChooser (save dialog) on click of Export button in menu
        int retrival = fileChooser.showSaveDialog(null);
        
        if (retrival == fileChooser.APPROVE_OPTION)
        {
            try (PrintWriter fileOutput = new PrintWriter(new FileWriter(fileChooser.getSelectedFile()+".dat"),true))
            {
                for(int i = modelFriendsList.size() -1; i >= 0; i--)
                {
                    fileOutput.println(modelFriendsList.elementAt(i));
                }
            }
            catch(IOException ex)
            {
                 JOptionPane.showMessageDialog(this, "Unable writing to file: \n"
                         +ex.getMessage(), "File access error",JOptionPane.ERROR_MESSAGE);
                 return;
            }
             JOptionPane.showMessageDialog(this, "File was saved", "Success",JOptionPane.INFORMATION_MESSAGE);  
        }
    }//GEN-LAST:event_miFileExportActionPerformed

    private void miFileImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileImportActionPerformed
    //to open fileChooser (open dialog) on click of Export button in menu
        int retrival = fileChooser.showOpenDialog(null);
        // loading info from a file
        if (retrival == fileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            try(Scanner fileInput = new Scanner(selectedFile))       //try to read from file
        {
           
            //while there is next line, keep loading
            while(fileInput.hasNextLine())
            {
                String line =  fileInput.nextLine();
                modelFriendsList.addElement(line);
            }
            
            }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(this,"Error reading from file\n" + ex.getMessage(),"error",  
                       JOptionPane.ERROR_MESSAGE);
            return;
        }
        }
    
        
    }//GEN-LAST:event_miFileImportActionPerformed

    
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
            java.util.logging.Logger.getLogger(Day03FriendsAdvanced.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day03FriendsAdvanced.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day03FriendsAdvanced.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day03FriendsAdvanced.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day03FriendsAdvanced().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btUpdate;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JList<String> lstFriends;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miFileExit;
    private javax.swing.JMenuItem miFileExport;
    private javax.swing.JMenuItem miFileImport;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
