import java.util.Scanner;

public class RollingStringOperation {
	
	public static String rollingString(String s, String[] operations) {
		 // Convert the string to char array for processing
		 char inputString[];
		 inputString = s.toCharArray();
		 int start=0,end=0; 
		 
		 // Perform all the operations in order on inputString
		 for(int i=0;i<operations.length;i++){
			 
			// Operations Format : i j L / i j R
			 String[] operationsArray ;
			 operationsArray = operations[i].split(" ");
			 start = Integer.parseInt(operationsArray[0]);
			 end = Integer.parseInt(operationsArray[1]);
			 
			 // Rolling Left
			 if(operationsArray[2].trim().equals("L")){
				 for(int j=start; j<=end; j++)
				 {
					 int number = inputString[j] - 'a' - 1;
					 char newchar = (char) ('a' + wrapAround(number));
					 inputString[j] = newchar;
				 }
			 }
			 
			 // Rolling Right
			 else if(operationsArray[2].equals("R"))
			 {
				 for(int j=start; j<=end; j++){
					 int number = inputString[j] - 'a' + 1;
					 char newchar = (char) ('a' + wrapAround(number));
					 inputString[j] = newchar;
				 }
			 }
		 }
		 return new String(inputString);
		 }
		 
     public static int wrapAround(int number) 
	 {
		 System.out.println(number);
		 int modulo = (number) % 26;
		 if(modulo < 0)
			 return modulo + 26;
		 else
			 return modulo;
	 }
		 
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		String s = "abc";
		String[] operations = new String[3];
		operations[0] = "0 0 L";
		operations[1] = "2 2 L";
		operations[2] = "0 2 R";
		String r = rollingString(s, operations);
		System.out.println("r = "+r);
	}

}
