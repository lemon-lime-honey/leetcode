class Solution {
    private void insert(TreeNode node, int val, int depth, int level) {
        if (level == depth - 1) {
            TreeNode left = null, right = null;
            if (node.left != null && node.right == null) {
                left = new TreeNode(val, node.left, null);
                right = new TreeNode(val);
            } else if (node.right != null && node.left == null) {
                left = new TreeNode(val);
                right = new TreeNode(val, null, node.right);
            } else if (node.right == null && node.left == null) {
                left = new TreeNode(val);
                right = new TreeNode(val);
            } else {
                left = new TreeNode(val, node.left, null);
                right = new TreeNode(val, null, node.right);
            }
            node.left = left;
            node.right = right;
            return;
        }

        if (node.left != null) {
            insert(node.left, val, depth, level + 1);
        }
        if (node.right != null) {
            insert(node.right, val, depth, level + 1);
        }
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val, root, null);
            return node;
        }

        insert(root, val, depth, 1);
        return root;
    }
}