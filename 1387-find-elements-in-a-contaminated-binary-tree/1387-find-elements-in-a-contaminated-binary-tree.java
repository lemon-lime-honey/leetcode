class FindElements {
    TreeNode root;

    private void assign(TreeNode node, int value) {
        node.val = value;
        if (node.left != null) assign(node.left, value * 2 + 1);
        if (node.right != null) assign(node.right, value * 2 + 2);
    }

    private boolean run(TreeNode node, int value) {
        if (node.val == value) return true;
        if (node.left != null && node.right != null) return run(node.left, value) || run(node.right, value);
        else if (node.left != null) return run(node.left, value);
        else if (node.right != null) return run(node.right, value);
        return false;
    }

    public FindElements(TreeNode root) {
        this.root = root;
        assign(this.root, 0);
    }
    
    public boolean find(int target) {
        return run(this.root, target);
    }
}
