/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03peopleadvanced;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * to create new custom class, we need to choose package (ex: day03peopleadvanced)
 * right click and new > java class > put name of class (starting with capital) ex:Person
 */
public class Person {

    //to create constructor: right click >insert code > constructor >select all >generate
    public Person(String name, int heightCm, Date dateOfBirth) {
        this.name = name;
        this.heightCm = heightCm;
        this.dateOfBirth = dateOfBirth;
        
    }

    public String getName() {
        return name;
    }

    public int getHeightCm() {
        return heightCm;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

   
    
    
    
        String name;
	int heightCm;
	Date dateOfBirth;
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	@Override
	public String toString() {
		// TODO: Fix display of the date
		return String.format("%s is %dcm tall born %s", name, heightCm, dateOfBirth);
	}
    
}
