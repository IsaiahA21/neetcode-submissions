/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
Begin solving by looking at the subtrees(subproblem) not the full pic.

at each node what the longest path between it and its children.
we do this subproblem and each node, we add the diamter of its left and right

--------------
we store the global max of each node because the answer is not always from the root.

at a parent node that theres a path "flow" if it has left and right children.
so the sum gives up the maxDiamater from that node.

For the grandparent, we dont return the sum, we return the max path of left of right.

pusedocode

globalMax
diameterOfBinaryTree (root):
    
    root.left
    root.right

    globalMax = max(globalMax, leftDia + rightDia)
    return  max(leftDia  rightDia) + 1; // height of the maxSubTree.

*/
class Solution {
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int maxDepth = calculateDiameterReturnDepth(root);

        // the answer we return is maxDia. not the maxDepth
        return maxDia;
    }

    // calcualtes the daiamter and stores in the globalmax but returns the depth at each node
    public int calculateDiameterReturnDepth(TreeNode root){
        if (root == null) return 0;

        int leftDia = calculateDiameterReturnDepth(root.left);
        int rightDia = calculateDiameterReturnDepth(root.right);

        maxDia = Math.max(maxDia, leftDia + rightDia);
        
        return Math.max(leftDia, rightDia) + 1;// return the maxDepth of the subtree
    }
}
