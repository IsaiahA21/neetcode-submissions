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

// on test case 6, learnt max can be negative
/**
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      1

 hint: What's the maximum path sum that uses node 11 and can extend into both of its children? No
 If you include 7 → 11 → 2, can you also include node 4 without breaking the definition of a path? No

 at each node we return to the parent the max. cause that will help with the max adjecent we can get.
 So are Node 11. Math.max(7,2) + 11
**/
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // System.out.println("At node " + root.val);

        // int local_max = (root.val < 0) ? 0 : root.val; // this is the issue. cause I make this 0. hence the 50. 
        // what I want to do is  say that this node will never cause the max and i stop and see if one of its children can
        
         // if we go down the children and they are negative, it doesnt help to maximize the answer
        int left_max = Math.max(0, dfs(root.left));
        int right_max = Math.max(0, dfs(root.right));

        int res =  root.val + left_max + right_max;  
        // System.out.println("At node " + root.val + ", Local max is " + res);

        // we do two things are each node. 1. we see if this node gives us the best adjecent (val + left + right)
        // 2. we return the max adjecent mback up the stack. the parent can only use 1.

        // 1. 
        max = Math.max(res, max);

        return Math.max(left_max, right_max) + root.val;
    }
}
