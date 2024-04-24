class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        int[] result = new int[]{1, root.val};
        int level = 0;

        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            int temp = 0;
            level++;

            for (int i = 0; i < n; i++) {
                TreeNode now = que.poll();
                temp += now.val;
                if (now.left != null) que.add(now.left);
                if (now.right != null) que.add(now.right);
            }

            if (result[1] < temp) {
                result[1] = temp;
                result[0] = level;
            }
        }

        return result[0];
    }
}