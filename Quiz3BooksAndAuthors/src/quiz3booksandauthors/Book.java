
package quiz3booksandauthors;

import java.util.Date;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Book { // table books
    private int id; // INT PK AI
    private String title; // VC(100), verify 1-100 chars long
    private String isbn; // VC(13) UNIQ, allow ISBN, regex: 13 character format - the first 12 are only 0-9, then last one is 0-9 or X, ignore dashes
    private Date pubDate; // DATE, any date is okay
    private Blob coverImg; // LARGEBLOB, no NULL allowed (picture must be assigned)
    private ArrayList<String> authorList; // not a field in the database but may help your implementation if you want to use it
    
    
    public final String TITLE_PATTERN = ".{1,100}";
     public final String ISBN_PATTERN = "[0-9]{12}[0-9X]{1}";
     
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Book(int id, String title, String isbn, Date pubDate,
            Blob coverImg,ArrayList<String> authorList) throws InvalidDataException{
        setId(id);
        setTitle(title);
        setIsbn(isbn);
        setPubDate(pubDate);
        setCoverImg(coverImg);
        setAuthorList(authorList);
        
    }
     
     
     
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidDataException{
        if (!title.matches(TITLE_PATTERN)) {
            throw new InvalidDataException("Title must be 1-100 characters long");
        }
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws InvalidDataException {
        if (!isbn.matches(ISBN_PATTERN)) {
            throw new InvalidDataException("ISBN must have 13 caracters, first 12 numbers, last can be number or X");
        }
        this.isbn = isbn;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Blob getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(Blob coverImg) {
        this.coverImg = coverImg;
    }

    public ArrayList<String> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ArrayList<String> authorList) {
        this.authorList = authorList;
    }
    
    @Override
    public String toString()
    {
       // - in Book, it should display id, title and all authors (comma-separated), something similar to:
   // "[56] Relic by Douglas Preston, Lincoln Child"
        return String.format("[%d] %s by %s", id, title, authorList.toString());
    }
    
    
    
}