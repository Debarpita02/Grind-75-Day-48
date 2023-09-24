class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        // If the current node is either p or q, return it as a potential ancestor.
        if (root == p || root == q) {
            return root;
        }
        
        // Recursively search for p and q in the left and right subtrees.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both p and q are found in different subtrees, root is the LCA.
        if (left != null && right != null) {
            return root;
        }
        
        // If either p or q (or both) are found in one subtree, return that subtree's result.
        return left != null ? left : right;
    }
}
