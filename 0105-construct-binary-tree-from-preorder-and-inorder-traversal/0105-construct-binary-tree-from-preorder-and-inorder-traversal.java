class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        int idx = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                idx = i;
                break;
            }
        }

        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, idx + 1),
            Arrays.copyOfRange(inorder, 0, idx)
        );
        root.right = buildTree(
            Arrays.copyOfRange(preorder, idx + 1, preorder.length),
            Arrays.copyOfRange(inorder, idx + 1, inorder.length)
        );

        return root;
    }
}