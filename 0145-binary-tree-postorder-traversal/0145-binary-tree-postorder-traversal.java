class Solution {
    List<Integer> result;

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        traverse(node.right);
        result.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        traverse(root);
        return result;
    }
}