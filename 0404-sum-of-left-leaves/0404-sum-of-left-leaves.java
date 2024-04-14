class Solution {
    private int result;

    private void calc(TreeNode node, boolean left) {
        if (node.left == null && node.right == null && left) {
            result += node.val;
        }
        if (node.left != null) {
            calc(node.left, true);
        }
        if (node.right != null) {
            calc(node.right, false);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        result = 0;
        calc(root, false);
        return result;
    }
}