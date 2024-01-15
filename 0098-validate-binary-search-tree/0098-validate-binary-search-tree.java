class Solution {
    private boolean chk(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (min >= node.val || max <= node.val) {
            return false;
        }

        return (chk(node.left, min, node.val) && chk(node.right, node.val, max));
    }

    public boolean isValidBST(TreeNode root) {
        return chk(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}