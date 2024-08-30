class Solution {
    private int chk(TreeNode node) {
        if (node == null) return 0;
        int leftLevel = chk(node.left), rightLevel = chk(node.right);
        if (leftLevel < 0 || rightLevel < 0 || Math.abs(leftLevel - rightLevel) > 1) {
            return -1;
        }
        return Math.max(leftLevel, rightLevel) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return chk(root) > -1;
    }
}