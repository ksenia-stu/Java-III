
package day09todoappdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;


public class Database {
    
    
     Connection con;  //connection must be a field
     
     
    public Database() throws SQLException
    {
        //connect to database
         con =DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/ipd23todoapp","root","1112522kO"); 
    }
  
   //SELECT, a method that returns arrayList <Todo> from database with all records
   public  ArrayList<Todo> getAllTodos() throws SQLException 
    {
        ArrayList<Todo> list = new ArrayList<>();
        
          String sql = "SELECT * FROM todos";
          Statement statement = con.createStatement();
          ResultSet result = statement.executeQuery(sql); //SQLException

          while(result.next())
          {
             int id = result.getInt("id");
             String task = result.getString("task");
             int difficulty = result.getInt("difficulty");
             Date dueDate = result.getDate("duedate");
             Todo.Status status = Todo.Status.valueOf(result.getString("status"));
              
             try
             {
                list.add(new Todo(id, task, difficulty, dueDate, status)); 
             }
             catch (InvalidDataException | IllegalArgumentException ex)
             { // exception chaining
                throw new SQLException("Error creating todo from record", ex);
            }
             
          }
          return list;
    }
   
   //will add todo to database and return int (Id of just created todo)
   public int addTodo(Todo td) throws SQLException
   {
       
             //insert data to table todos
             //no need to insert id as it is auto increment
             String sql = "INSERT INTO todos (task, difficulty,duedate,status) VALUES (?, ?, ?, ?)";
 
             //[prepared statement helps to escape special characters and protects from sql injection
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  //con is the Connection name from connecting to database
            statement.setString(1, td.getTask());
            statement.setInt(2, td.getDifficulty());
            statement.setDate(3, new java.sql.Date(td.getDueDate().getTime()));
            statement.setString(4, td.getStatus() + "");
            
            statement.executeUpdate(); //SQLException

            /* IF METHOD WAS VOID THEN DIREGARD ALL THIS PART ----------*/
            /* In fact we do not really need to know what was newly inserted id */
            //obtain ID of newly inserted record
            ResultSet rs = statement.getGeneratedKeys(); //ask for set of generated keys (returns list of inserted ids)
            if(rs.next())
            {
                int lastInsertedId = rs.getInt(1);
                td.setId(lastInsertedId); //write back id to the object passed    //IT IS OPTIONAL
                return lastInsertedId;   //-------------UNTIL HERE
            }
            else
            {
                 //if inserted list is empty (no new ids)
                throw new SQLException ("Id after insert not found");
            }
           
   }
   
   Todo getTodoById(int id) throws SQLException {
        try {
            // Result set get the result of the SQL query
            PreparedStatement stmtSelect = con.prepareStatement("SELECT * FROM todos WHERE id=?");
            stmtSelect.setInt(1, id);
            ResultSet resultSet = stmtSelect.executeQuery();
            if (resultSet.next()) {
                String task = resultSet.getString("task");
                int difficulty = resultSet.getInt("difficulty");
                java.util.Date dueDate = resultSet.getDate("dueDate");
                String statusStr = resultSet.getString("status");
                Todo.Status status = Todo.Status.valueOf(statusStr); // ex IllegalArgumentException
                Todo td = new Todo(id, task, difficulty, dueDate, status); // ex InvalidDataException
                return td;
            } else {
                throw new SQLException("Record not found");
            }
        } catch (InvalidDataException | IllegalArgumentException ex) { // exception chaining
            throw new SQLException("Error creating todo from record", ex);
        }
    }
   
   
   public void updateTodo (Todo td) throws SQLException 
   {
       //we never update id
       
       String sql = "UPDATE todos SET task=?, difficulty=?, duedate=?, status=? WHERE id=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, td.getTask());
        statement.setInt(2, td.getDifficulty());
        statement.setDate(3, new java.sql.Date(td.getDueDate().getTime()));
        statement.setString(4, td.getStatus() + "");
        statement.setInt(5, td.getId());
        
        statement.executeUpdate();  //SQLException
        
   }
   
   public void deleteTodo(int id) throws SQLException
   {
       String sql = "DELETE FROM todos WHERE id=?";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setInt(1, id); //first ? will be set to value of id
         
         statement.executeUpdate();  //SQLException
   }
   
}
