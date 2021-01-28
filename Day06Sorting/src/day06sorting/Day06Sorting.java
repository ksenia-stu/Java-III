
package day06sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day06Sorting {

  static ArrayList<Person> people = new ArrayList<>();
    public static void main(String[] args) {
        people.add(new Person("Safa", 29, 1.67));
        people.add(new Person("Cabra", 37, 1.9));
        people.add(new Person("Chibata", 37, 1.7));
        people.add(new Person("Woody", 13, 1.92));
        people.add(new Person("Safa", 51, 1.73));
        people.add(new Person("Viriato", 45, 1.78));
        people.add(new Person("Penarol", 2, 1.7));
        
        System.out.println("Original order of array:" + Arrays.deepToString(people.toArray()));
        
        //sorting array by age
        Collections.sort(people);
        
        //print sorted by age array (using Comparable)
        System.out.println("Sorted by age (using Comparable):" + Arrays.deepToString(people.toArray()));
        
        //sorting by name
        Collections.sort(people, Person.compareByNameLambda);
        
        //print sorted by name array (using Comparator)
        System.out.println("Sorted by name (using Comparator):" + people);
        
        
        //sorting by height
        Collections.sort(people, Person.compareByHeightLambda);
        
        //print sorted by name array (using Comparator)
        System.out.println("Sorted by height (using Comparator):" + people);      
        
        
        //sorting by name and age
        Collections.sort(people, Person.compareByNameThenAgeAnonClass);
        
        //print sorted by name array (using Comparator)
        System.out.println("Sorted by name and age (using Comparator):" + people);
    }
    
}
