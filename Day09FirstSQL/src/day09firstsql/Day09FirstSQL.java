
package day09firstsql;

//import it manually
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.*;

public class Day09FirstSQL {

    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)  {
     try
     {
         //connect to database
         Connection con=DriverManager.getConnection(  
         "jdbc:mysql://localhost:3306/ipd23people","root","1112522kO"); 
         
         
        {
          
            System.out.print("Enter name:");
            String name = input.nextLine();
            System.out.print("Enter age: ");
            int age = input.nextInt();

              //INSERT   //insert data to table people   
             //no need to insert id as it is auto increment
             String sql = "INSERT INTO people (name, age) VALUES (?, ?)";
 
             //[repared statement helps to escape special characters and protects from sql injection
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  //con is the Connection name from connecting to database
            statement.setString(1, name);
            statement.setInt(2, age);
            
            statement.executeUpdate(); //SQLException

            //obtain ID of newly inserted record
            ResultSet rs = statement.getGeneratedKeys(); //ask for set of generated keys
            if(rs.next())
            {
                int lastInsertedId = rs.getInt(1);
                System.out.println("Inserted new record with id "+lastInsertedId);
            }
        }
        
        //SELECT (retrieve records from database)
        //if select has no parameters then no prepared statement required, if has then we need prepared statement
        {
          String sql = "SELECT * FROM people";
          Statement statement = con.createStatement();
          ResultSet result = statement.executeQuery(sql); //SQLException

          while(result.next())
          {
             int id = result.getInt("id");
             String name = result.getString("name");
             int age = result.getShort("age");
              
              System.out.printf("Person: id=%d, name=%s, age=%d\n", id, name, age);
          }
        }
        
   /*     //UPDATE
        System.out.print("Enter id of record to update");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("New name: ");
        String name = input.nextLine();
        System.out.print("New age: ");
        int age = input.nextInt();
        input.nextLine(); //consume the left over newline
        
        String sql = "UPDATE people SET name=?, age=? WHERE id=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, name);
        statement.setInt(2, age);
        statement.setInt(3, id);
        
        statement.executeUpdate();
        System.out.println("Person updates successfully");   */
        
        //DELETE records
        {
         System.out.println("Enter record id to be deleted");
         int id = input.nextInt();
         input.nextLine();
         
         String sql = "DELETE FROM people WHERE id=?";
         PreparedStatement statement = con.prepareStatement(sql);
         statement.setInt(1, id); //first ? will be set to value of id
         
         int rowsDeleted = statement.executeUpdate();  //SQLException
         if(rowsDeleted > 0)
         {
             System.out.println("Record was deleted successfully");
         }
         else
         {
             System.out.println("Record to delete was not found");
         }
        }
     }
     
     
     
     catch(SQLException ex)
     {
         System.out.println("Error: " +ex.getMessage());
         ex.printStackTrace(); //never show to user, but can print in console to know where error comes from
     }
         
        
       
    }
    
}
