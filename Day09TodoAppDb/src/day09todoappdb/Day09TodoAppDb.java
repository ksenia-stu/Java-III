
package day09todoappdb;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Day09TodoAppDb extends javax.swing.JFrame {

   DefaultListModel<Todo> modelTodoList = new DefaultListModel<>();
   
   //set model for combo box and load enum Status values into combo box (into model)
   DefaultComboBoxModel<Todo.Status> modelStatusComboList = new DefaultComboBoxModel<>(Todo.Status.values());
    Database db;
   
    public Day09TodoAppDb() {
        initComponents();
        try 
        {
            db = new Database();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to connect " + ex.getMessage(),
                    "Database error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1); // FATAL ERROR, EXIT PROGRAM
        }
        reloadTodosFromDatabase();
    }

    void reloadTodosFromDatabase() {
        try 
        {
            ArrayList<Todo> todosList = db.getAllTodos();
            modelTodoList.clear();
            modelTodoList.addAll(todosList);
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to get all todos: " + ex.getMessage(),
                    "Database error",
                    JOptionPane.ERROR_MESSAGE); 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstTodos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfTask = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sliderDifficulty = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        tfDueDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        btAdd = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstTodos.setModel(modelTodoList);
        lstTodos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstTodos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTodosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstTodos);

        jLabel1.setText("Id:");

        lblId.setText("-");

        jLabel3.setText("Task:");

        jLabel2.setText("Difficulty:");

        sliderDifficulty.setMaximum(5);
        sliderDifficulty.setMinimum(1);
        sliderDifficulty.setPaintLabels(true);
        sliderDifficulty.setPaintTicks(true);
        sliderDifficulty.setValue(2);

        jLabel4.setText("Due date:");

        jLabel5.setText("Satus:");

        comboStatus.setModel(modelStatusComboList);

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(6, 6, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btAdd)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btUpdate)
                                .addGap(44, 44, 44)
                                .addComponent(btDelete)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tfDueDate))
                            .addComponent(comboStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblId))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(sliderDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdd)
                            .addComponent(btUpdate)
                            .addComponent(btDelete)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
      try {
            String task = tfTask.getText();
            int diff = sliderDifficulty.getValue();
            Date dueDate = Todo.dateFormat.parse(tfDueDate.getText()); // ex ParseException
            Todo.Status status = (Todo.Status) comboStatus.getSelectedItem();
            Todo todo = new Todo(0, task, diff, dueDate, status); // ex InvalidDataException
            int id = db.addTodo(todo); // ex SQLException
            System.out.println("New Id = " + id);
            reloadTodosFromDatabase();
        } catch (ParseException | InvalidDataException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to add todo: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE); 
        }
     
    }//GEN-LAST:event_btAddActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
       try
     {
        int id = Integer.parseInt(lblId.getText());
        String task = tfTask.getText();
        int difficulty = (Integer)sliderDifficulty.getValue();
         Date dueDate = Todo.dateFormat.parse(tfDueDate.getText()); // ex ParseException
         Todo.Status status = (Todo.Status) comboStatus.getSelectedItem();
            
            Todo todo = new Todo(id, task, difficulty, dueDate, status); // ex InvalidDataException

        

        db.updateTodo(todo);
        reloadTodosFromDatabase();
     }
     catch(SQLException ex)
        {
            ex.printStackTrace(); //user cant see it, just in console (to resolve error)
            //it is a fatal error if it cant connect to database
            JOptionPane.showMessageDialog(this, "Failed to update record",
                 "Database error",JOptionPane.ERROR_MESSAGE);
        }
     catch(NumberFormatException ex)
     {
         ex.printStackTrace(); //user cant see it, just in console (to resolve error)
            //it is a fatal error if it cant connect to database
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                 "Internal error",JOptionPane.ERROR_MESSAGE);
     }
     catch(ParseException ex)
     {
         ex.printStackTrace(); //user cant see it, just in console (to resolve error)
            //it is a fatal error if it cant connect to database
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                 "Internal error",JOptionPane.ERROR_MESSAGE);
     }
       catch(InvalidDataException ex)
     {
         ex.printStackTrace(); //user cant see it, just in console (to resolve error)
            //it is a fatal error if it cant connect to database
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                 "Internal error",JOptionPane.ERROR_MESSAGE);
     }
       
     
        
    }//GEN-LAST:event_btUpdateActionPerformed

    private void lstTodosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTodosValueChanged
        Todo todo = lstTodos.getSelectedValue();
        if (todo == null) {
            btDelete.setEnabled(false);
            btUpdate.setEnabled(false);
            lblId.setText("-");
        } else {
            btDelete.setEnabled(true);
            btUpdate.setEnabled(true);
            lblId.setText(todo.getId() + "");
            tfTask.setText(todo.getTask());
            sliderDifficulty.setValue(todo.getDifficulty());
            tfDueDate.setText(Todo.dateFormat.format(todo.getDueDate()));
            comboStatus.setSelectedItem(todo.getStatus());
        }
    }//GEN-LAST:event_lstTodosValueChanged

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
       try
       {
          db.deleteTodo(lstTodos.getSelectedValue().getId());
        reloadTodosFromDatabase(); 
       }
       catch(SQLException ex)
        {
            ex.printStackTrace(); //user cant see it, just in console (to resolve error)
            //it is a fatal error if it cant connect to database
            JOptionPane.showMessageDialog(this, "Failed to delete record",
                 "Database error",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Day09TodoAppDb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Day09TodoAppDb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btUpdate;
    private javax.swing.JComboBox<Todo.Status> comboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JList<Todo> lstTodos;
    private javax.swing.JSlider sliderDifficulty;
    private javax.swing.JTextField tfDueDate;
    private javax.swing.JTextField tfTask;
    // End of variables declaration//GEN-END:variables
}