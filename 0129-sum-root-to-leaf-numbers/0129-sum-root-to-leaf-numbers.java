class Solution {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        calc(root, root.val);
        return result;
    }

    private void calc(TreeNode node, int total) {
        if (node.left == null && node.right == null) {
            result += total;
            return;
        }
        if (node.left != null) {
            calc(node.left, total * 10 + node.left.val);
        }
        if (node.right != null) {
            calc(node.right, total * 10 + node.right.val);
        }
    }
}