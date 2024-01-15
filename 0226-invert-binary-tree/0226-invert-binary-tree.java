class Solution {
    private void invert(TreeNode original, TreeNode result) {
        if (original.left != null) {
            result.right = new TreeNode(original.left.val);
            invert(original.left, result.right);
        }
        if (original.right != null) {
            result.left = new TreeNode(original.right.val);
            invert(original.right, result.left);
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode result = new TreeNode(root.val);
        invert(root, result);
        return result;
    }
}