
package quiz2.complete;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;

public class EmployeeSchedule {
    
    public final String NAME_DPT_PATTERN = "[^;\\^?\\@!\\~*]{2,50}";
    
    //toString date format
    static SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy");
    
    //output data format
    static SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    
   
  private String name; // 2-50 characters, not permitted are: ;^?@!~*
  private boolean isManager;
  private String department; // 2-50 characters, not permitted are: ;^?@!~*
  private Date dateHired; // year between 1900 and 2100
  private HashSet<Weekday> workdaysList = new HashSet<>(); // no duplicates allowed

    public EmployeeSchedule(String name, boolean isManager,
            String department, Date dateHired,HashSet<Weekday> workdaysList)  throws InvalidValueException{
        setName(name);
        setIsManager(isManager);
        setDepartment(department);
        setDateHired(dateHired);
        setWorkdaysList(workdaysList);
        
    }
    
    
    public EmployeeSchedule(String dataLine)  throws InvalidValueException{
      // Ginny M.*;2011-11-11;Shoes;Monday,Tuesday,Wednesday,Thursday
      String [] data = dataLine.split(";");
      if(data.length != 4)
      {
          throw new InvalidValueException ("Wrong data structure");
      }
      //name + isManager
      String name_manager = data[0];
      //last symbol of name+IsManager
      String nameLastSymbol = name_manager.substring(name_manager.length() - 1);
      //name
      name = ((nameLastSymbol.equals("*")) ? name_manager.substring(0, name_manager.length() - 1) : name_manager);
     //isManager
      isManager = ((nameLastSymbol.equals("*")));
      //workdaysList
      String [] days = data[3].split(","); //get array of days
      
      for(int i =0; i < days.length; i++)
      {
          Weekday day = Weekday.valueOf(days[i]);//convert String to enum Weekday
          workdaysList.add(day);  //add days to hahset 
      }
      
      
        setName(name);
        setIsManager(isManager);
        setDepartment(data[2]);
        try
        {
            Date date = outputDateFormat.parse(data[1]); //date = 2012-09-09
            setDateHired(date );
         
        }
        catch(ParseException ex)
        {
            throw new InvalidValueException ("Unparseable date format");
        }
        
        setWorkdaysList(workdaysList);
        
    }
  
  
  

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidValueException{
       if(!name.matches(NAME_DPT_PATTERN))
       {
           throw new InvalidValueException ("Name must be 2-50 characters,symbols not permitted are: ;^?@!~*");
       }
        this.name = name;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager)/* throws InvalidValueException */ {
     /*   if(isManager != true || isManager != false)
        {
           throw new InvalidValueException ("isManager must be true or false"); 
        } */
        this.isManager = isManager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) throws InvalidValueException {
       if(!department.matches(NAME_DPT_PATTERN))
       {
           throw new InvalidValueException ("Name must be 2-50 characters,symbols not permitted are: ;^?@!~*");
       }
        this.department = department;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) throws InvalidValueException{
        try
        {
            if(dateHired.before(outputDateFormat.parse("1900-01-01")) || dateHired.after(outputDateFormat.parse("2100-01-01")))
            {
                throw new InvalidValueException ("Hired date year must e between 1900 and 2100");
            }
        }
        catch(ParseException ex)
        {
            throw new InvalidValueException ("Date is unparseable");
        }
       
        this.dateHired = dateHired;
    }

    public HashSet<Weekday> getWorkdaysList() {
        return workdaysList;
    }

    public void setWorkdaysList(HashSet<Weekday> workdaysList) {
        this.workdaysList = workdaysList;
    }
  
  @Override
  public String toString()
  {
      String manager_employee;
      manager_employee = ((isManager) ? "manager" : "employee");
      return String.format("%s,%s of %s department,hired on %s, works on %s",
              name, manager_employee, department,
              dateFormat.format(dateHired),Arrays.toString(workdaysList.toArray()));
  }
  
  
  public String toDataString()
  {   String manager_employee;
      manager_employee = ((isManager) ? "*" : "");
      return String.format("%s%s;%s;%s;%s",
              name,manager_employee,
              outputDateFormat.format(dateHired),department,Arrays.toString(workdaysList.toArray()));
  }
  
  //sorting
    
    //name
    //compare by name (String)
   static final Comparator<EmployeeSchedule> compareByName = (EmployeeSchedule es1, EmployeeSchedule es2) -> {
      return  es1.getName().compareTo(es2.getName());
    };
  
   
   //compare by date hired (Date)
   static final Comparator<EmployeeSchedule> compareByDateHired = (EmployeeSchedule es1, EmployeeSchedule es2) -> {
      return  es1.getDateHired().compareTo(es2.getDateHired());
    };
    
}
