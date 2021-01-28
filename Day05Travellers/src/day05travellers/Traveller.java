
package day05travellers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Traveller {
    private String name;
    private Gender gender;
    private String passportNo;
    private String destAirportCode;
    private Date depDate;
    private Date retDate;

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Traveller(String name, Gender gender, String passportNo,
            String destAirportCode, Date depDate, Date retDate) throws InvalidDataException {
        setName(name);
        setGender(gender);
        setPassportNo(passportNo);
        setDestAirportCode(destAirportCode);
        setDepRetDate(depDate, retDate);
    }
    
    public Traveller(String dataLine)throws InvalidDataException {
        String [] results = dataLine.split(";");
        if(results.length != 6)
        {
           throw new InvalidDataException("Invalid data structure"); 
        }
        try
        {
            setName(results[0]);  //throws InvalidDataException
            setGender(Gender.valueOf(results[1])); //throws IllegalArgumentException
            setPassportNo(results[2]); //throws InvalidDataException
            setDestAirportCode(results[3]);  //throws InvalidDataException
            setDepRetDate(dateFormat.parse(results[4]), dateFormat.parse(results[5])); //throws parse exception
        }
        catch (ParseException ex)
        {
            throw new InvalidDataException ("Invalid date format");
        }
        catch (IllegalArgumentException ex)
        {
            throw new InvalidDataException ("Internal error: Unable to parse gender to enum");
                    
        } 
     
    }
    
    
    
    
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidDataException {
        if(!name.matches("[-\\.(\\) a-zA-Z0-9]{2,50}"))
        {
            throw new InvalidDataException("Name must be 2-50 characters long, made of uppercase/lowercase, digits, .()- only");
        }
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassportNo() {
        
        return passportNo;
    }

    public void setPassportNo(String passportNo)  throws InvalidDataException{
        if(!passportNo.matches("[A-Z]{2}[0-9]{6}"))
        {
            throw new InvalidDataException("Passport number must be made of two uppercase letters, then 6 digits");
        }
        this.passportNo = passportNo;
    }

    public String getDestAirportCode() {
        return destAirportCode;
    }
    
    public void setDestAirportCode(String destAirportCode)  throws InvalidDataException{
        if(!destAirportCode.matches("[A-Z]{3}"))
        {
            throw new InvalidDataException("Destinations airport must be made of three uppercase letters");
        }
        this.destAirportCode = destAirportCode;
    }


    public Date getDepDate() {
        return depDate;
    }
    
     public Date getRetDate() {
        return retDate;
    }

    public void setDepRetDate(Date depDate, Date retDate) throws InvalidDataException {
          if(retDate.before(depDate))
            {
                throw new InvalidDataException("Return date must be after departure date");
            } 
         this.depDate = depDate;
         this.retDate = retDate;   
    }

    public String toDataString()
    {
      
        return String.format("%s;%s;%s;%s;%s;%s", this.name, this.gender, this.passportNo,
               this.destAirportCode, dateFormat.format(depDate), dateFormat.format(retDate));
    }
    
    @Override  //need to add override because originil toString() method exists in java Object
   public String toString()
   {
       return String.format("%s;%s;%s;%s;%s;%s", name, gender, passportNo,
               destAirportCode, dateFormat.format(depDate), dateFormat.format(retDate));
   }
   
   //number of seconds between dep date and return date
   public int getTripLength()
   {
       return (int)(retDate.getTime()/1000 - depDate.getTime()/1000);
   }

   //compare by name (String)
   static final Comparator<Traveller> compareByName = (Traveller t1, Traveller t2) -> {
      return  t1.name.compareTo(t2.name);
    };
   
   //compare by gender (enum Gender)
   static final Comparator<Traveller> compareByGender = (Traveller t1, Traveller t2) -> {
      return  t1.gender.compareTo(t2.gender);
    };
   
   //compare by departure date (Date)
   static final Comparator<Traveller> compareByDepDate = (Traveller t1, Traveller t2) -> {
      return  t1.depDate.compareTo(t2.depDate);
    };
   
   //compare by trip length (int in seconds)
   static final Comparator<Traveller> compareByTripLength = (Traveller t1, Traveller t2) -> {
      return  t1.getTripLength() - t2.getTripLength();
    };
    
    
            
}
