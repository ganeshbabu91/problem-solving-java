import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatchingPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        Map<Integer,Integer> matchingPairs = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            int element = c[i];
            if(!matchingPairs.containsKey(element)){
                int count = 0;
                for(int j=0;j<n;j++){
                    int val = c[j];
                    if(element==val){
                        count++;
                    }
                }
                if(count>1)
                    matchingPairs.put(c[i],count/2);
            }
        }
        int totalPairs = 0;
        Set<Integer> keyset = matchingPairs.keySet();
        Iterator<Integer> i = keyset.iterator();
        	
        while(i.hasNext()){
        	int key = i.next();
        }
        
        for (Map.Entry<Integer,Integer> entry : matchingPairs.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            totalPairs += value;
        }
        System.out.println(totalPairs);
    }
}
