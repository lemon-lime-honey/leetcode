class Solution {
    public Node connect(Node root) {
        if (root == null || root.right == null) {
            return root;
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(root.right);
        que.add(root.left);

        while (!que.isEmpty()) {
            int n = que.size();
            Node before = null;

            for (int i = 0; i < n; i++) {
                Node now = que.poll();
                if (i != 0) {
                    now.next = before;
                }
                if (now.right != null) {
                    que.add(now.right);
                    que.add(now.left);
                }
                before = now;
            }
        }

        return root;
    }
}