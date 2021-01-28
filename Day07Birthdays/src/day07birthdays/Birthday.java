
package day07birthdays;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Birthday {
    private String name;
    private Date birthday;
    
   //date format
     static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     
   //today's date
     final static Date TODAY = Calendar.getInstance().getTime();
  
     //name pattern 
   static final String NAME_PATTERN = "[^;]{1,50}";

    public Birthday(String name, Date birthday) throws InvalidDataException {
        setName(name);
        setBirthday(birthday);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        if(!name.matches(NAME_PATTERN)){
            throw new InvalidDataException("Name must be 1-50 characters,no semicolons"); 
        }
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
   
    
  
    //returns number of days between today and birth date
    //use class Calendar
    public int getDaysTillBirthday()
    {
        
        Calendar calBDay = Calendar.getInstance();
        calBDay.setTime(getBirthday());
        calBDay.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
        if (new Date().after(calBDay.getTime())) calBDay.set(Calendar.YEAR, calBDay.get(Calendar.YEAR) + 1);
        Date nextBirthday = calBDay.getTime(); //next bdate

        return (int)((nextBirthday.getTime()/1000 - TODAY.getTime()/1000)/86400);  //86400 must be final
    
    }
    
    /* ALTERNATIVE
    public int getDaysTillBirthday(){
        
        LocalDate today = LocalDate.now();
        LocalDate bday = LocalDate.parse(Birthday.dateFormat.format(this.birthday));
        LocalDate nextBDay = bday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        long days = ChronoUnit.DAYS.between(today, nextBDay);
        
        return (int)days;
        
    }

    
    
    ALTERNATIVE 2
    public int getDaysTillBday() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.ofEpochDay((long) (bithday.getTime() / 8.64e+7));
        LocalDate nextBDay = birthday.withYear(today.getYear());
        //If your birthday has occurred this year already, add 1 to the year.
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }
        long p = ChronoUnit.DAYS.between(today, nextBDay);
        return (int) p;
    }

    */
    
    @Override
    public String toString()
    {
        return String.format("%s born %s bday in %d days", getName(), dateFormat.format(getBirthday()), getDaysTillBirthday());
    }
    
    
    public String toDataString()
    {
      
        return String.format("%s;%s;%d", getName(), dateFormat.format(getBirthday()), getDaysTillBirthday());
    }
    
    
    //compare by name (String)
   static final Comparator<Birthday> compareByName = (Birthday b1, Birthday b2) -> {
      return  b1.getName().compareTo(b2.getName());
    };
   
   //compare by date of birth (Date)
   static final Comparator<Birthday> compareByBirthday = (Birthday b1, Birthday b2) -> {
      return  b1.getBirthday().compareTo(b2.getBirthday());
    };
   
   //compare by number of days till birthday (int in seconds)
   static final Comparator<Birthday> compareByDaysTillBirthday = (Birthday b1, Birthday b2) -> {
      return  b1.getDaysTillBirthday() - b2.getDaysTillBirthday();
    };  

    
    
    
}