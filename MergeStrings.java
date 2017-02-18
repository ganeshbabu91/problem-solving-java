import java.io.*;
import java.util.*;

public class MergeStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        int sum = A.length()+B.length();
        System.out.println(sum);
        String line2 = "No";
        String line3 = Character.toUpperCase(A.charAt(0))+A.substring(1)+" "+Character.toUpperCase(B.charAt(0))+B.substring(1);
        if(A.compareTo(B)>0){
            line2 = "Yes";
            line3 = Character.toUpperCase(B.charAt(0))+B.substring(1)+" "+Character.toUpperCase(A.charAt(0))+A.substring(1);
        }
        System.out.println(line2);
        System.out.println(line3);
        
    }
}
