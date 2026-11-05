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
 We can optimize using a HashMpa and recursion
 instead of creating the smaller arrays, we keep track of the boundaries using indices

 **/

class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    int preorder_idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // store each ele index of the inorder array
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length-1);
    }
    public TreeNode build(int[] preorder, int left, int right) {
        if (left > right){
            return null;
        }

        //get root from preoder array
        int root_val = preorder[preorder_idx++];// post incremeent - use the value then increment it
        TreeNode root = new TreeNode(root_val);
        int root_inorder_idx = inorderMap.get(root_val);

        root.left = build(preorder, left, root_inorder_idx-1);
        root.right = build(preorder,root_inorder_idx+1, right);


        return root;
    }
}
