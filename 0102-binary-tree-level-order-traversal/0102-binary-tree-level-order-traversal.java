class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> que = new ArrayDeque<>();

        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int n = que.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                temp.add(node.val);

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }

            result.add(temp);
        }

        return result;
    }
}