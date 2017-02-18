import java.util.InputMismatchException;
import java.util.Scanner;

class HammingDistance{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		try{
			int x = s.nextInt();
			int y = s.nextInt();
			int result = bitShiftHammingDistance(x,y);
			System.out.println(result);
		}catch(IllegalArgumentException argsException){
			System.err.println(argsException.getMessage());
		}catch(InputMismatchException inputException){
			System.err.println("Please specifiy a valid integer");
		}catch(Exception ex){
			ex.printStackTrace();
		}
}

/*
* Find Hamming Distance between two integers 
* @param x integer
* @param y integer
* @return result hamming distance between x and y
*/

public static int hammingDistance(int x, int y){
	if ( x == y ) return 0;
	int max = (int)Math.pow(2, 31);
	if(x < 0 || y < 0 || x > max || y > max){
		throw new IllegalArgumentException("Input should range from 0 to "+max);
	}
	String binary_x = Integer.toBinaryString(x);
	String binary_y = Integer.toBinaryString(y);
	System.out.println(binary_x + " & "+ binary_y);
	int n = binary_x.length() > binary_y.length() ? 
    binary_x.length() : binary_y.length();
	int distance = 0;
	for(int i=0; i<n; i++){
		char value1, value2;
		if(binary_x.length()<n){
			value1 = binary_x.length()<n-i ? '0' : binary_x.charAt(binary_x.length()-(n-i));
			value2 = binary_y.charAt(i);
		} else if(binary_y.length()<n){
			value1 = binary_x.charAt(i);
			value2 = binary_y.length()<n-i ? '0' : binary_y.charAt(binary_y.length()-(n-i));
		} else{
			value1 = binary_x.charAt(i);
			value2 = binary_y.charAt(i);
		}
		if(value1 != value2){
			distance++;
		}
	}
	return distance;
}

public static int optimizedHammingDistance(int x, int y){
	return Integer.bitCount(x^y);
}

public static int bitShiftHammingDistance(int x, int y){
	int xor = x ^ y;
	int count = 0;
	for(int i=0;i<32;i++){
		count += xor>>i & 1;
	}
	return count;
}

}
