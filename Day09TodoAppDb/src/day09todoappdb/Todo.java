
package day09todoappdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	private int id;
	private String task; // 1-100 characters (matching varchar length!), any characters are allowed
	private int difficulty; // 1-5
	private Date dueDate; // any valid date where year is 1970 to 2100 both inclusive
        private Status status;

	enum Status {
        Pending, Done, Delegated
    }

    public Todo(int id, String task, int difficulty, Date dueDate, Status status) throws InvalidDataException {
        setId(id);
        setTask(task);
        setDifficulty(difficulty);
        setDueDate(dueDate);
        setStatus(status);
        
    }
    
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) throws InvalidDataException {
      if(!task.matches(".{1,100}"))
      {
          throw new InvalidDataException ("Task must be between 1 and 100 characters");
      }
        this.task = task;
    }

    public int getDifficulty() {
        
        return difficulty;
    }

    public void setDifficulty(int difficulty)  throws InvalidDataException{
        if(difficulty < 1 || difficulty >5)
        {
            throw new InvalidDataException ("Difficulty must be between 1 and 5");
        }
        this.difficulty = difficulty;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) throws InvalidDataException {
        try
        {
            if(dueDate.before(dateFormat.parse("1970-01-01")) || dueDate.after(dateFormat.parse("2100-12-31")))
            {
                throw new InvalidDataException ("Year must be between 1970 and 2100");
            }
        }
        catch(ParseException ex)
        {
            throw new InvalidDataException("Date is unparseable");
        }
       
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
        
    @Override
    public String toString()
    {
        return String.format("%d: %s; diff: %d; by %s; status: %s;", id, task, difficulty, dueDate, status);
    }
}