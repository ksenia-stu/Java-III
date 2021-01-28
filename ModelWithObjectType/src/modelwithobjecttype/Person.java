/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelwithobjecttype;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
class Person {
	String name;
	int heightCm;
	Date dateOfBirth;

    public Person(String name, int heightCm, Date dateOfBirth) {
        this.name = name;
        this.heightCm = heightCm;
        this.dateOfBirth = dateOfBirth;
    }
        
        
        
	
        //static makes it visible in all methods of the same class
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	
	@Override
	public String toString() {
		// TODO: Fix display of the date
		return String.format("%s is %dcm tall born %s", name, heightCm, dateFormat.format(dateOfBirth));
	}
}