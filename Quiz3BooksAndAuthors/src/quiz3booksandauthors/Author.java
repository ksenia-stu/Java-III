
package quiz3booksandauthors;

public class Author { // table authors
    private int id; // INT PK AI
    private int bookId; // INT, FK -> books.id
    private String name; // VC(50), verify 1-50 chars long
    
    public final String NAME_PATTERN = ".{1,50}";

    public Author(int id, int bookId, String name) throws InvalidDataException {
        setId(id);
        setBookId(bookId);
        setName(name);
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException{
        if (!name.matches(NAME_PATTERN)) {
            throw new InvalidDataException("Name must be 1-50 characters long");
        }
        this.name = name;
    }
    
    @Override
    public String toString()
    { 
        return String.format("[%d} %s", id, name);
    }
    
}