import java.util.Scanner;

public class SubString {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int start = sc.nextInt();
		int end = sc.nextInt();
		String output = s.substring(start,end);
		System.out.println("output = "+output);
	}
}
