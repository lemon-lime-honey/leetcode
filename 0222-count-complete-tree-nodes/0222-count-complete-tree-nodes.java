class Solution {
    private int result = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return result;
        }
        result++;
        cnt(root);
        return result;
    }

    private void cnt(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            result++;
            cnt(node.left);
        }

        if (node.right != null) {
            result++;
            cnt(node.right);
        }
    }
}