class Solution {
    List<Integer> result;

    public List<Integer> preorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        traverse(root);
        return result;
    }

    private void traverse(TreeNode node) {
        result.add(node.val);
        if (node.left != null) {
            traverse(node.left);
        }
        if (node.right != null) {
            traverse(node.right);
        }
    }
}