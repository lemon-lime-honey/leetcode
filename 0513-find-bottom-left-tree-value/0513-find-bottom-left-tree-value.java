class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    result = que.peek().val;
                }
                if (que.peek().left != null) {
                    que.offer(que.peek().left);
                }
                if (que.peek().right != null) {
                    que.offer(que.peek().right);
                }
                que.poll();
            }
        }

        return result;
    }
}