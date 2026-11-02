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
BFS -> go level by lvl, check if the node children are valid, if no exit

DFS -> at each node we check if its children are valid, if no return false, if yes go left child
then right child
* We need to keep track of the min or max for each size cuz we are not just comparing the node to
its children we are comparing it to its ancestors. root=[0,-1000,1000,null,null,0]
       0
      / \
  -1000  1000
        /
       0

- on the right side, we keep track of the smallest so far cuz child needs to be bigger than that.

- on the left side, we keep track of the largest so far, because the child needs to be smaller than
that
*/
class Solution {
    // DFS
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        
        if ( !(root.val > min && root.val < max)){ // check against the valid condition and then inverse
            return false;
        }

        return dfs(root.left, min, root.val)
            && dfs(root.right, root.val, max);
    }
}