class Solution {
    private boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        calc(root, root.val, targetSum);
        return result;
    }

    private void calc(TreeNode node, int total, int targetSum) {
        if (node.left == null && node.right == null) {
            if (total == targetSum) {
                result = true;
                return;
            }
        }
        if (node.left != null) {
            calc(node.left, total + node.left.val, targetSum);
        }
        if (node.right != null) {
            calc(node.right, total + node.right.val, targetSum);
        }
    }
}