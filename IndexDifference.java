import java.io.*;
import java.util.*;
import java.util.stream.*;

public class IndexDifference {

    public static void main(String[] args) {
        // Get the input
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arrayA = sc.nextLine().split(" ");
        String[] arrayB = sc.nextLine().split(" ");
        
        // Prepare the input (convert it to int array)
        int[] listA = new int[arrayA.length];
        int[] listB = new int[arrayB.length];
        int i;
        for(i=0;i<arrayA.length;i++){
            listA[i] = Integer.parseInt(arrayA[i]);
        }
        for(i=0;i<arrayB.length;i++){
            listB[i] = Integer.parseInt(arrayB[i]);
        }
        
        // Step 1 : Compute the difference between indices of each number in A and B
        Map<Integer,Integer> output = new HashMap<Integer,Integer>();
        for(i=0;i<listA.length;i++){
            int x = listA[i];
            for(int j=0;j<listB.length;j++){
                if(x == listB[j]){
                    int diff = Math.abs(i - j);
                    //System.out.println(x+"-"+listB[j]+" = "+diff);
                    // Push the result to the output map for final comparison
                    output.put(x,diff);
                }
            }
        }
        
        // Step 2 : Iterate the output map to find out the smallest index difference
        int minValue = Collections.min(output.values());
        
        // Step 3 : Get all the keys with the smallest index and output the smallest key
        Set<Integer> outputKeys = getKeysByValue(output, minValue);        
        int answer = Collections.min(outputKeys);
        System.out.println(answer);
        
    }
    
    /* Returns all keys of a Map for a given value */
    public static Set<Integer> getKeysByValue(Map<Integer,Integer> map, int value) {
    return map.entrySet()
              .stream()
              .filter(entry -> Objects.equals(entry.getValue(), value))
              .map(Map.Entry::getKey)
              .collect(Collectors.toSet());
    }
}