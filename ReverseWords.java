import java.util.Scanner;

class ReverseWords{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String sentence = s.nextLine();
		String output = reverseWords(sentence);
		System.out.println(output);
	}
	
	public static String reverseWords(String sentence){
		String[] words = sentence.split("");
		int index = 0;
		for(String word:words){
			char[] reversedWord = new char[word.length];
			int i=0;
			for( int j=word.length();j>=0;j-- ){
				reversedWord[i++] = word.charAt(j); 
			}
			words[index++] = reversedWord.toString();
		}
		return String.join("",words);
	}
}
