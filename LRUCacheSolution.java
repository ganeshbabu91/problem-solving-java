import java.util.*;

/**
* https://leetcode.com/problems/lru-cache/?tab=Description
*/
public class LRUCacheSolution {
    public static void main(String[] args) {
        int capacity = 2;
        LRUCache obj = new LRUCache(capacity);
        /* Input Set 1
        
        obj.put(3,30);
        obj.put(1,10);
        obj.put(2,20);
        obj.put(4,40);
        System.out.println(obj);
        System.out.println("getting 5: "+obj.get(5));
        System.out.println(obj);
        System.out.println("getting 1: "+obj.get(1));
        System.out.println(obj);
        System.out.println("putting 5: ");
        obj.put(5,50);
        System.out.println(obj);
        System.out.println("putting 12: ");
        obj.put(12,120);
        System.out.println(obj);
        
        */

        /* Input Set 2
        System.out.println("getting 2: "+obj.get(2));
        System.out.println(obj);
        
        System.out.println("putting (2,6) ");
        obj.put(2,6);
        System.out.println(obj);
        
        System.out.println("getting 1: "+obj.get(1));
        System.out.println(obj);
        
        System.out.println("putting (1,5) ");
        obj.put(1,5);
        System.out.println(obj);
        
        System.out.println("putting (1,2) ");
        obj.put(1,2);
        System.out.println(obj);
        
        System.out.println("getting 1: "+obj.get(1));
        System.out.println(obj);
        
        System.out.println("getting 2: "+obj.get(2));
        System.out.println(obj);
        */

        // Input Set 3

        System.out.println("putting (2,1) ");
        obj.put(2,1);
        System.out.println(obj);
        
        System.out.println("putting (1,1) ");
        obj.put(1,1);
        System.out.println(obj);
        
        System.out.println("putting (2,3) ");
        obj.put(2,3);
        System.out.println(obj);
        
        System.out.println("putting (4,1) ");
        obj.put(4,1);
        System.out.println(obj);
        
        System.out.println("getting 1: "+obj.get(1));
        System.out.println(obj);
        
        System.out.println("getting 2: "+obj.get(2));
        System.out.println(obj);

    }
}
class LRUCache {
    int capacity = 0;
    int count = 0;
    HashMap<Integer, Integer> lruCacheMap = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int value = -1;
        if(lruCacheMap.containsKey(key)){
            value = lruCacheMap.get(key);
            lruCacheMap.remove(key);
            lruCacheMap.put(key, value);
        }
        return value;
    }
    
    public void put(int key, int value) {
        if (count == capacity && !lruCacheMap.containsKey(key)) {
            // Least recently used is always the first element in LinkedHashMap
            int lru = lruCacheMap.entrySet().iterator().next().getKey();
            lruCacheMap.remove(lru);
            lruCacheMap.put(key,value);
        } else {
            if(!lruCacheMap.containsKey(key))
                count++;
            lruCacheMap.put(key, value);
            lruCacheMap.remove(key);
            lruCacheMap.put(key, value);
        } 
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[ ");
        for (Map.Entry<Integer,Integer> entry : lruCacheMap.entrySet()) {
            buffer.append(String.valueOf(entry.getKey())+ " -> "+String.valueOf(entry.getValue())+" ");
        }
        buffer.append("]");
        return buffer.toString();
    }
}