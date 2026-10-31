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

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node, int maxSoFar){
        if (node == null ) return 0;

        // a node is good if it is >= every acenstor
        int isGood =  (node.val >= maxSoFar) ? 1 : 0;

        // Update the maximum value along this path
        maxSoFar = Math.max(maxSoFar, node.val);
        
        return dfs(node.left,maxSoFar) + dfs(node.right,maxSoFar) + isGood;
    }
}
