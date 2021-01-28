
package practice_dbcat;

public class Owner {
    
    private int id;
    private String surname;
    private int catId;

    public Owner(int id, String surname, int catId) {
        setId(id);
        setSurname(surname);
        setCatId(catId);
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
    
    
}
