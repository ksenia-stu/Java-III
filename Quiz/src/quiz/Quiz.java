/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

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
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author user
 */
public class Quiz extends javax.swing.JFrame {

    DefaultListModel <Todo> modelTodoList = new DefaultListModel<Todo>();
    
      static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
      
      
    /**
     * Creates new form Quiz
     */
    public Quiz() {
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
        lblDifficulty = new javax.swing.JLabel();
        tfDifficulty = new javax.swing.JTextField();
        sliderDifficulty = new javax.swing.JSlider();
        lblDueDate = new javax.swing.JLabel();
        ftfDueDate = new javax.swing.JFormattedTextField();
        lblStatus = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        btAdd = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTodo = new javax.swing.JList<>();
        btExport = new javax.swing.JButton();

        fileChooser.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Things to do");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTask.setText("Task:");

        lblDifficulty.setText("Difficulty:");

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

        lblDueDate.setText("Due date:");

        ftfDueDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        lblStatus.setText("Status:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Done", "Delegated" }));

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");
        btUpdate.setEnabled(false);
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        lstTodo.setModel(modelTodoList);
        lstTodo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTodo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTodoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstTodo);

        btExport.setText("Export all to file");
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
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btExport)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTask)
                        .addGap(18, 18, 18)
                        .addComponent(tfTask))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDifficulty)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDueDate)
                                .addGap(9, 9, 9))
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftfDueDate)
                                    .addComponent(comboStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btDelete)
                                .addGap(28, 28, 28)
                                .addComponent(btUpdate)))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTask)
                            .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDifficulty)
                                .addComponent(tfDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDueDate)
                            .addComponent(ftfDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdd)
                    .addComponent(btDelete)
                    .addComponent(btUpdate)
                    .addComponent(btExport))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sliderDifficultyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderDifficultyStateChanged
      tfDifficulty.setText(sliderDifficulty.getValue()+"");
    }//GEN-LAST:event_sliderDifficultyStateChanged

    final int DEFAULT_DIFFICULTY = 2;
    private void tfDifficultyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDifficultyKeyReleased
       int difficulty;
        try
       {
           difficulty = Integer.parseInt(tfDifficulty.getText());
           if(difficulty < sliderDifficulty.getMinimum())
           {
               difficulty = sliderDifficulty.getMinimum();
           }
           if(difficulty > sliderDifficulty.getMaximum())
           {
               difficulty = sliderDifficulty.getMaximum();
           }
       }
       catch(NumberFormatException ex)
       {
            difficulty = DEFAULT_DIFFICULTY;
       }
        
        sliderDifficulty.setValue(difficulty);
    }//GEN-LAST:event_tfDifficultyKeyReleased

    private void lstTodoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTodoValueChanged
       if(lstTodo.getSelectedIndex() == -1 || modelTodoList.isEmpty())
       {
           btDelete.setEnabled(false);
           btUpdate.setEnabled(false);
           clearFields();
       }
       else
       {
           btDelete.setEnabled(true);
       btUpdate.setEnabled(true);
       
       Todo todo = lstTodo.getSelectedValue();
       tfTask.setText(todo.getTask());
       sliderDifficulty.setValue(todo.getDifficulty());
       tfDifficulty.setText(todo.getDifficulty()+"");
       ftfDueDate.setText(dateFormat.format(todo.getDueDate()));
       comboStatus.setSelectedItem(todo.getStatus());
       }
       
       
       
    }//GEN-LAST:event_lstTodoValueChanged

    private void clearFields()
    {
        tfTask.setText("");
       sliderDifficulty.setValue(2);
       tfDifficulty.setText("2");
       ftfDueDate.setText("");
       comboStatus.setSelectedIndex(0);
    }
    
    private Todo getTodoFromUserInput(Todo todo)
    {
         //task
       String task = tfTask.getText();
       //constructor is going to do validation
  /*     if(!task.matches("[-\\_ \\%,\\.\\/\\\\A-Za-z0-9]{1,100}"))
       {
           JOptionPane.showMessageDialog(this,"Name must be 1-100 characters long,\n"
                   + " made up of uppercase and lowercase letters, digits, space, %_-(),./\\ only. ","Input error",  
                       JOptionPane.ERROR_MESSAGE); 
          return;
       }  */
       
       //difficulty
       int difficulty = sliderDifficulty.getValue();
       
       //status
       Status stat = null;
       try
       {
           stat = Status.valueOf(comboStatus.getSelectedItem().toString()); //throws IleegalArgumentException
       }
       catch(IllegalArgumentException ex)
       {
           throw new IllegalArgumentException("Internal error: Unable to parse status to enum ");
       }
       
       
       //due date
       Date dueDate;
        try
         {
            //to get date (from formatted text field)
           //  dueDate = (Date)ftfDueDate.getValue();  //get value returns object that can be converted to String
           //get date from normal text filed
           dueDate = dateFormat.parse(ftfDueDate.getText());
             //constructor will do this validation
    /*      if(dueDate.before(dateFormat.parse("1900-01-01")) || dueDate.after(dateFormat.parse("2100-01-01")))
            {
                JOptionPane.showMessageDialog(this,"Year must be between 1900 and 2100 ","Input error",  
                       JOptionPane.ERROR_MESSAGE);    
            } */
         }
       catch(ParseException ex)
       {
           throw new IllegalArgumentException ("Input error: Unable to parse date");
       }  
    
        if(todo == null)
        {
            todo = new Todo(task, difficulty, dueDate, stat); //throws IllegalArgumentException
        }
        else
        {
            todo.setTask(task);   //throws IllegalArgumentException
            todo.setDifficulty(difficulty);    //throws IllegalArgumentException
            todo.setDueDate(dueDate);   //throws IllegalArgumentException
            todo.setStatus(stat);   //throws IllegalArgumentException
        }
       return todo;
    }
    
    
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
      //creating object with all input data
      try
      {
          Todo todo = getTodoFromUserInput(null); //Throws IllegalArgumentException
          //adding to model
          modelTodoList.addElement(todo);
          clearFields();
      }
      catch(IllegalArgumentException ex)
      {
          JOptionPane.showMessageDialog(this, ex.getMessage(),"Input error",  
                       JOptionPane.ERROR_MESSAGE);
      }
    
     
       
    }//GEN-LAST:event_btAddActionPerformed

    private void saveDataToFile(File file) //think of File as path
    {
        try(PrintWriter fileOutput = new PrintWriter(new FileWriter(file, false)))
        {
            for(int i =0; i < modelTodoList.size(); i++)
                {
                    fileOutput.println(modelTodoList.getElementAt(i));
                }
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(this,"Unable to write to file: \n" + ex.getMessage(),
                    "Fatal error - file access error:",  
                       JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void exportDataToFile()
    {
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
        fileChooser.setFileFilter(filter);
        int retrival = fileChooser.showSaveDialog(null);
        
        if(retrival == fileChooser.APPROVE_OPTION)
        {
            String filename = fileChooser.getSelectedFile().toString();
            
            String [] fileThings = filename.split("\\.");
            String fName = "";
            String extension;
            if(fileThings.length == 2)
            {
                fName = fileThings[0];
                extension = fileThings[1];
                if(!extension.equals(".txt"))
                {
                    filename = fName + ".txt";
                }
            }
            else
            {
               fName = fileThings[0];
               filename = fName + ".txt";
            }
            if(fName.equals(""))
            {
                JOptionPane.showMessageDialog(this, "File name must not be empty",
                        "Wrong file name",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            /*Alternative way of taking care of file extension (checking for .txt)
            fileChooser.setDialogTitle("Export to file");
            int returnVal = fileChooser.showSaveDialog(this);
            if(returnVal == fileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                if(file == null)
                {
                    return;
                }
                //.means any character, + means 1 or more ({1, infinity}), \\. means dot 
                //{a-zA-Z0-9] it is extension of file, + means 1 or more characters
                if(!file.getName().matches(".+\\.[a-zA-Z0-9]+"))
                {
                    file = new File(file.getParentFile(), file.getName() + ".txt");
                }
            }
            */
            
            
            
            saveDataToFile(new File(filename));
            JOptionPane.showMessageDialog(this, "File saved",
                 "Success",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    private void loadDataFromFile()
    {
       //create array to store errors
        ArrayList<String> errors = new ArrayList<>();
        int lineNo = 0;
        // loading info from a file
        try(Scanner fileInput = new Scanner(new File("todos.txt")))       //try to read from file
        {
           
            //while there is next line, keep loading
            while(fileInput.hasNextLine())
            {
                try
                {
                    String [] result = fileInput.nextLine().split(";");
                
                    if(result.length != 4)
                    {
                       errors.add("Invalid data structure in line: " + lineNo);
                       continue;
                    }
                    Status status = Status.valueOf(result[3]);//throws IllegalArgumentException
                    int difficulty = Integer.parseInt(result[1]); //throws ParseException
                    Date dueDate = dateFormat.parse(result[2]); //throws ParseException
                    Todo todo = new Todo(result[0],difficulty, dueDate ,status ); 

                    modelTodoList.addElement(todo);
                }
                //these 2 exception are handles in loop so we can continue reading other lines
                catch (ParseException ex)
                {
                    errors.add("Invalid date format in line: " + lineNo);
                }
                catch (IllegalArgumentException ex)
                {
                    errors.add("Internal error: Unable to parse status to enum ");
                }     
            }  
        }
        //this is handled outside of loop cuz if file is no found then there is no need to try read other lines 
        catch (IOException ex)
        {
            errors.add("Invalid data structure in line: " + lineNo);  
        }
        
        if(!errors.isEmpty())
        {
            //if there are errors, show them to user
            JOptionPane.showMessageDialog(this,String.join("\n", errors),
                    "Errors reading data file",
                       JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActionPerformed
    if(modelTodoList.isEmpty())
    {
        JOptionPane.showMessageDialog(this,"First add items to be saved",
                  "Action required",  
                       JOptionPane.ERROR_MESSAGE);
        return;
    }
        exportDataToFile();
     

    
    }//GEN-LAST:event_btExportActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed

       modelTodoList.remove(lstTodo.getSelectedIndex());
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        Todo todo = lstTodo.getSelectedValue();
        try
        {
           getTodoFromUserInput(todo);   //throws IllegalArgumentException 
           modelTodoList.setElementAt( todo, lstTodo.getSelectedIndex());
        }
        catch(IllegalArgumentException ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Input error", JOptionPane.ERROR_MESSAGE);
        }  
    
    }//GEN-LAST:event_btUpdateActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       saveDataToFile(new File("todos.txt"));
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
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btExport;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JFormattedTextField ftfDueDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDifficulty;
    private javax.swing.JLabel lblDueDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTask;
    private javax.swing.JList<Todo> lstTodo;
    private javax.swing.JSlider sliderDifficulty;
    private javax.swing.JTextField tfDifficulty;
    private javax.swing.JTextField tfTask;
    // End of variables declaration//GEN-END:variables
}