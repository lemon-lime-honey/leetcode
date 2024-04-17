class Solution {
    private String result;

    private void get(TreeNode node, StringBuilder route) {
        route.insert(0, (char)('a' + node.val));
        if (node.left == null && node.right == null) {
            String target = route.toString();
            if (result == null || target.compareTo(result) < 0) {
                result = target;
            }
        }
        if (node.left != null) {
            get(node.left, route);
        }
        if (node.right != null) {
            get(node.right, route);
        }
        route.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        result = null;
        get(root, new StringBuilder());
        return result;
    }
}