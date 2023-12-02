class Solution {
    private int result = Integer.MAX_VALUE;
    private TreeNode before = null;

    private void calculate(TreeNode node) {
        if (node == null) {
            return;
        }
        calculate(node.left);
        if (before != null) {
            result = Math.min(result, node.val - before.val);
        }
        before = node;
        calculate(node.right);
    }

    public int getMinimumDifference(TreeNode root) {
        calculate(root);
        return result;
    }
}