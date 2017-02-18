import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringCompare {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int n = sc.nextInt();
		List<String> list = new ArrayList<String>();
		for(int i=0;i<S.length()-(n-1);i++){
			list.add(S.substring(i, i+n));
		}
		/* JAVA 8 IMPLEMENTATION */
		list.stream().forEach(System.out::println);
		String min = list.stream().reduce( (x,y) -> x.compareTo(y)<0 ? x : y).get();
		String max = list.stream().max( (x,y) -> x.compareTo(y)).get();
		System.out.println("min = "+min);
		System.out.println("max = "+max);

	}
}
