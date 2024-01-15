class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> que = new ArrayDeque<>();
        que.add(root);

        while(!que.isEmpty()) {
            int n = que.size();
            Node before = null;

            for (int i = 0; i < n; i++) {
                Node now = que.poll();
                if (before != null) {
                    now.next = before;
                }
                before = now;
                if (now.right != null) {
                    que.add(now.right);
                }
                if (now.left != null) {
                    que.add(now.left);
                }
            }
        }

        return root;
    }
}