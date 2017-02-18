import java.util.Scanner;
import java.util.ArrayDeque;

// TODO 1: Remove, removeDuplicates, merge two lists, merge (start,end) nodes into a single node by summing, intersection, swap(e1,e2)
// TODO 2: Make it generic. ie., LinkedList<String>, LinkedList<Integer>, etc.. 
// TODO 3: Custom exception handling  

public class LinkedListOperations{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Create new list : 10 --> 20 --> 5 --> 8 --> 50 --> null
        int[] listElements = {10, 20, 5, 8, 50};
        LinkedList linkedList = new LinkedList(listElements);
        System.out.println(linkedList);
        // Reverse the list : 50 --> 8 --> 5 --> 20 --> 10 --> null
        linkedList.reverse();
        System.out.println("After Reversing : \n"+linkedList);
        // Add three new elements : 50 --> 8 --> 5 --> 20 --> 10 --> 34 --> 42 --> 100 --> null
        linkedList.add(34);
        linkedList.add(42);
        linkedList.add(100);
        System.out.println("After adding 34,42 and 100 : \n"+linkedList);
        // Insert 18 after second element
        linkedList.insertAfter(18,2);
        // Insert 86 after the last element (add leaf)
        linkedList.insertAfter(86,linkedList.length());
        // 50 --> 8 --> 18 --> 5 --> 20 --> 10 --> 34 --> 42 --> 100 --> 86 --> null
        System.out.println("After inserting 18,2 and 86,len : \n"+linkedList);
        // Insert 22 before third element
        linkedList.insertBefore(22,3);
        // Insert 23 before first element (add head)
        linkedList.insertBefore(23,1);
         // Insert 23 before first element (add head)
        linkedList.insertBefore(55,linkedList.length());
        // 50 --> 8 --> 18 --> 5 --> 20 --> 10 --> 34 --> 42 --> 100 --> 86 --> null
        System.out.println("After inserting 22 before 3rd and 23 before head and 55 before leaf : \n"+linkedList);
        // Clone the entire list (deep copy)
        LinkedList listCopy = linkedList.clone();
        System.out.println("Orginal list : \n"+linkedList);
        System.out.println("Copy of original list : \n"+listCopy);
        // Adding new element to the listCopy
        listCopy.add(87);
        linkedList.insertBefore(77,1);
        System.out.println("Orginal list : \n"+linkedList);
        System.out.println("Copy of original list : \n"+listCopy);
        // Reverse the list without affecting the original list
        LinkedList reversedList = linkedList.reverseCopy();
        System.out.println("Orginal list : \n"+linkedList);
        System.out.println("Reversed list : \n"+reversedList);
        // Check if the list2 is the reverse of list1 (yes)
        boolean isReversed = isReversed(linkedList, reversedList);
        System.out.println("is reversed = "+isReversed);
        // Modify the original list by adding 34
        linkedList.add(34);
        // Check if the list2 is the reverse of list1 (no)
        isReversed = isReversed(linkedList, reversedList);
        System.out.println("is reversed = "+isReversed);
        
    }

    public static boolean isReversed(LinkedList list1, LinkedList list2){
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        Node list1_current = list1.head;
        while (list1_current!=null ){
            stack.push(list1_current.getData());
            list1_current = list1_current.getNext();
        }
        Node list2_current = list2.head;
        while (list2_current!=null ){
            if (stack.isEmpty() || stack.pop() != list2_current.getData()){
                return false;
            }
            list2_current = list2_current.getNext();
        }
        return true;
    }
}

class LinkedList implements Cloneable{
    public Node head;
    private int length = 0;

    LinkedList(int[] elements){
        System.out.println("creating a linked list");
        head = new Node(elements[0]);
        Node current = head;
        length = 1;
        for (int i=1; i<elements.length; i++) {
            Node node = new Node(elements[i]);
            current.setNext(node);
            current = current.getNext();
            length++;
        }
    }

    public void add(int data){
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.getNext()!=null) {
            current = current.getNext();
        }
        Node newNode = new Node(data);
        current.setNext(newNode);
        length++;
    }

    public void insertAfter(int data, int position){
        if (position<=0 || position>length) return;
        System.out.println("Adding "+data+" after position "+position);
        Node current = head;
        Node newNode = new Node(data);
        for (int i=1; i<position; i++) {
            current = current.getNext();
        }
        Node temp = current.getNext();
        current.setNext(newNode);
        newNode.setNext(temp);
        length++;
    }

    public void insertBefore(int data, int position){
        if (position<=0 || position>length) return;
        System.out.println("Adding "+data+" before position "+position);
        Node newNode = new Node(data);
        // Insert before head node
        if (position == 1) {
            newNode.setNext(head);
            head = newNode;
            length++;
            return;    
        }
        Node current = head;
        for (int i=1; i<position-1; i++) {
            current = current.getNext();
        }
        Node temp = current.getNext();
        current.setNext(newNode);
        newNode.setNext(temp);
        length++;
    }

    public void reverse(){
        // Take backup of the head's next node
        Node current = null;
        if (head!=null) {
            current = head.getNext();
        }
        // Mark the head node as leaf
        head.setNext(null);
        // Two reference variables previous and temp pointing the leaf node intially
        Node previous = head, temp = head;
        // temp : holds the current node whose next pointer is not reversed yet
        // previous : points to the latest node whose next pointer got reversed
        while (current!=null) {
            // Take a backup of current node before moving to the next node
            temp = current;
            current = current.getNext();
            // Reverse the current node's next pointer
            temp.setNext(previous);
            // Make the previous points to the current node (temp is the current node now!!)
            previous = temp;
        }
        // Mark the leaf node as head
        head = temp;
        // Free the temp and previous reference variables as we don't need them any longer
        temp = null;
        previous = null;
    }

    public LinkedList reverseCopy(){
        LinkedList linkedListCopy = this.clone();
        linkedListCopy.reverse();
        return linkedListCopy;
    }

    public int length(){
        return length;
    }

    @Override
    public LinkedList clone(){
        System.out.println("cloning the list");
        try {
            LinkedList linkedListCopy = (LinkedList) super.clone();
            Node headCopy = head.clone();
            linkedListCopy.head = headCopy;
            Node current = head;
            Node currentCopy = linkedListCopy.head;
            while (current.getNext()!=null) {
                currentCopy.setNext(current.getNext().clone());
                current = current.getNext();
                currentCopy = currentCopy.getNext();

            }
            return linkedListCopy;
        } catch (CloneNotSupportedException cloningException) {
            throw new AssertionError(cloningException);
        }
    }
    
    @Override
    public String toString(){
        StringBuffer outputBuffer = new StringBuffer();
        Node current = head;
        while (current!=null) {
            int data = current.getData();
            outputBuffer.append(String.valueOf(data)+" --> ");
            current = current.getNext();
        }
        outputBuffer.append("null");
        return outputBuffer.toString();
    }

}

class Node implements Cloneable{
    private int data;
    private Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return next;
    }
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
    @Override
    public Node clone(){
        System.out.println("cloning node "+data);
        try {
            Node nodeCopy = (Node) super.clone();
            return nodeCopy;
        } catch (CloneNotSupportedException cloningException) {
            throw new AssertionError(cloningException);
        }
    }
}

