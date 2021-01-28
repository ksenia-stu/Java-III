//
package day06sorting;

import java.util.Comparator;


public class Person implements Comparable<Person>{
    String name;
    int age;
    double heightMeters; //meters

    public Person(String name, int age, double heightMeters) {
        this.name = name;
        this.age = age;
        this.heightMeters = heightMeters;
    }
    
    
    
    @Override
    public String toString()
    {
        return String.format("Person{%s;%d;%.2f}", name, age, heightMeters);
    }

    @Override
    public int compareTo(Person o)
    {
     //compare by age
     return this.age  - o.age;  //if the same returns 0, if first obj > second obj it will return number >1, if first obj is less than second obj then return negative num
    }
    
    
    //To create another (our own sorting mechanism we use Comparator)
    //we need to choose 1 option between lambda and comparison by anonymous class
    
    //lambda version( anonymous method that takes 2 parameters(Person p1, Person p2) and returns
    //value computed by p1.name.compareTo(p2.name) expression
    static final Comparator<Person> compareByNameLambda = (Person p1, Person p2) -> p1.name.compareTo(p2.name);

    //this creates new anonymous class that implements interface Comparator and override method compare of interface Comparator
    static final Comparator<Person> compareByNameAnonClass = new Comparator<Person> ()
    {
            @Override
            public int compare(Person p1, Person p2) {
               return p1.name.compareTo(p2.name);
            }
    };
    
    //compare by height (asc)
    //OPTION 1
    static final Comparator<Person> compareByHeightAnonClass = new Comparator<Person> ()
    {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.heightMeters == p2.heightMeters)
                {
                    return 0;
                }
                if (p1.heightMeters > p2.heightMeters)   //change > for < to make it in descending order
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
              
            }
    };
    
    //OPTION 2 (compare by height) lambda
    static final Comparator<Person> compareByHeightLambda = (Person p1, Person p2) -> {
        if (p1.heightMeters == p2.heightMeters)
        {
            return 0;
        }
        if (p1.heightMeters > p2.heightMeters)   //change > for < to make it in descending order
        {
            return 1;
        }
        else
        {
            return -1;
        }
    };
    
    
    //OPTION 3 (compare by height) lambda short version
    static final Comparator<Person> compareByHeightLambdaShort = (Person p1, Person p2) ->
       p1.heightMeters == p2.heightMeters ? 0 : (p1.heightMeters > p2.heightMeters ? 1 : -1);
    
   
    
    //compare by name and then age
    static final Comparator<Person> compareByNameThenAgeAnonClass = new Comparator<Person> ()
    {
            @Override
            public int compare(Person p1, Person p2) {
               int result =  p1.name.compareTo(p2.name);
               //if the names are not the same then nothing to sort further
               if(result !=0)
               {
                   return result;
               }
               //if names are the same then we need to sort by age
               
                   return p1.age  - p2.age;
               
            }
    };
    
    
    
    
    

} //end of class Person


//not allowed to use this version which creates another class in Person class document
/*class ComparePersonByName implements Comparator <Person>
{

    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }

}

} */