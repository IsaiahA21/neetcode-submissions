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
At each parent node, we look at if its unbalanced (height diffrs more 1)
* what the height of the left, whats the height of right.

The sub tree where its not balanced means that the overall thing is not balanced
root = [1,2,3,null,null,4,null,5]
at node 3, left height =2, right height =0
therefore overall not balancedd. 
so we return -1. because we want to propagate the failure up
if (res(the height) == -1) return -1.
then return false 
*/

class Solution {

    public boolean isBalanced(TreeNode root) {
        if (height(root) == -1){
            return false;
        }

        return true;

    }

    /**
    if root is null return 0

    lh= height()
    rh = height()

    if either return == -1, return -1;

    if same or diff by 1 return maxHeight
    if diff by >1, return -1

    */

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        
        int lh = height(root.left);
        if (lh == -1) return -1;

        int rh = height(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh-rh) > 1){
            return -1;
        }

        return Math.max(lh, rh) + 1;
        
    }
}
