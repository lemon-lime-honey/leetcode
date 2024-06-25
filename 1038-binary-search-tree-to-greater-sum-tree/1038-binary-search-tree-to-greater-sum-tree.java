class Solution {
    private int val = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        root.val += this.val;
        this.val = root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}