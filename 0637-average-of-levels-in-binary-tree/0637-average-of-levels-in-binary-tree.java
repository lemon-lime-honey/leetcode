class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();

        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            double total = 0.0;

            for (int i = 0; i < n; i++) {
                TreeNode now = que.poll();
                total += now.val;
                if (now.left != null) {
                    que.add(now.left);
                }
                if (now.right != null) {
                    que.add(now.right);
                }
            }

            result.add(total / n);
        }

        return result;
    }
}