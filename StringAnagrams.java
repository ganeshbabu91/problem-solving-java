import java.util.Scanner;

public class StringAnagrams {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		System.out.println( ( isAnagram(A,B) ) ? "Anagrams" : "Not Angarams");
	}
	
	static boolean isAnagram(String A, String B){
		A = A.toLowerCase();
	    B = B.toLowerCase();
		boolean flag = false;
		if(A.length()==B.length()){
			for(int i=0;i<B.length();i++){
				int index = A.indexOf(B.charAt(i));
				if(index>=0) {
					flag = true;
					// Remove the character from the source string if its present (like flames :P)
					A = A.substring(0,index) + A.substring(index+1,A.length());
				}
				else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}
