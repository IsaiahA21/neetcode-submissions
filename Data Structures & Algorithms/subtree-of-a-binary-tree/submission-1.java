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
 A tree if a subtree of tree, if it consist of all the exact same node and values at each node.

loop over root, until we see subTree.val then we start comparing.
we it stops being the same, we return to the same spot we started and keep looking.
    if exactly the same return true

    if diff, we keep looping over tree till last node then return false;
 */

class Solution {  

    // this method will search for the starting node 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null){
            return false;
        }

        // see if have a subtree at this root node
        if (root.val == subRoot.val && isSameTree(root, subRoot)){
            return true;
        }
        else {
            // else try another node
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        
    }

    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null){
            return true;
        }

        if (root == null || subRoot == null){
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
