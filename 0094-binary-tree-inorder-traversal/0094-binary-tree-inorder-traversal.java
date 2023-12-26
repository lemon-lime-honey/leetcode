class Solution {
    private List<Integer> result = new ArrayList<>();

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        result.add(node.val);
        traverse(node.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
}