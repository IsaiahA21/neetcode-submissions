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
to get lvl order traversal, at each only add that node 
*/

/**
BFS is easiest: at each lvl add only those nodes to queue
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.addLast(root); // addLast allows you to include null

        while(!queue.isEmpty()){
            int size = queue.size(); // only process the nodes in the queue before the for loop started
            List<Integer> lvl = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode node = queue.removeFirst();
                lvl.add(node.val);

                // add the node children to the queue (they are the next lvl)
                if(node.left != null ){
                    queue.add(node.left);
                }
                if(node.right != null ){
                    queue.add(node.right);
                }
            }

            res.add(lvl); // append to solution  
        }

        return res;

    }
}
