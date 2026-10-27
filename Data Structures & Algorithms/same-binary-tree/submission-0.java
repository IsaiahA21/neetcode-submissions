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

// we check each node and its value.
// if diff then return false
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {


        if (p == null && q == null) {
            return true;
        }
        else if (p == null || q == null){
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean isLeftSame = isSameTree(p.left, q.left);
        if (!isLeftSame) {
            return false;
        }
        boolean isRightSame = isSameTree(p.right, q.right);
        if (!isRightSame) {
            return false;
        }
        
        return true;
    }
}
