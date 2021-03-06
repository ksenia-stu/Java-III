/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz1todo;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Quiz1Todo extends javax.swing.JFrame {

    
    DefaultListModel<Todo> modelThingsToDoList = new DefaultListModel<>();
    
   
    
    
    
    public Quiz1Todo() {
        initComponents();
        loadDataFromFile();
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
        lblTask = new javax.swing.JLabel();
        tfTask = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfDifficulty = new javax.swing.JTextField();
        sliderDifficulty = new javax.swing.JSlider();
        lblDueDate = new javax.swing.JLabel();
        ffDueDate = new javax.swing.JFormattedTextField();
        lblStatus = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstThingsToDo = new javax.swing.JList<>();
        btExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz 1 Todo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTask.setText("Task:");

        jLabel1.setText("Difficulty:");

        tfDifficulty.setText("2");
        tfDifficulty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDifficultyKeyReleased(evt);
            }
        });

        sliderDifficulty.setMajorTickSpacing(1);
        sliderDifficulty.setMaximum(5);
        sliderDifficulty.setMinimum(1);
        sliderDifficulty.setPaintLabels(true);
        sliderDifficulty.setPaintTicks(true);
        sliderDifficulty.setValue(2);
        sliderDifficulty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderDifficultyStateChanged(evt);
            }
        });

        lblDueDate.setText("Due Date:");

        lblStatus.setText("Status:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Done", "Delegated" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        lstThingsToDo.setModel(modelThingsToDoList);
        lstThingsToDo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstThingsToDo);

        btExport.setText("Export all to file...");
        btExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btExport, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTask)
                        .addGap(18, 18, 18)
                        .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDueDate)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ffDueDate)
                            .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTask)
                            .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(tfDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDueDate)
                            .addComponent(ffDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btDelete)
                    .addComponent(btUpdate)
                    .addComponent(btExport))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed

    private void sliderDifficultyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDifficultyStateChanged
        int value = sliderDifficulty.getValue();
        tfDifficulty.setText(value +"");
    }//GEN-LAST:event_sliderDifficultyStateChanged

    final int DIFFICULTY_DEFAULT = 0;
    
    private void tfDifficultyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDifficultyKeyReleased
        try{
            int value = Integer.parseInt(tfDifficulty.getText());
            int max = sliderDifficulty.getMaximum();
            int min = sliderDifficulty.getMinimum();
           
            value = value > max ? max : value;
            value = value < min ? min : value;
        }
        catch(NumberFormatException ex)
        {
            sliderDifficulty.setValue(DIFFICULTY_DEFAULT);
            tfDifficulty.setText(DIFFICULTY_DEFAULT + "");
        }
    }//GEN-LAST:event_tfDifficultyKeyReleased

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        //task
        String task = tfTask.getText();
        
         ArrayList<String> errors = new ArrayList<>();
         
          final String TASK_PATTERN = "[-_.,\\ //a-zA-Z]{1,100}";
  
       
         
        if (!task.matches(TASK_PATTERN))     
        {
            errors.add("Name must be 1-100 characters,\n made up of uppercase and lowercase letters, digits, space, _-(),./\\ only");
        } 
        
        
        //difficulty
        int difficulty = sliderDifficulty.getValue();
        
        //due date
        Date date = null ;
       try
       {
           
    
             date = Todo.dateFormat.parse(ffDueDate.getText());
             if (date.before(Todo.dateFormat.parse("1900/01/01")) || date.after(Todo.dateFormat.parse("2101/01/01")))
             {
                 errors.add("Year must be between 1900 and 2100");
             }
      
       }
       catch(ParseException ex)
       {
           errors.add("Due date is unparseable");
       }
       
       //Status
       String status = (String)comboStatus.getSelectedItem();
       
       
       if (errors.isEmpty())
       {
          Todo todo = new Todo(task, difficulty, date, status);
          modelThingsToDoList.addElement(todo);
       }
       else
       {
           JOptionPane.showMessageDialog(this, String.join("\n",errors), "Input error", JOptionPane.ERROR_MESSAGE);
       }
        
  
        
    }//GEN-LAST:event_btAddActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
         // deleting todo item
        Todo todo = lstThingsToDo.getSelectedValue();
        if(todo == null)
        {
            return;
        }
        int dialogAnswer = JOptionPane.showConfirmDialog (null, "Please confirm item to be deleted",
                "Confirm deletion",JOptionPane.OK_CANCEL_OPTION);
            if(dialogAnswer == JOptionPane.OK_OPTION)
            {
                //remove item
        modelThingsToDoList.removeElement(todo);
            }
          
        
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
       // updating item
        Todo todo = lstThingsToDo.getSelectedValue();
        
        if(todo == null)
        {
            return;
        }
        todo.task = tfTask.getText();
        todo.difficulty = sliderDifficulty.getValue();
        try
        {
            todo.dueDate = Todo.dateFormat.parse(ffDueDate.getText());
        }
        catch(ParseException ex)
        {
            JOptionPane.showMessageDialog(this,"Date is unparseable \n" + ex.getMessage(),"Date error ",  
                       JOptionPane.ERROR_MESSAGE);
        }
        todo.status = (String)comboStatus.getSelectedItem();

        lstThingsToDo.setModel(modelThingsToDoList);
                                                  

    }//GEN-LAST:event_btUpdateActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       saveDataToFile();
    }//GEN-LAST:event_formWindowClosing

    private void btExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActionPerformed

        FileDialog fileDialog = new FileDialog(Quiz1Todo.this, "Save File", FileDialog.SAVE);
        fileDialog.setVisible(true);
       
        String filename = null;
        if(fileDialog.getFile() != null)
        {
            filename = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(filename);
        }
     
        try
        {
            PrintWriter fileOutput = new PrintWriter(new FileWriter(new File(filename),true));
            String dataLine = null;
         for(int i = 0; i < modelThingsToDoList.size(); i++)
         {
             Todo todo = modelThingsToDoList.getElementAt(i);
             dataLine = String.format("%s;%d;%s;%s", todo.task, todo.difficulty, Todo.dateFormat.format(todo.dueDate), todo.status);
         }
             fileOutput.println(dataLine);
            
            setTitle(filename);
        }
        catch(IOException ex)
        {
            System.out.println("File Not Found");
        }
        JOptionPane.showMessageDialog(this,"File was saved","Success",  
                       JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btExportActionPerformed

    final String DATA_FILENAME = "todos.txt";
    
    void saveDataToFile()
    {
        
      
     try (PrintWriter fileOutput = new PrintWriter(new FileWriter(new File(DATA_FILENAME),true)))
     {
         String dataLine = null;
         for(int i = 0; i < modelThingsToDoList.size(); i++)
         {
             Todo todo = modelThingsToDoList.getElementAt(i);
             dataLine = String.format("%s;%d;%s;%s", todo.task, todo.difficulty, Todo.dateFormat.format(todo.dueDate), todo.status);
         }
             fileOutput.println(dataLine);
       }
   
     
     catch(IOException ex)
     {
      System.out.println("File Not Found");
                   
     }
    }
    
    void loadDataFromFile()
    {
        ArrayList<String> errors = new ArrayList<>();
        try(Scanner fileInput = new Scanner(new File(DATA_FILENAME)))    
        {
            //while there is next line, keep loading
            while(fileInput.hasNextLine())
            {
                String line = fileInput.nextLine();
                String [] dataStr = line.split(";");
                if(dataStr.length != 4)
                {
                    errors.add("error");
                    continue;
                }
                
                String task = dataStr[0];
                int difficulty;
                try
                {
                    difficulty = Integer.parseInt(dataStr[1]);
                }
                catch(NumberFormatException ex)
                {
                    errors.add("invalid difficulty");
                    continue;
                }
                
                Date dueDate = null;
                try {
                    dueDate = Todo.dateFormat.parse(dataStr[2]);
                   
                } catch (ParseException ex) {
                    //errror list
                    continue;
                }
                String status = dataStr[3];
                
              Todo todo = new Todo(task, difficulty, dueDate, status);
               modelThingsToDoList.addElement(todo);
            }
        }
        catch (IOException ex)
        {
            //if file is not found or any problem, display error message
            JOptionPane.showMessageDialog(this,"Error saving to file: \n" + ex.getMessage(),"error",  
                       JOptionPane.ERROR_MESSAGE);
          
            
        }
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
            java.util.logging.Logger.getLogger(Quiz1Todo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz1Todo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz1Todo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz1Todo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz1Todo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btExport;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JFormattedTextField ffDueDate;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDueDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTask;
    private javax.swing.JList<Todo> lstThingsToDo;
    private javax.swing.JSlider sliderDifficulty;
    private javax.swing.JTextField tfDifficulty;
    private javax.swing.JTextField tfTask;
    // End of variables declaration//GEN-END:variables
}
