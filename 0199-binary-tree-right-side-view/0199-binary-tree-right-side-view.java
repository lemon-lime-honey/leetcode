class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> que = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
                if (node.left != null) {
                    que.add(node.left);
                }
            }
        }

        return result;
    }
}