
package quiz2employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;

class EmployeeSchedule {
 // EmployeeSchedule(String name, boolean isManager, String department, Date dateHired) { ... }
 // EmployeeSchedule(String dataLine) { ... }
  private String name; // 2-50 characters, not permitted are: ;^?@!~*
  private boolean isManager;
  private String department; // 2-50 characters, not permitted are: ;^?@!~*
  private Date dateHired; // year between 1900 and 2100
  private HashSet<Weekday> workdaysList = new HashSet<>(); // no duplicates allowed
  
  
  public final String NAME_DPT_PATTERN = "[^;\\^?\\@!\\~*]{2,50}";
  
  
  static public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
  static public SimpleDateFormat sdfmt2= new SimpleDateFormat("MMM dd,yyyy");

    public EmployeeSchedule(String name, boolean isManager,
            String department, Date dateHired, HashSet <Weekday> set)  throws InvalidValueException {
        setName(name);    
        setIsManager(isManager);
        setDepartment(department);
        setDateHired(dateHired);
        setWorkdaysList(set);
    }

  
    public EmployeeSchedule(String dataLine) throws InvalidValueException{
        
        String[] dataStr = dataLine.split(";");
        if (dataStr.length != 4) {
            throw new InvalidValueException("Invalid data structure,\n"
                    + "name, dateHired,department, working days per line"); 
        }
        try {
            String name_isManager = dataStr[0];
            String  aster = name_isManager.substring(name_isManager.length() - 1);
            isManager = (aster.equals("*") ? true : false);
            String nameStr = (isManager ? name_isManager : name_isManager.substring(0, name_isManager.length() - 1));
           //throws InvalidValueException
            setName(nameStr);
            setDateHired(dateFormat.parse(dataStr[1]));
            HashSet<String> set = new HashSet<>();
            String [] days = dataStr[2].split(",");
            for(int i = 0; i < days.length; i++)
            {
              set.add(days[i]);  
            }
           
        } catch(IllegalArgumentException e){                
            throw new InvalidValueException("Failed to find the gender enum data: " + e.getMessage());               
        } catch (ParseException ex) {
            throw new InvalidValueException("Failed to parse the input date: " + ex.getMessage());
        }
        
    }
  
  
  
    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidValueException{
        if(!name.matches(NAME_DPT_PATTERN))
        {
            throw new InvalidValueException("Name must be 2-50 characters, symbols not permitted are: ;^?@!~*");
        }
        this.name = name;
    }

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) throws InvalidValueException {
        if(!department.matches(NAME_DPT_PATTERN))
        {
            throw new InvalidValueException("Department name must be 2-50 characters, symbols not permitted are: ;^?@!~*");
        }
        this.department = department;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) throws InvalidValueException{
        try {
            if (dateHired.before(dateFormat.parse("1900-01-01"))
                    || dateHired.after(dateFormat.parse("2100-01-01"))) {
                throw new InvalidValueException("Year must be between 1900 and 2100");
            }
            this.dateHired = dateHired;
        } catch (ParseException ex) {
            // exception chaining
            throw new InvalidValueException (ex.getMessage());
        }
    }

    public HashSet<Weekday> getWorkdaysList() {
        return workdaysList;
    }

    public void setWorkdaysList(HashSet<Weekday> workdaysList) {
        this.workdaysList = workdaysList;
    }
    

    public String toDataString(){
        String manager;
        manager = (isManager ? "*" : "");
        
        return String.format("%s%s;%s;%s;%s", name,manager, dateFormat.format(dateHired),department,getWorkdaysList());
        
    }
    
  
  @Override
    public String toString() {
        String manager_employee;
        manager_employee = (isManager ? "manager" : "employee");
        return String.format("%s,%s of %s department, hired on %s works on %s", name,
                manager_employee, department,sdfmt2.format(dateHired),getWorkdaysList() );
                
    }
  
  //compare by name (String)
   static final Comparator<EmployeeSchedule> compareByName = (EmployeeSchedule es1, EmployeeSchedule es2) -> {
      return  es1.getName().compareTo(es2.getName());
    };
   
   //compare by date of birth (Date)
   static final Comparator<EmployeeSchedule> compareByHiredDate = (EmployeeSchedule es1, EmployeeSchedule es2) -> {
      return  es1.getDateHired().compareTo(es2.getDateHired());
    };
  
}
