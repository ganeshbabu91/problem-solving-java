/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        boolean result = traverse(root, sum);     
        System.out.println(result);
        return result;
    }
    
    public boolean traverse(TreeNode node, int sum) {
        // Base conditions
        if (node == null && sum == 0){
            return true;
        } else if (node == null && sum != 0){
            return false;
        }
        
        // Detect current node's value from sum
        sum -= node.val;
                
        // Left children
        if (node.left != null) {
            // Path found! No need to look at the right side
            if (traverse(node.left, sum)) {
                return true;
            }
            // No matching path on the left and nothing to search in the right side
            if (node.right == null){
                return false;
            }
        } 
        
        // Right children (No matching path on left, look for the right branch)
        if (node.right != null) {
            return traverse(node.right, sum);
        }
        
        // Leaf node
        return traverse(null, sum);        
    }
}