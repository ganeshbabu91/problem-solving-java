import java.util.Scanner;

/**
* Given two strings, compute the number of changes for making them anagrams
*/
public class AnagramConversion {

	public static void main(String[] args) {
		
		// Prepare the input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] input = new String[n];
		
		for(int i=0;i<n;i++){
			input[i] = sc.next();
		}
		
		// Work on each test case
		for(int i=0;i<n;i++){
			int len = input[i].length();
			if(len%2==0){
				// Form a and b for each input
				String a = input[i].substring(0, len/2);
				String b = input[i].substring(len/2);
				// Do the computation of number of changes to be done for making a and b anagrams
				if(!isAnagram(a, b)){
					int output = computeReplacementCount(a, b, a.length(), b.length());
					output = output - findCommonChars(a, b);
					System.out.println(output);
				}else{
					System.out.println("0");
				}
			}else{ 
				System.out.println("-1");
			}
		}
	}
	
	static int computeReplacementCount(String a, String b, int alen, int blen)
	{
		if (alen == 0) {
			return blen;
		}else if (blen == 0) {
			return alen;
		}else if (a.charAt(alen-1) == b.charAt(alen-1)){
			return computeReplacementCount(a, b, alen-1, blen-1);
		}
		return computeReplacementCount(a, b, alen-1, blen-1)+1;					 
	}
	
	static int findCommonChars(String a, String b){
		int count = 0;
		for(int i=0;i<a.length();i++){
			if(b.indexOf(a.charAt(i))!=-1 ){
				count++;
			}
		}
		return count;
	}
	
	static boolean isAnagram(String a, String b){
		a = a.toLowerCase();
	    b = b.toLowerCase();
		boolean flag = false;
		if(a.length()==b.length()){
			for(int i=0;i<b.length();i++){
				int index = a.indexOf(b.charAt(i));
				if(index>=0) {
					flag = true;
					// Remove the character from the source string if its present
					a = a.substring(0,index) + a.substring(index+1,a.length());
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
