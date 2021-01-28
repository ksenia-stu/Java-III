
package practice_dbcat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cat {
    private int id;
    private String name;
    private int age;
    private Date birthday;
    private ArrayList<String> owners;
    
   static SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
    
    Calendar today = Calendar.getInstance();
    Date todayDate = today.getTime();

    public Cat(int id, String name, int age, Date birthday, ArrayList<String> owners) throws BadDataException{
        setId(id);
        setName(name);
        setAge(age);
        setBirthday(birthday);
        setOwners(owners);
        
    }
    
     public Cat(int id, String name, int age, Date birthday) throws BadDataException{
        setId(id);
        setName(name);
        setAge(age);
        setBirthday(birthday);
      
        
    }
    
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) throws BadDataException {
        if(!name.matches(".{1,30}"))
        {
            throw new BadDataException ("Name must be between 1 and 30 characters");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) throws BadDataException {
        try
        {
           if(birthday.before(dateFormat.parse("1900-01-01")) || birthday.after(todayDate))
           {
               throw new BadDataException ("Year must be between 1900 and "+ today.get(Calendar.YEAR));
           }
        }
        catch(ParseException ex)
        {
           throw new BadDataException ("Internal date comparison error"); 
        }     
        this.birthday = birthday;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<String> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<String> owners) {
        this.owners = owners;
    } 
    
    @Override
    public String toString()
    {
        return String.format("[%s} %s is %d years old, born on %s, has owners %s", id, name, age, birthday, owners );
    }

    

    
    
}
