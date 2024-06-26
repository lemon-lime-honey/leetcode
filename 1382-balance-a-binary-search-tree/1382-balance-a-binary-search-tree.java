class Solution {
    private List<TreeNode> arr = new ArrayList<>();

    private void traverse(TreeNode node) {
        if (node == null) return;
        traverse(node.left);
        arr.add(node);
        traverse(node.right);
    }

    private TreeNode run(int lo, int hi) {
        if (hi < lo) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode node = arr.get(mid);
        node.left = run(lo, mid - 1);
        node.right = run(mid + 1, hi);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        traverse(root);
        return run(0, arr.size() - 1);
    }
}