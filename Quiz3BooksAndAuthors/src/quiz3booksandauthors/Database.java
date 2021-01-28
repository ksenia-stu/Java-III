
package quiz3booksandauthors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialBlob;


public class Database {
    
    Connection conn;  

    public Database() throws SQLException {
        //connect to database
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/booksAndAuthors", "root", "1112522kO");
    }
    
    public ArrayList<String> getAllBooks() throws SQLException {

        ArrayList<String> resultList = new ArrayList<>();

        String sql = "SELECT B.id, B.title, A.name\n"
                + "FROM Books AS B\n"
                + "inner JOIN Authors AS A\n"
                + "ON B.id = A.bookId group by B.id, B.title;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); //SQLException
        while (result.next()) {

            int id = result.getInt("id");
            String title = result.getString("title");
            String name = result.getString("name");

            resultList.add(String.format("[%d] %s by %s", id, title, name));

        }

        return resultList;
    }
    
    // returns new id of newly inserted record
    public int addBook(Book book) throws SQLException {

        String sql = "insert into Books (title, isbn, pubDate, coverImg) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, book.getTitle());
        statement.setString(2, book.getIsbn());
        statement.setDate(3, new java.sql.Date(book.getPubDate().getTime()));
        Blob blob = new SerialBlob(book.getCoverImg());
        statement.setBlob(4, blob);

        statement.executeUpdate();  //SQLException

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }
    
    
    public ArrayList<String> getBookIsbns() throws SQLException {

        ArrayList<String> resultList = new ArrayList<>();

        String sql = "SELECT isbn FROM Books;";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql); //SQLException
        while (result.next()) {
            String isbn = result.getString("isbn");
            resultList.add(isbn);
        }
        return resultList;
    }
  
    // returns new id of newly inserted record
    public int addAuthor(Author a) throws SQLException {

        String sql = "insert into Authors (bookId, name) VALUES (?, ?)";

        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setInt(1, a.getBookId());
        statement.setString(2, a.getName());

        statement.executeUpdate();  //SQLException

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next()) {
            int lastInsertedId = rs.getInt(1);
            return lastInsertedId;
        }

        throw new SQLException("Id after insert not found");
    }
    
}
