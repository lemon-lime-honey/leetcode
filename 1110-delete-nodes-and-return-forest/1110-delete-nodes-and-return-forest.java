class Solution {
    private List<TreeNode> result;
    private Set<Integer> targets;

    private TreeNode solve(TreeNode node, boolean is_root) {
        if (node == null) return null;
        if (is_root && !targets.contains(node.val)) result.add(node);
        node.left = solve(node.left, targets.contains(node.val));
        node.right = solve(node.right, targets.contains(node.val));
        return targets.contains(node.val) ? null : node;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        result = new ArrayList<>();
        targets = new HashSet<>();

        for (int target: to_delete) {
            targets.add(target);
        }

        solve(root, true);
        return result;
    }
}