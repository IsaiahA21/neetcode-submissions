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
# Serialize and Deserialize Binary Tree

Im trying to solve it please dont show the answer. Im stuck and dont knwo where to go.

I know im going to do DFS. my intial thought is I need a way to stroe the order of the node and its
left or tight child. So i went with inorder. and im way thinking of using "L" and "R" next to the
string to node if its place from parent. and N for null.

but I think part of the this thinking is wrong the part on my "L" and "R". in DFS, what I need to
think about is the subproblem - what am I asking the child to do, what can the child return back and
what should I do with the value. I think the child should return a string maybe up of its children
or N.

Input: root = [1,2,3,null,null,4,5]

Output: [1,2,3,null,null,4,5]

so in this example. at node 2, it would return "N,2,N"
N,2,N,1,N,4,N,3,N,5,N

---------------------
but how do we restucurut it? I have to reconsider inorder because how do I know the root node?
remember Construct Binary Tree From Preorder And Inorder Traversal - we used preorder to know root.

1,2,N,N,3,4,N,N,5,N,N

When doing preorder DFS, if we encounter a null, what does that tell us about the subtree you're
currently processing?
-- A null marker tells us that that theres is no subtree further - this is the end. so to the parent
it tells us that the left or right(depending where N is) has no nodes. if its the left that is N,
then we move to the right, and if its the right that is N, we move return back. so when we see
"2,N,N" , we return the subtree as 2

*
*/
public class Codec {
    // Encodes a tree to a single string.

    // Serialize using preorder: Root -> Left -> Right.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);

        return sb.toString();
    }

    public void dfsSerialize(TreeNode root, StringBuilder sb) {
        if (root == null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);

        // I know string appending in Java is O(n^2)
        // String res = root.val + "," + left + "," + right;
        // System.out.println(res);

        // return res;
        return;


    }

    int idx = 0;
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0; // reset so calling desearlize again in the same insatnce doesnt cause problems
        return dfs(data);
    }
    public TreeNode dfs(String data) {
        // skips commas
        while (idx < data.length() && data.charAt(idx) == ',') {
            idx++;
        }

        // No more values to process.
        if (idx >= data.length()) {
            return null;
        }

        // Null value
        if (data.charAt(idx) == 'N') {
            idx++;
            return null;
        }

        int val = getValue(data);

        TreeNode root = new TreeNode(val);
        root.left = dfs(data);
        root.right = dfs(data);
        return root;
    }

    public int getValue(String data) {
        // Read the current node's value.
        int start = idx;

        while (idx < data.length() && data.charAt(idx) != ',') {
            idx++;
        }
        return Integer.parseInt(data.substring(start, idx));
    }
}
