
package sortinglist;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Dog {
    private String name;
    private int age;
    private Date birthday;

    public Dog(String name, int age, Date birthday) {
        setName(name);
        setAge(age);
        setBirthday(birthday);
    }

    static public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
    @Override
    public String toString()
    {
        return String.format("%s is %d years old born on %s", name, age, dateFormat.format(birthday));
    }
    
    
    //sorting
    
    //name
    //compare by name (String)
   static final Comparator<Dog> compareByName = (Dog d1, Dog d2) -> {
      return  d1.getName().compareTo(d2.getName());
    };
   
   //age
   static final Comparator<Dog> compareByAge = (Dog d1, Dog d2) -> {
      return  d1.getAge() - d2.getAge();
    };
   
   //compare by date of birth (Date)
   static final Comparator<Dog> compareByBirthday = (Dog d1, Dog d2) -> {
      return  d1.getBirthday().compareTo(d2.getBirthday());
    };
}


