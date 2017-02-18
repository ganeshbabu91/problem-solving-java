import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
	     String S=sc.next();
	     String Scopy = S;
	     boolean flag = true;
	     for(int i=S.length()-1;i>=0;i--){
	    	 if(Scopy.charAt(i)!=S.charAt(S.length()-1-i)){
	    		 flag = false;
	    		 System.out.println("No");
	    		 break;
	    	 }
	     }
	     if(flag){
	    	 System.out.println("Yes");
	     }
	}

}
