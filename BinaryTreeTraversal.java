import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		Integer[] dataArray = new Integer[] {13,2,10,20,1,null,-25,null,null,null,null,null,null,3,4};
		Tree binaryTree = new Tree().addNodes(dataArray, Traversal.LEVELORDER);
		System.out.println("inorder");
		inorder(binaryTree.head);
		System.out.println("preorder");
		preorder(binaryTree.head);
		System.out.println("postorder");
		postorder(binaryTree.head);
		System.out.println("levelorder");
		levelorder(binaryTree.head);
	}

	private static void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	private static void preorder(Node root) {
		if(root!=null){
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	
	
	private static void postorder(Node root) {
		if(root!=null){
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	private static void iterativePreorder(Node root){
	  ArrayDeque<Node> queue = new ArrayDeque<Node>();
	  queue.push(root);
	  while(!queue.isEmpty()){
		  Node node = queue.pop();
		  System.out.println(node.data);
		  if(node.right!=null){
			  queue.push(node.right);
		  }
		  if(node.left!=null){
			  queue.push(node.left);
		  }
	  }
	}
	
	private static Queue<Node> queue = new ArrayDeque<Node>();
	private static void levelorder(Node root){
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

}


class Tree{
	public Node head;
	public Tree(){
		this.head = null;
	}
	
	public void levelOrderInsert(Node root, Integer[] dataArray, int i, int end){
		if(root == null){
			this.head = new Node(dataArray[i]);
			root = this.head;
		}
		int left = 2*i + 1;
		int right = 2*i + 2;
		if(left < end){
			if(dataArray[left]==null)
				root.left = null;
			else
				root.left = new Node(dataArray[left]);
		}
		if(right < end){
			if(dataArray[right]==null)
				root.right = null;
			else
				root.right = new Node(dataArray[right]);
		}
		if(root.left!=null){
			levelOrderInsert(root.left, dataArray, left, end);
		}
		if(root.right!=null){
			levelOrderInsert(root.right, dataArray, right, end);
		}
	}
	
	public Tree addNodes(Integer[] dataArray, Traversal levelorder) {
		if(levelorder == Traversal.LEVELORDER){
			levelOrderInsert(null,dataArray,0,dataArray.length);
		}
		return this;
	}
	/*private static Tree addNodesByLevelOrder(Integer[] dataArray) {
		Tree tree = new Tree();
		Node root = new Node(dataArray[0]);
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		for(int i=1;i<dataArray.length;i+=2){
			Node currentNode = queue.remove();
			System.out.print(currentNode.data);
			if(dataArray[i]!=null){
				currentNode.left = new Node(dataArray[i]);
				System.out.print(" | "+currentNode.left.data);
				queue.add(currentNode.left);
			}
			if(dataArray[i+1]!=null){
				currentNode.right = new Node(dataArray[i+1]);
				System.out.print(" | "+currentNode.right.data);
				queue.add(currentNode.right);
			}	
			tree.insert(currentNode);
			//System.out.println(currentNode.data+" | "+currentNode.left.data+" | "+currentNode.right.data+" | ");
		}
		return null;
	}*/
}

enum Traversal{
	INORDER,
	POSTORDER,
	PREORDER,
	LEVELORDER
}
