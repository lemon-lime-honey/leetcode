class Solution {
    private List<String> result;

    private void dfs(TreeNode node, String route) {
        if (node.left == null && node.right == null) {
            result.add(route);
            return;
        }
        if (node.left != null) {
            dfs(node.left, route + "->" + node.left.val);
        }
        if (node.right != null) {
            dfs(node.right, route + "->" + node.right.val);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, Integer.toString(root.val));
        return result;
    }
}