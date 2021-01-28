package practice_dbcat;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;

public class Database {

    Connection conn;

    public Database() throws SQLException {
        //connect to database
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dbCat", "root", "1112522kO");
    }

    public ArrayList<Cat> getAllCats() throws SQLException 
    {
        ArrayList<Cat> resultList = new ArrayList<>();
        try 
        {
           

            String sql = "select id, name, age, birthday from Cats";
                    
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException
            
            while (result.next())
            {

                int id = result.getInt("id");
                
                
                //GET LIST OF SURNAMES from OWNERS 
        ArrayList<String> surnames = new ArrayList<>();
        
            String sql2 = "SELECT surname FROM owners WHERE catId=?;";
            PreparedStatement statement2 = conn.prepareStatement(sql2);

            
                statement2.setInt(1, id);
                ResultSet result2 = statement2.executeQuery();
            
                while (result2.next()){

                String surname = result2.getString("surname");
                

                surnames.add(surname);
                
                } 
                
                
                String name = result.getString("name");
                int age = result.getInt("age");
                Date birthday = result.getDate("birthday");
              //  ArrayList<String> owners = result.getString("surname");

                Cat cat = new Cat(id, name, age, birthday, surnames);
                resultList.add(cat);

             //   resultList.add(String.format("[%d] %s by %s", id, title, name));
            }

        }
        catch(BadDataException ex)
        {
            throw new SQLException ("Database error:"+ ex.getMessage());
        }

        return resultList;
    }
    
    public ArrayList<String> getNames() throws SQLException {

        ArrayList<String> resultList = new ArrayList<>();

        String sql = "SELECT name FROM Cats;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); //SQLException
        while (result.next()) {
            String name = result.getString("name");
            resultList.add(name);
        }
        return resultList;
    }
    
   /********** GET CATIDs FROM OWNERS  *********/ 
    public Map<Integer, ArrayList<String>> getCatIds() throws SQLException {
        
        Map<Integer, ArrayList<String>> map = new HashMap<>();

        //GET CATIDs from OWNERS
       ArrayList<Integer> catIds = new ArrayList<>();

        String sql1 = "SELECT distinct bookId FROM Owners;";
        Statement statement1 = conn.createStatement();
        ResultSet result1 = statement1.executeQuery(sql1); //SQLException
        while (result1.next()) {
            int catId = result1.getInt("catId");
            catIds.add(catId);
        }
        
       //GET LIST OF SURNAMES from OWNERS 
       ArrayList<String> surnames = new ArrayList<>();
        
            String sql2 = "SELECT surname FROM owners WHERE catId=?;";
            PreparedStatement statement2 = conn.prepareStatement(sql2);

            for(int i =0; i <catIds.size(); i++)
            {
                statement2.setInt(1, catIds.get(i));
                ResultSet result2 = statement2.executeQuery();
            
                while (result2.next()){

                String surname = result2.getString("surname");
                

                surnames.add(surname);
                
                
                map.put(catIds.get(i), surnames);
            }
            
                
                } 

        
        
        
        return map;
    }
    
    
    
    
    public ArrayList<String> getSurnames(int catId) throws SQLException{
        
        
        ArrayList<String> resultList = new ArrayList<>();
        
            String sql = "SELECT surname FROM owners WHERE catId=?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setInt(1, catId);
            ResultSet result = statement.executeQuery();
            
            while (result.next()){

                String surname = result.getString("surname");
                

                resultList.add(surname);
                
                } 

            
        return resultList;
    }
    
    
    
    // return new inserted record id
    public int addCat(Cat c) throws SQLException{
        
        String sql = "insert into Cats (name, age, birthday) VALUES (?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, c.getName());
        
        statement.setInt(2, c.getAge());
        if (c.getAge() != 0) 
        {
            statement.setInt(2, c.getAge());
        } 
        else
        {
            statement.setNull(2, Types.INTEGER);
        }
        
        statement.setDate(3, new java.sql.Date(c.getBirthday().getTime()));
        
        
        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if you need to
        ResultSet rs = statement.getGeneratedKeys();
        
        if(rs.next()){
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }
    
    public int addOwner(Owner o) throws SQLException{
        
        String sql = "insert into Owners (surname, catId) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, o.getSurname());
        
        statement.setInt(2, o.getCatId());
        
        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if you need to
        ResultSet rs = statement.getGeneratedKeys();
        
        if(rs.next()){
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }



}
