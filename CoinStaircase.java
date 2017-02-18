
public class CoinStaircase {
	public static void main(String[] args){
		int x = 3;
		int y = 4;
		int limit = 10;
		int multiplecount = limit/(x*y); 
		if(multiplecount>1) multiplecount += 1;
		int nx = limit/x;
		int ny = limit/y;
		int sumx = (nx * (x + x*nx))/2;
		int sumy = (ny * (y + y*ny))/2;
		System.out.println(sumx+sumy - multiplecount*(x*y));
	}
}
