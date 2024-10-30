
package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
   public Main() {
   }

   // @Override
   // public String toString() {
   //     return "The " + position + "recorded number of cyclists was in "+ season +", on a " + weekday + "in the month of " + month +".\n" 
   //     + "There were a total of " + getTotal() + "cyclists. The weather was "+ weather + ".\n" + weekday + "was " + holiday ;
   // }

   public static String[] parseLine(String line) {
      ArrayList<String> result = new ArrayList<>();
      StringBuilder currentField = new StringBuilder();

      for(int i = 0; i < line.length(); ++i) {
         char currentChar = line.charAt(i);
         if (currentChar == ',') {
            result.add(currentField.toString().trim());
            currentField.setLength(0);//reset field buffer
         } else {
            currentField.append(currentChar);
         }
      }

      result.add(currentField.toString().trim());
      return (String[])result.toArray(new String[0]);
   }

   public static void main(String[] args) throws IOException {
      String filePath = args[0];
	  Map<String, Integer> myBE = new HashMap<>();
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line = "";

	String[] headers = parseLine(br.readLine());
	//System.out.println(headers[0]);
	
      //where each col is a list of values 
      //then assign to bike entry with set bike entry
	  
      while (null != line) {
         line = br.readLine();
      }
      String checkOccur = line.trim();

      //need to add casual + registered to count for total
      for (String noOfCyclist: checkOccur.split(",")) {
         int currentCount = 0;
         if (myBE.containsKey(noOfCyclist)) 
            currentCount = myBE.get(noOfCyclist);
         currentCount++;

         myBE.put(noOfCyclist, currentCount);
      }

         
      
      while((line = br.readLine()) != null) {
            String[] values = parseLine(line);
         }
		
	
	//BikeEntry.toBikeEntry(1);

      System.out.println(headers.toString());
   }
}

//javac -d class --source-path src task01/src/vttp/batch5/sdf/task01/Main.java
//java -cp class vttp.batch5.sdf.task01.Main task01/day.csv
//Users/onion/Desktop/VISA/assessment1/vttp_b5_assessment_template/task01/day.csv