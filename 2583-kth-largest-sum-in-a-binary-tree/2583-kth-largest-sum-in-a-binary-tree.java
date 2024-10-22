class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> result = new PriorityQueue<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();
            long levelSum = 0L;

            for (int i = 0; i < n; i++) {
                TreeNode node = que.peek();
                levelSum += node.val;
                que.poll();

                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }

            result.offer(levelSum);

            if (result.size() > k) {
                result.poll();
            }
        }

        if (result.size() < k) return -1;

        return result.peek();
    }
}