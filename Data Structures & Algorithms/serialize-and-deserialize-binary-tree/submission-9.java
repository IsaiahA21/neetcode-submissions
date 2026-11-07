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

// BFS -> using level order to serialize and deserialize

public class Codec {
    // Encodes a tree to a single string.

    // BFS level by level not preoder (thats for DFS)
    //  when we see null, put "N"
    public String serialize(TreeNode root) {
        if (root == null)
            return "N";

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        StringBuilder res = new StringBuilder();
        res.append(root.val).append(",");

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            // Left child
            if (node.left != null) {
                res.append(node.left.val).append(",");
                queue.addLast(node.left);
            } else {
                res.append("N,");
            }

            // Right child
            if (node.right != null) {
                res.append(node.right.val).append(",");
                queue.addLast(node.right);
            } else {
                res.append("N,");
            }
        }

        System.out.println(res.toString());
        return res.toString();
    }

    // Decodes your encoded data to tree.
    // deserialize BFS aswell.
    // BFS level by level not preoder (thats for DFS)
    public TreeNode deserialize(String data) {
        // split into array
        String[] arr = data.split(",");
        int idx = 0;

        if (arr[idx].equals("N")) {
            return null;
        };

        Deque<TreeNode> queue = new ArrayDeque<>();

        // Create root from first value and push it into a queue.
        Integer val = Integer.parseInt(arr[idx]);
        TreeNode root = new TreeNode(val);
        queue.addLast(root);
        idx++;

        // use the index to read values
        // pop node from queue
        while (!queue.isEmpty() && idx < arr.length) {
            TreeNode node = queue.removeFirst();

            // add Left node
            if (!arr[idx].equals("N")) {
                val = Integer.parseInt(arr[idx]);
                node.left = new TreeNode(val);
                queue.addLast(node.left);
            } else {
                node.left = null;
            }

            idx++;
            // add right
            if (!arr[idx].equals("N")) {
                val = Integer.parseInt(arr[idx]);
                node.right = new TreeNode(val);
                queue.addLast(node.right);
            } else {
                node.right = null;
            }

            idx++;
        }

        return root;
    }
}
