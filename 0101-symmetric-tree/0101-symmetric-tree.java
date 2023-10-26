class Solution {
    public boolean chk(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return (
            left.val == right.val &&
            chk(left.left, right.right) &&
            chk(left.right, right.left)
        );
    }

    public boolean isSymmetric(TreeNode root) {
        return chk(root.left, root.right);
    }
}