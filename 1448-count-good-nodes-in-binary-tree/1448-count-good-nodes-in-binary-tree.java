class Solution {
    private int result;

    public int goodNodes(TreeNode root) {
        result = 0;
        search(root, root.val);
        return result;
    }

    private void search(TreeNode node, int largest) {
        if (largest <= node.val) {
            result++;
            largest = node.val;
        }
        if (node.left != null) {
            search(node.left, largest);
        }
        if (node.right != null) {
            search(node.right, largest);
        }
    }
}