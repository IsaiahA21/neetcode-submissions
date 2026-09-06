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
        curr = root
        while curr:
            if p.val > curr.val  and q.val > curr.val:
                curr = curr.right
            elif p.val < curr.val  and q.val < curr.val: #  p < curr and q < curr, move curr to the left
                curr = curr.left
            else:
                return curr
