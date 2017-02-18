public class BSTSolution {
	public static void main(String[] args) {
		int[] array = {20,10,34,46,39,12,4,2,50,48,1};
		BinarySearchTree bst = new BinarySearchTree();
		bst.addNodes(array);
		//bst.inorderTraversal();
		//boolean isPresent = bst.findNode(30);
		//System.out.println(isPresent);
		//bst.removeNode(1);
		//bst.inorderTraversal();
		bst.removeNode(46);
		bst.inorderTraversal();
	}
}

class BinarySearchTree {
	// Reference to the head of the tree
	private Node head;
	public BinarySearchTree() {
		this.head = null;
	}
	
	/*
	*  Returns true if the data is present in the tree; false otherwise
	*  @param node Current node reference
	*  @param data integer value to lookup in this tree
	*  @return boolean 
	*/
	public boolean lookup(Node node, int data) {
		if (node == null) return false;
		if (node.data == data) {
			return true;
		} else if (data < node.data) {
			return lookup(node.left, data);
		} else {
			return lookup(node.right, data);
		}
	}
		
	/*
	*  Method to insert nodes into binary search tree recursively
	*  @param node current node reference
	*  @param array array of nodes 
	*  @param index current pointer to the array
	*  @param end size of the array
	*  @return nothing
	*/
	private void insert(Node node, int[] array, int index, int end) {
				
		/* Create a head node */
		if (node == null) {
				this.head = new Node(array[0]);
				node = this.head;
		}
		
		/* Base case 1 : No more elements in array to add */
		if (index >= end) return;
		
		/* Decide where to place this node */
		if (array[index] < node.data) {
			if (node.left != null)
				insert(node.left, array, index, end);
			else {
				Node newNode = new Node(array[index]);
				node.left = newNode;
			}
		} else if (array[index] > node.data) {
			if (node.right != null)
				insert(node.right, array, index, end);
			else {
				Node newNode = new Node(array[index]);
				node.right = newNode;
			}
		}
	
		/* Go to the next element in array and start from the root */
		insert(this.head, array, index+1, end);
	}
	
	public void remove(Node node, int data, Node parent){
		if (node.data == data) {
			// Delete the node if it has no children
			if(node.left == null && node.right == null){
				if (parent.left != null && parent.left.data == node.data){
					System.out.println("Removing the leaf node "+node.data+" from left of parent");
					parent.left = null;
				} else{
					System.out.println("Removing the leaf node "+node.data+" from right of parent");
					parent.right = null;
				}
				return;
			} 
			// Only right child
			else if (node.left == null){
				if (parent.left != null && parent.left.data == node.data){
					System.out.println("removing "+node.data+" from the left of the parent");
					parent.left = node.right;
					System.out.println("connecting "+parent.data+" and "+parent.left.data);
				}
				else {
					System.out.println("removing "+node.data+" from the right of the parent");
					parent.right = node.right;
					System.out.println("connecting "+parent.data+" and "+parent.right.data);
				}
				return;
			}
			// Only left child
			else if (node.right == null){
				if (parent.left != null && parent.left.data == node.data){
					System.out.println("removing "+node.data+" from the left of the parent");
					parent.left = node.left;
					System.out.println("connecting "+parent.data+" and "+parent.left.data);
				}
				else {
					System.out.println("removing "+node.data+" from the right of the parent");
					parent.right = node.left;
					System.out.println("connecting "+parent.data+" and "+parent.right.data);
				}
				return;
			}
			// Two children
			// Replace the node to be deleted with the value of minimum node on the right
			node.data = getMinimumNodeValue(node.right);
			System.out.println("Replaced "+data+ " with "+node.data);
			// Remove the minimum node on the right recursively
			remove(node.right, node.data, node);
		} else if (data < node.data) {
			remove(node.left, data, node);
		} else {
			remove(node.right, data, node);
		}
	}
	
	public int getMinimumNodeValue(Node node){
		if (node.left == null) {
			return node.data;
		}
		return getMinimumNodeValue(node.left);

	}
	
	public void addNodes(int[] array) {
		if (array.length > 0) {
			insert(this.head, array, 1, array.length);
		}
	}
	
	public boolean findNode(int data){
		return lookup(this.head, data); 
	}
	
	public void removeNode(int data){
		remove(this.head, data, this.head);
	}
	
	public void inorderTraversal(){
		inorder(this.head);
	}
	
	private void inorder(Node node){
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
}