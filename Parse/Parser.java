package Parse;

import Labels.*;

public class Parser{

  private String findTemp(String string, int index){
  	int i = index;
  	while ((string.charAt(i) != ' ') && (i < string.length()-1)) i++;
  	if (string.length()-1 == i) i++;
  	return string.substring(index, i);
  }

  private String ifLine(String line, Label labels){
  	String opcode = new String();
  	if (line.contains("<=")){
  	  opcode = opcode.concat("A4 ");
  	  String temp1, temp2;
  	  temp1 = findTemp(line, line.indexOf("f") + 2);
  	  temp2 = findTemp(line, line.indexOf("=") + 2);
  	  opcode = opcode.concat(temp1);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp2);
  	  opcode = opcode.concat(" ");
  	  int i = line.lastIndexOf("L");
  	  opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	}
  	else if (line.contains(">=")){
  	  opcode = opcode.concat("A2 ");
  	  String temp1, temp2;
  	  temp1 = findTemp(line, line.indexOf("f") + 2);
  	  temp2 = findTemp(line, line.indexOf("=") + 2);
  	  opcode = opcode.concat(temp1);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp2);
  	  opcode = opcode.concat(" ");
  	  int i = line.lastIndexOf("L");
  	  opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	}
  	else if (line.contains(">")){
  	  opcode = opcode.concat("A3 ");
  	  String temp1, temp2;
  	  temp1 = findTemp(line, line.indexOf("f") + 2);
  	  temp2 = findTemp(line, line.indexOf(">") + 2);
  	  opcode = opcode.concat(temp1);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp2);
  	  opcode = opcode.concat(" ");
  	  int i = line.lastIndexOf("L");
  	  opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	}
  	else if (line.contains("<")){
  	  opcode = opcode.concat("A1 ");
  	  String temp1, temp2;
  	  temp1 = findTemp(line, line.indexOf("f") + 2);
  	  temp2 = findTemp(line, line.indexOf("<") + 2);
  	  opcode = opcode.concat(temp1);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp2);
  	  opcode = opcode.concat(" ");
  	  int i = line.lastIndexOf("L");
  	  opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	}
  	else if (line.contains("!=")){
  	  opcode = opcode.concat("A6 ");
  	  String temp1, temp2;
  	  temp1 = findTemp(line, line.indexOf("f") + 2);
  	  temp2 = findTemp(line, line.indexOf("=") + 2);
  	  opcode = opcode.concat(temp1);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp2);
  	  opcode = opcode.concat(" ");
  	  int i = line.lastIndexOf("L");
  	  opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	}
  	else if (line.contains("=")){
  	  opcode = opcode.concat("A5 ");
  	  String temp1, temp2;
  	  temp1 = findTemp(line, line.indexOf("f") + 2);
  	  temp2 = findTemp(line, line.indexOf("=") + 2);
  	  opcode = opcode.concat(temp1);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp2);
  	  opcode = opcode.concat(" ");
  	  int i = line.lastIndexOf("L");
  	  opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	}
  	else System.out.println("Unkown 'if' clause");
  	return opcode;
  }

  private String gotoLine(String line, Label labels){
  	String opcode = new String();
  	opcode = opcode.concat("A7 ");
  	int i = line.lastIndexOf("L");
  	opcode = opcode.concat(labels.getPC(line.substring(i+1)));
  	return opcode;
    }

  private String exprLine(String line){
  	String temp1, temp2, temp3;
  	int i;
  	if (line.contains("+")){
  	  String opcode = new String("63 ");
  	  i = line.indexOf("=") - 2;
  	  while ((line.charAt(i) != ' ') && (i > 0)) i--;
  	  if (line.charAt(i) == ' ') i++;
	  temp3 = findTemp(line, i);
  	  temp2 = findTemp(line, line.indexOf("+") + 2);
  	  temp1 = findTemp(line, line.indexOf("=") + 2);
  	  opcode = opcode.concat(temp3);
  	  opcode = opcode.concat(" ");
      opcode = opcode.concat(temp1);
      opcode = opcode.concat(" ");
      opcode = opcode.concat(temp2);
      return opcode;
  	}
  	else if (line.contains("-")){
  	  String opcode = new String("67 ");
  	  temp1 = findTemp(line, line.indexOf("=") + 2);
  	  temp2 = findTemp(line, line.indexOf("-") + 2);
  	  i = line.indexOf("=") - 2;
  	  while ((line.charAt(i) != ' ') && (i > 0)) i--;
  	  if (line.charAt(i) == ' ') i++;
	  temp3 = findTemp(line, i);
  	  opcode = opcode.concat(temp3);
  	  opcode = opcode.concat(" ");
      opcode = opcode.concat(temp1);
      opcode = opcode.concat(" ");
      opcode = opcode.concat(temp2);
      return opcode;
  	}
  	else if (line.contains("*")){
  	  String opcode = new String("6B ");
  	  temp1 = findTemp(line, line.indexOf("=") + 2);
  	  temp2 = findTemp(line, line.indexOf("*") + 2);
  	  i = line.indexOf("=") - 2;
  	  while ((line.charAt(i) != ' ') && (i > 0)) i--;
  	  if (line.charAt(i) == ' ') i++;
	  temp3 = findTemp(line, i);
  	  opcode = opcode.concat(temp3);
  	  opcode = opcode.concat(" ");
      opcode = opcode.concat(temp1);
      opcode = opcode.concat(" ");
      opcode = opcode.concat(temp2);
      return opcode;
  	}
  	else if (line.contains("/")){
  	  String opcode = new String("6F");
  	  temp1 = findTemp(line, line.indexOf("=") + 2);
  	  temp2 = findTemp(line, line.indexOf("/") + 2);
  	  i = line.indexOf("=") - 2;
  	  while ((line.charAt(i) != ' ') && (i > 0)) i--;
  	  if (line.charAt(i) == ' ') i++;
	  temp3 = findTemp(line, i);
  	  opcode = opcode.concat(temp3);
  	  opcode = opcode.concat(" ");
      opcode = opcode.concat(temp1);
      opcode = opcode.concat(" ");
      opcode = opcode.concat(temp2);
      return opcode;
  	}
  	else{
  	  String opcode = new String("39 ");
  	  temp1 = findTemp(line, line.indexOf("=") + 2);
  	  i = line.indexOf("=") - 2;
  	  while ((line.charAt(i) != ' ') && (i > 0)) i--;
  	  if (line.charAt(i) == ' ') i++;
	  temp3 = findTemp(line, i);
  	  opcode = opcode.concat(temp3);
  	  opcode = opcode.concat(" ");
  	  opcode = opcode.concat(temp1);
  	  return opcode;
  	}
  }


  public String parseLine(String line, Label labels){
    if (line.contains("if ")) return ifLine(line, labels);
    else if (line.contains("goto ")) return gotoLine(line, labels);
    else if (line.contains("=")) return exprLine(line);
    else return "";
  }

}