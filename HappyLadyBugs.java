import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
* https://www.hackerrank.com/contests/w24/challenges/happy-ladybugs
*/
public class HappyLadyBugs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            char[] barr = b.toCharArray();
            List<String> list = new ArrayList<String>();
            for(int i=0;i<n;i++){
            	if(b.charAt(i)!='_')
            	list.add(b.charAt(i)+"");
            }
            Collections.sort(list);
            String sortedString = "";
            for(int i=0;i<list.size();i++){
            	sortedString += list.get(i);
            }
            System.out.println(list);
            boolean flag = true;
            if( b.indexOf("_")<0 && !b.equals(sortedString) ){
            	if(!reverse(b).equals(sortedString)){
            		flag = false;
            	}
            }
            else{
            	for(int i=0;i<list.size();i++){
                	if(list.indexOf(list.get(i)) == list.lastIndexOf(list.get(i))){
                		flag = false;
                		break;
                	}
                }
            }
            
            if(flag){
            	System.out.println("YES");
            }else{
            	System.out.println("NO");
            }
        }

	}

	private static String reverse(String b) {
		char[] barr = new char[b.length()];
		int j=0;
		String a = "";
		for(int i=b.length()-1;i>=0;i--){
			a += b.charAt(i);
		}
		System.out.println("reverese = "+a);
		return a;
	}

}
