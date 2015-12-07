import java.io.*;
import java.lang.String;

import Parse.*;
import Labels.*;

public class Main{

  public static void main(String[] args){
  	Parser parser = new Parser();
  	Label labels = new Label();
  	String asmbly;
  	int pc = 100;
  	try{
  		BufferedReader br = new BufferedReader(new FileReader(args[0]));
  		String line;
  		while ((line = br.readLine()) != null){
  			if (line.contains(":")) labels.fillLabels(line, pc);
  			pc++;
  		}
  	}
  	catch(Exception e){
  		System.out.println("Failed first");
  	}
    try{
      BufferedReader br     = new BufferedReader(new FileReader(args[0]));
      PrintWriter    writer = new PrintWriter("output","UTF-8");
      String line;
      while ((line = br.readLine()) != null) {
        asmbly = parser.parseLine(line, labels);
        writer.println(asmbly);
      }
      writer.close();
    }
    catch(Exception e){
    	System.out.println("Failed second");
    }
  }
}