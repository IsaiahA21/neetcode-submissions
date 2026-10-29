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
A node is visible from the right side if its the right most node
Or
Its the first node visib;e whem the is no far right node on that lvl.

I think its LVL Order traversal and at each level determine the right most node
- Go right to left.
- once we get the node on that level, we need to move to the next level
 -- we do this by popping the exact amount we know we added in
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            // process nodes at that level
            res.add(queue.peekFirst().val);

            // add children to the queue: right first
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();

                if (node.right != null) {
                    queue.addLast(node.right);
                }

                if (node.left != null) {
                    queue.addLast(node.left);
                }

            }


        }

        return res;
    }
}
