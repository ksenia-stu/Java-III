/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10carowners;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class Day10CarOwners extends javax.swing.JFrame {

    DefaultListModel<Owner> modelOwnersList = new DefaultListModel<>();
    DefaultListModel<Car> modelCarsList = new DefaultListModel<>();
    DefaultListModel<Car> modelCarsOwnedList = new DefaultListModel<>();

    static final String FILENAME_PATTERN = ".+\\.[A-Za-z0-9]+$";

    //Create instance of Database
    Database db;

    /**
     * Creates new form Day10CarOwners
     */
    public Day10CarOwners() {
        initComponents();

        //TRY TO ESTABLISH CONNECTION WITH DATABASE SERVER
        try {
            db = new Database();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect: " + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * *********** METHOD TO LOAD DATA FROM DATABASE ***********
     */
    private void loadCarsFromDatabase() {

        try {
            //select all records from database and put them in list
            ArrayList<Car> list = db.getAllCars();

            //clear all items from flightsModel
            modelCarsList.clear();

            //addd items from list to model
            modelCarsList.addAll(list);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect: " + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void loadOwnersFromDatabase() {

        try {
            //select all records from database and put them in list
            ArrayList<Owner> list = db.getAllOwners();

            //clear all items from flightsModel
            modelOwnersList.clear();

            //addd items from list to model
            modelOwnersList.addAll(list);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect: " + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
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

        dlgCars = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        dlg_lblId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dlg_tfMakeModel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dlg_tfProdYear = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dlg_tfPlates = new javax.swing.JTextField();
        dlg_btAdd = new javax.swing.JButton();
        dlg_btDelete = new javax.swing.JButton();
        dlg_btUpdate = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        dlg_btUpdateOwner = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCarsOwners = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btDeletePhoto = new javax.swing.JButton();
        btManageCars = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCarsOwned = new javax.swing.JList<>();
        jButton6 = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        jList3.setModel(modelCarsList);
        jScrollPane3.setViewportView(jList3);

        jLabel6.setText("Id:");

        dlg_lblId.setText("-");

        jLabel8.setText("Make model:");

        jLabel9.setText("Prod year:");

        jLabel10.setText("Plates:");

        dlg_btAdd.setText("Add");

        dlg_btDelete.setText("Delete");

        dlg_btUpdate.setText("Update");

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList4);

        dlg_btUpdateOwner.setText("Update owner");

        jLabel2.setText("Owners of the car:");

        javax.swing.GroupLayout dlgCarsLayout = new javax.swing.GroupLayout(dlgCars.getContentPane());
        dlgCars.getContentPane().setLayout(dlgCarsLayout);
        dlgCarsLayout.setHorizontalGroup(
            dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgCarsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgCarsLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dlg_tfPlates, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(dlgCarsLayout.createSequentialGroup()
                        .addComponent(dlg_btAdd)
                        .addGap(18, 18, 18)
                        .addComponent(dlg_btDelete)
                        .addGap(18, 18, 18)
                        .addComponent(dlg_btUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dlg_btUpdateOwner)
                        .addGap(49, 49, 49))
                    .addGroup(dlgCarsLayout.createSequentialGroup()
                        .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dlgCarsLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(dlg_lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgCarsLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(dlg_tfMakeModel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlgCarsLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(dlg_tfProdYear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(61, 61, 61))))
        );
        dlgCarsLayout.setVerticalGroup(
            dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgCarsLayout.createSequentialGroup()
                .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dlgCarsLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dlgCarsLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(dlg_lblId)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlgCarsLayout.createSequentialGroup()
                                .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(dlg_tfMakeModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(dlg_tfProdYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(dlg_tfPlates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(dlgCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dlg_btAdd)
                            .addComponent(dlg_btDelete)
                            .addComponent(dlg_btUpdate)
                            .addComponent(dlg_btUpdateOwner))))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        fileChooser.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstCarsOwners.setModel(modelOwnersList);
        jScrollPane1.setViewportView(lstCarsOwners);

        jLabel1.setText("Id:");

        lblId.setText("-");

        jLabel3.setText("Name:");

        jLabel4.setText("Photo:");

        btDeletePhoto.setText("Delete photo");

        btManageCars.setText("Manage cars");

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");

        btDelete.setText("Delete");

        jLabel5.setText("Cars owned");

        lstCarsOwned.setModel(modelCarsOwnedList);
        jScrollPane2.setViewportView(lstCarsOwned);

        jButton6.setText("Give up car");

        lblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage.setText("No image");
        lblImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addGap(61, 61, 61))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btDeletePhoto)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btUpdate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btDelete)
                                        .addGap(98, 98, 98)
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btManageCars)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lblId))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btDeletePhoto)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdd)
                            .addComponent(btUpdate)
                            .addComponent(btDelete))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(btManageCars))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * *********** IMAGE LABEL ********
     */
    BufferedImage currentImage = null;
    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        /**
         * ******MOUSE CLICKED EVENT ON LBL WITH IMAGE *********
         */
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Export to File");

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {

            File chosenFile = fileChooser.getSelectedFile();

            if (!chosenFile.getName().toLowerCase().matches(FILENAME_PATTERN))
            {
                JOptionPane.showMessageDialog(this, "Please write type of file(extension) ",
                        "File extension error", JOptionPane.ERROR_MESSAGE);
                return;
            }

                try {
                    BufferedImage currentImage;
                    currentImage = ImageIO.read(chosenFile);
                    Image scaledImg = currentImage.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                    lblImage.setIcon(new ImageIcon(scaledImg));

                    
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error loading image file: " + ex.getMessage(),
                            "File error", JOptionPane.ERROR_MESSAGE);
                }

            
        }


    }//GEN-LAST:event_lblImageMouseClicked

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        /**
         * ************ ADD ACTION PERFORMED ***********
         */
             
        try
        {
                //get infromation from fileds
                String name = tfName.getText();

              //turn image into array
            File file = new File(fileChooser.getSelectedFile().getName());
            byte[] photo = Files.readAllBytes(file.toPath());

            int[] selectedIndexes = lstCarsOwned.getSelectedIndices();

            int numCarsOwned = selectedIndexes.length;


                //create object owner with all values (except id, as it is autoincrement)
                Owner owner = new Owner(0, name, numCarsOwned);


               db.addOwner(owner);  //InvalidDataException  


                //reload data from database to model
                loadOwnersFromDatabase();

                //cleanup inputs
        } 
        catch (IllegalArgumentException  | IOException | InvalidDataException ex ) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to add Flight: " + ex.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect: " + ex.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);
        }  
        
    }//GEN-LAST:event_btAddActionPerformed

    

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
            java.util.logging.Logger.getLogger(Day10CarOwners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day10CarOwners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day10CarOwners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day10CarOwners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day10CarOwners().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btDeletePhoto;
    private javax.swing.JButton btManageCars;
    private javax.swing.JButton btUpdate;
    private javax.swing.JDialog dlgCars;
    private javax.swing.JButton dlg_btAdd;
    private javax.swing.JButton dlg_btDelete;
    private javax.swing.JButton dlg_btUpdate;
    private javax.swing.JButton dlg_btUpdateOwner;
    private javax.swing.JLabel dlg_lblId;
    private javax.swing.JTextField dlg_tfMakeModel;
    private javax.swing.JTextField dlg_tfPlates;
    private javax.swing.JTextField dlg_tfProdYear;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<Car> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImage;
    private javax.swing.JList<Car> lstCarsOwned;
    private javax.swing.JList<Owner> lstCarsOwners;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}