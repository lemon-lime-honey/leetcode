class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<List<Integer>> vals = new Stack<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode now = que.poll();
                temp.add(now.val);

                if (now.left != null) {
                    que.add(now.left);
                }
                if (now.right != null) {
                    que.add(now.right);
                }
            }

            vals.push(temp);
        }

        while (!vals.isEmpty()) {
            result.add(vals.pop());
        }

        return result;
    }
}