class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        boolean direction = true;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);

        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = que.poll();
                temp.add(node.val);

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }

            if (direction) {
                result.add(temp);
                direction = false;
            } else {
                Collections.reverse(temp);
                result.add(temp);
                direction = true;
            }
        }

        return result;
    }
}