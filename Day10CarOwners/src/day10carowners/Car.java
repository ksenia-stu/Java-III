
package day10carowners;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car {
    private int id;
    private Integer ownerId;
    private String makeModel;
    private int prodYear;
    private String plates;
    
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public final String MAKEMODEL_PATTERN = ".{1,100}";
    public final String PLATES_PATTERN = ".{1,10}";
    
    
    public Car (int id, Integer ownerId, String makeModel, int prodYear, String plates ) throws InvalidDataException {
        setId(id);
        setOwnerId(ownerId);
        setMakeModel(makeModel);
        setProdYear(prodYear);
        setPlates(plates);

    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) throws InvalidDataException {
        if (!makeModel.matches(MAKEMODEL_PATTERN)) {
            throw new InvalidDataException("Make model must be 1-100 characters");
        }
        this.makeModel = makeModel;
    }

    public int getProdYear() {
        return prodYear;
    }
    
    


    public void setProdYear(int prodYear) throws InvalidDataException {
       if( prodYear < 1900 || prodYear > 2100)
       {
           throw new InvalidDataException("Production  year must be between 1900 and 2100");
       }
        this.prodYear = prodYear;
        
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) throws InvalidDataException {
        if (!plates.matches(PLATES_PATTERN)) {
            throw new InvalidDataException("Plates must be 1-10 characters");
        }
        this.plates = plates;
    }
    
    
    @Override
    public String toString() {
       String owner_notOwner = ((getOwnerId() == null) ? "has no owner" : "owner");
       String plates_noPlates = ((getPlates().equals(null)) ? "no plates" : getPlates());
        return String.format("%d: %s,%d,%s,%s",
                id, makeModel,owner_notOwner, plates_noPlates);

    }  
            
}
