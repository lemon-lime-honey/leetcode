class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int idx = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }

        root.right = buildTree(
            Arrays.copyOfRange(inorder, idx + 1, inorder.length),
            Arrays.copyOfRange(postorder, idx, postorder.length - 1)
        );
        root.left = buildTree(
            Arrays.copyOfRange(inorder, 0, idx),
            Arrays.copyOfRange(postorder, 0, idx)
        );

        return root;
    }
}