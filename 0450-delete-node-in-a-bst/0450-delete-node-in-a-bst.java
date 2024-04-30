class Solution {
    private int before(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    private int next(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right != null) {
                root.val = next(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = before(root);
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }
}