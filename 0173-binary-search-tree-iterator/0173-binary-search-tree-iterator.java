class BSTIterator {
    List<Integer> vals;
    int idx;

    public BSTIterator(TreeNode root) {
        vals = new ArrayList<>();
        idx = -1;
        iterate(root);
    }

    private void iterate(TreeNode node) {
        if (node.left != null) {
            iterate(node.left);
        }
        vals.add(node.val);
        if (node.right != null) {
            iterate(node.right);
        }
    }
    
    public int next() {
        idx++;
        return vals.get(idx);
    }
    
    public boolean hasNext() {
        if (idx < vals.size() - 1) {
            return true;
        }
        return false;
    }
}
