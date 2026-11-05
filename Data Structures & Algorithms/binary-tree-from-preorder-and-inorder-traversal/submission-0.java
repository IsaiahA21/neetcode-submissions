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

preorder = [1,2,3,4], inorder = [2,1,3,4]



Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
    3
   / \
  9   20
     /  \
    15   7


preorder -> Root, left, right: 3(root) → 9 → 20 → 15 → 7
inOrder -> left, Root, right: 9 → 3(root) → 15 → 20 → 7
    If we were only given inorder we know the left-to-right ordering, but wouldnt don't know which
node is the root.


// preOrder tells us the first element is the root
// inOrder tells us that everything before the root is in the left subtree and everything after root
is in the right subtree. therefore we know theres 1 node in left and the rest are in right. /
Inorder never tells us which element is the root by itself - We use preorder to identify the root,
then use inorder to determine what's left and right of it.

*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0){
            return null;
        }

        // preOrder tell us the root
        TreeNode root = new TreeNode(preorder[0]);

        // Find the root position in inorder
        int root_index_inorder = 0;
        while (preorder[0] != inorder[root_index_inorder]){
            root_index_inorder++;
        }


        // Build left subtree
        int[] leftPreorder = Arrays.copyOfRange(preorder,1,root_index_inorder+1); // in preorder, the left subtree is after the root(which is the first ele)
        int[] leftInorder = Arrays.copyOfRange(inorder,0,root_index_inorder);

        root.left = buildTree(leftPreorder, leftInorder);

        // build right subtree
        int[] rightPreorder = Arrays.copyOfRange(preorder,root_index_inorder+1,preorder.length); // in preorder, the right subtree starts 2 right from the root(which is the first ele)
        int[] rightInorder = Arrays.copyOfRange(inorder,root_index_inorder+1,inorder.length);

        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

}
