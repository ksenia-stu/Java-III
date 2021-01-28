package day10carowners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

public class Database {

    Connection conn;  //connection must be a field

    public Database() throws SQLException {
        //connect to database
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ipd23carowners", "root", "1112522kO");
    }

    /**
     * ***************** SELECT ALL CARS FROM DATABASE ************
     */
    ArrayList<Car> getAllCars() throws SQLException {

        ArrayList<Car> resultList = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Cars";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException

            while (result.next()) {
                //get values from columns
                int id = result.getInt("id");
                int ownerId = result.getInt("ownerId");
                String makeModel = result.getString("makeModel");
                int prodYear = result.getInt("prodYear");
                String plates = result.getString("plates");

                //create object Car
                Car car = new Car(id, ownerId, makeModel, prodYear, plates); // ex InvalidDataException
                resultList.add(car);
            }

        } catch (InvalidDataException | IllegalArgumentException ex) { // exception chaining
            throw new SQLException("Error getting car from database", ex);
        }
        return resultList;
    }
    
    
    /**
     * ***************** SELECT ALL OWNERS FROM DATABASE ************
     */
    ArrayList<Owner> getAllOwners() throws SQLException {

        ArrayList<Owner> resultList = new ArrayList<>();
        try {

            String sql = "SELECT Owners.id, Owners.name, count(Cars.id) as numberOfCars"
                    + "from Owners left join Cars on Owners.id = Cars.ownerId"
                    + "group by Owners.id, Owners.name";


            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException

            while (result.next()) {
                //get values from columns
                int id = result.getInt("Owners.id");
                String name = result.getString("Owner.name");
                int numCarsOwned = result.getInt("numberOfCars");

                //create object Owner
                Owner owner = new Owner(id, name, numCarsOwned); // ex InvalidDataException
                resultList.add(owner);
            }

        } catch (InvalidDataException | IllegalArgumentException ex) { // exception chaining
            throw new SQLException("Error getting car from database", ex);
        }
        return resultList;
    }
    
    
    /**
     ************* ADD OWNER TO DATABASE (Returns id of newly added item)   ************
     */
    public int addOwner(Owner o) throws SQLException {

        String sql = "INSERT INTO Owners (name, photo) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, o.getName());
        statement.setBytes(2, o.getPhoto());

        statement.executeUpdate();  //SQLException

        //obtain ID of the newly inserted record if needed
        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }
        //return -1;  // not good choice without any documentation
        throw new SQLException("Id after inserting not found");
    }
    

}







