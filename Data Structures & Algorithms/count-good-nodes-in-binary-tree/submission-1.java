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
if the tree root node is not null we always have a answer of 1.

I think at each node we need to pass the path to the tree root
* I think the root will be the first in the list, then the ancestors then its part is last
* we compare the values to the node val and if it bigger then restun 1 else 0


*
*/
class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;

        List<TreeNode> ancestors = new ArrayList<>();
        return countGoodNodes(root, ancestors);
    }

    public int countGoodNodes(TreeNode node, List<TreeNode> ancestors) {
        if (node == null)
            return 0;
        int isGood = 1; // 1 means true

        if (!ancestors.isEmpty()) {
            for (TreeNode ant : ancestors) {
                if (node.val < ant.val) {
                    isGood = 0; // 0 is false
                    break;
                }
            }
        }
        //Add the current node to ancestors.
        ancestors.add(node);


        // System.out.println("node val is " + node.val + " isGood val is " + isGood +".  ancestors tree includes: " + ancestors.size());

        // Recursively process its left and right children.
        int count = countGoodNodes(node.left,ancestors) + countGoodNodes(node.right,ancestors) + isGood;

        // backtrack and remove this node from ancestors before returning to parent
        ancestors.remove(ancestors.size()-1);

        return count;
    }
}
