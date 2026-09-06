# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# [5,3,8]. is inorder

# if (root >= p and root <= q) or (root >= q and root <= p), then root is the lca
# if p > root and q > root, move root to the right
# if p < root and q < root, move root to the left
class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        # base case. nodes =2, therefore smallest val is the lca
        while root:
            if (root.val >= p.val and root.val <= q.val) or (root.val >= q.val and root.val <= p.val):
                return root
        
            if p.val >= root.val  and q.val >= root.val:
                root = root.right
            else: #  p < root and q < root, move root to the left
                root = root.left

        return TreeNode()