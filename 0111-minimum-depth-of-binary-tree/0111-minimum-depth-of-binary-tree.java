class Solution {
    private int result;

    private void find(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            result = Math.min(result, level);
            return;
        }

        if (node.left != null) {
            find(node.left, level + 1);
        }
        if (node.right != null) {
            find(node.right, level + 1);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        result = Integer.MAX_VALUE;
        find(root, 1);
        return result;
    }
}