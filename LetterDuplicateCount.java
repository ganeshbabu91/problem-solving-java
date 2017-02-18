import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterDuplicateCount {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		char[] letters = s.toCharArray();
		Map<Character, Integer> output = new HashMap<Character,Integer>();
		for(char letter : letters){
			if(!output.containsKey(letter)){
				output.put(letter, 1);
			} else{
				output.put(letter, output.get(letter)+1);
			}
		}
		System.out.println("output = "+output);
		String answer = "";
		for(char letter : letters){
			if(output.containsKey(letter)&&output.get(letter)>1){
				answer += ""+ output.get(letter)+letter;
				output.remove(letter);
			}
		}
		System.out.println("answer = "+answer);
	}
}
