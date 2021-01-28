
package day06teammembers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Day06TeamMembers {
//create hashmap     
   static public  HashMap<String, ArrayList<String>> playersByTeams = new HashMap<>();  //key name //value team
    
    public static void main(String[] args) {
       loadDataFromFile();
       
      
            playersByTeams.entrySet().forEach(entry->{
    System.out.println(entry.getKey() + " " + entry.getValue());  
 });
       
}
       
       
    
    
    
   static public void loadDataFromFile() {
   
        ArrayList<String> teams = new ArrayList<>();
        try (Scanner fileInput = new Scanner(new File("teams.txt"))) {
            while (fileInput.hasNextLine()) {
                
                  
                    String line = fileInput.nextLine();
                    
                    String data[] = line.split(":"); 
                    String team  = data[0];
                    
                    String names = data[1];
                  
                    
                    String [] nomes = names.split(",");  //get array nomes of separate names
                    
                    
                    teams.add(team);
                   
                    //add to hashmap
                    for(int i =0; i < nomes.length; i++)
                    {
                        
                        if(!playersByTeams.containsKey(i))
                        {
                           playersByTeams.put(nomes[i],teams ); 
                        }
                     /*   else
                        {
                            playersByTeams.put(nomes[i],teams );
                        } */
                    }  
                   
            }       
      
        } catch (IOException ex) {
           
        }
       
        
    }
}
