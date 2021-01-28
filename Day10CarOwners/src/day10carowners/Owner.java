
package day10carowners;

public class Owner {
    private int id;
    private String name;
    private int numOfCarsOwned;
    private byte []  photo;

    public final String NAME_PATTERN = ".{1,100}";

    public Owner(int id, String name, int numOfCarsOwned) throws InvalidDataException {
        setId(id);
        setName(name);
        setNumOfCarsOwned(numOfCarsOwned);
        
    }
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
/********* VERIFY UNIQUENESS OF NAME (if exist already in database) *********/
    public void setName(String name) throws InvalidDataException{
      if (!name.matches(NAME_PATTERN)) {
            throw new InvalidDataException("Name must be 1-100 characters");
        }
        this.name = name;
    }

    public int getNumOfCarsOwned() {
        return numOfCarsOwned;
    }

    public void setNumOfCarsOwned(int numOfCarsOwned) {
        this.numOfCarsOwned = numOfCarsOwned;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    
    
    /***** VERIFY BLOB  (IT CAN BE NULL) *********/
    
}
