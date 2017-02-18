import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BSTTesting {

	public static void main(String[] args) {
		// First element is root
		Integer[] dataArray = new Integer[]{25,19,37,12,22,29,4,23,30};
		BST bst = new BST();
		bst.addNodes(dataArray);
		bst.inorderTraversal();
		bst.levelorderTraversal();
		int size = bst.sizeOfLargestSubtree(24,29);
		System.out.println("size = "+size);
	}

}

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
	}
}

class BST{
	Node head;
	private static Queue<Node> queue = new ArrayDeque<Node>();
	private static boolean flag = false;
	private static int counter = 0;
	private static List<Integer> subtreeSizes = new ArrayList<Integer>();
	
	BST(){
		this.head = null;
	}
	public void insert(Node node, Integer[] dataArray,int i,int end){
		if(this.head == null){
			this.head = new Node(dataArray[0]);
			node = this.head;
		}
		System.out.println("data = "+node.data);

		if(i<end){
			if(dataArray[i] < node.data){
				if(node.left == null){
					node.left = new Node(dataArray[i]);
					// start from the root after you insert the data
					insert(this.head, dataArray, i+1, end);
				}else{
					insert(node.left, dataArray, i, end);
				}
			}
			else if(dataArray[i] > node.data){
				if(node.right == null){
					node.right = new Node(dataArray[i]);
					// start from the root after you insert the data
					insert(this.head, dataArray, i+1, end);
				}else{
					insert(node.right, dataArray, i, end);
				}
			}
		}
	}
	
	public void addNodes(Integer[] dataArray){
		insert(null,dataArray,1,dataArray.length);
	}
	
	public void inorderTraversal(){
		System.out.println("inorder");
		inorder(this.head);
	}
	
	public void levelorderTraversal(){
		System.out.println("levelorder");
		levelorder(this.head);
	}
	
	private void levelorder(Node root){
		if(root!=null){
			System.out.print(root.data + " ");
			if(root.left!=null){
				queue.add(root.left);
			}
			if(root.right!=null){
				queue.add(root.right);
			}
			if(!queue.isEmpty())
				levelorder(queue.remove());
		}
	}
	
	private void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	public int sizeOfLargestSubtree(int min, int max){
		int size = 0;
		traverseTree(this.head,min,max);
		if(subtreeSizes.size()==0){
			return counter;
		}
		size = Collections.max(subtreeSizes);
		return size;
	}
	
	private void traverseTree(Node root, int A, int B){
		// Node is within the given range (traverse both left and right, but start with left randomly)
		if(root.data>A && root.data<B){
			counter++;
			if(root.left!=null)
				traverseTree(root.left,A,B);
			if(root.right!=null)
				traverseTree(root.right,A,B);	
		}
		// Node is below the range or equal to minimum value (traverse only right)
		else if(root.data<=A){
			if(root.right!=null){
				traverseTree(root.right,A,B);
			}else{
				flag = false;
				subtreeSizes.add(counter);
				counter = 0;
			}
		}
		// Node is out of range or equal to maximum value (traverse only left)
		else if(root.data>=B){
			if(root.left!=null){
				traverseTree(root.left,A,B);
			}else{
				flag = false;
				subtreeSizes.add(counter);
				counter = 0;
			}
		}
	}
}