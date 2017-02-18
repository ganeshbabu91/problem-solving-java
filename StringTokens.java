import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringTokens {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	     String s = scan.nextLine();
	     scan.close();
	     String[] tokens = s.split("[ !,?._'@]+");
	     int length = tokens.length;
	     List<String> list = new ArrayList<String>();
	     for(String token:tokens){
	    	 if(token.isEmpty()) length--;
	    	 else list.add(token);
	     }
	     System.out.println(length);
	     for(String s1:list){
		     System.out.println(s1);

	     }
	}

}
