/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static quiz.Quiz.dateFormat;

/**
 *
 * @author user
 */
//can be declared outside of this class or inside
//if it is public then it has to be in separate file
//if just enum Gender{} then can be in the same file as Class Traveller
enum Status {Pending,Done,Delegated} // one of: Pending, Done, Delegated - matches the ComboBox in Swing GUI

class Todo {
	private String task; // 1-100 characters, made up of uppercase and lowercase letters, digits, space, %_-(),./\ only
	private int difficulty; // 1-5, as slider
	private Date dueDate; // year 1900-2100 both inclusive, use formatted field
        private Status status;

    public Todo(String task, int difficulty, Date dueDate, Status status) {
        //to turn field into private and add get/set
        //right click on field (this.task) in constructor>refactor>encapsulate fields
        setTask(task);
        setDifficulty(difficulty);
        setDueDate(dueDate);
        setStatus(status);   //does not really require validation as comes from combo
    }
    
    
	
    final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public String toString() {
        return String.format("%s;%d;%s;%s", task, difficulty,dateFormat.format(dueDate), status);
    
    }

    public String getTask() {
        return task;
    }

    
    public void setTask(String task) {
        if(!task.matches("[-\\_ \\%,\\.\\/\\\\A-Za-z0-9]{1,100}"))
       {
           //whenever setTask() is called in program, if new value does not match allowed once, it will throw 
           //IllegalArgumentException
           throw new IllegalArgumentException("Name must be 1-100 characters long,\n "
                   + "made up of uppercase and lowercase letters, digits, space, %_-(),./\\ only. ");
       }
        this.task = task;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        if(difficulty < 1 || difficulty > 5)
        {
            //whenever setDifficulty() is called in program, if new value does not match allowed once, it will throw 
           //IllegalArgumentException
           throw new IllegalArgumentException("Difficulty must be between 1 to 5");
        }
        this.difficulty = difficulty;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
      try
      {
          if(dueDate.before(dateFormat.parse("1900-01-01")) || dueDate.after(dateFormat.parse("2100-01-01")))
            {
                throw new IllegalArgumentException("Year must be between 1900 and 2100");
                 
            } 
          this.dueDate = dueDate;
      }
      
      catch(ParseException ex)  //turning parse exception into IllegalArgEx then person can just handle IllegalArg for both problems
      {
          throw new IllegalArgumentException ("Internal error in setDueDate()",ex); //ex is added here to say that IllegalArgEx was caused by ParseException
      }
        
        
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        //nothing to verify cuz it is enum and it will be one of specified values
        this.status = status;
    }
}
