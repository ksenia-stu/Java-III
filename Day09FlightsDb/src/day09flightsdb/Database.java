//FLIGHTS
package day09flightsdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Database {

    Connection conn;
    String connectionUrl
            = "jdbc:sqlserver://localhost:1433;databaseName=ipd23flights;user=sa;password=SQLServer2019;";

    public Database() throws SQLException {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        conn = DriverManager.getConnection(connectionUrl);
        /*   if (conn != null) {
            System.out.println("Connected");
        };  */

    }

    /**
     * ***************** SELECT ALL FROM DATABASE   ************
     */
    ArrayList<Flight> getAllFlights() throws SQLException {

        ArrayList<Flight> resultList = new ArrayList<>();
        try {

            String sql = "SELECT * FROM dbo.Flights";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql); //SQLException

            while (result.next()) {
                //get values from columns
                int id = result.getInt("id");
                Date onDay = result.getDate("onDay");
                String fromCode = result.getString("fromCode");
                String toCode = result.getString("toCode");
                String typeStr = result.getString("type");
                Flight.Type type = Flight.Type.valueOf(typeStr);  // ex IllegalArgumentException
                int passengers = result.getInt("passengers");

                //create object Flight
                Flight flight = new Flight(id, onDay, fromCode, toCode, type, passengers); // ex InvalidDataException
                resultList.add(flight);
            }

        } catch (InvalidDataException | IllegalArgumentException ex) { // exception chaining
            throw new SQLException("Error getting flight from database", ex);
        }
        return resultList;
    }

    /**
     ************* ADD RECORD TO DATABASE (Returns id of newly added item)   ************
     */
    public int addFlight(Flight f) throws SQLException {

        String sql = "INSERT INTO dbo.Flights (onDay, fromCode, toCode, type, passengers) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setDate(1, new java.sql.Date(f.getOnDay().getTime()));
        statement.setString(2, f.getFromCode());
        statement.setString(3, f.getToCode());
        statement.setString(4, f.getType().toString());
        statement.setInt(5, f.getPassengers());

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
    
    
    /************************** UPDATE RECORD IN DATABASE ******************/
    public void updateFlight(Flight f) throws SQLException{

        String sql = "UPDATE dbo.Flights SET onDay=?, fromCode=?, toCode=?, type=?, passengers=? WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setDate(1, new java.sql.Date(f.getOnDay().getTime()));
        statement.setString(2, f.getFromCode());
        statement.setString(3, f.getToCode());
        statement.setString(4, f.getType().toString());
        statement.setInt(5, f.getPassengers());
        
        statement.setInt(6, f.getId());

        statement.executeUpdate();
       
    }
    
    /***************** DELETE RECORD FROM DATABASE (by id) **************/
    public void deleteFlight(int id) throws SQLException{
        
        String sql = "DELETE FROM dbo.Flights WHERE id=?";
 
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);

        statement.executeUpdate();
        
    }
}
