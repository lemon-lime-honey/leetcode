class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();
        Node clone = new Node(node.val);
        nodeMap.put(clone.val, clone);
        que.add(node);

        while (!que.isEmpty()) {
            Node now = que.poll();

            for (Node nb: now.neighbors) {
                if (!nodeMap.containsKey(nb.val)) {
                    Node newNode = new Node(nb.val);
                    nodeMap.put(newNode.val, newNode);
                    List<Node> temp = nodeMap.get(now.val).neighbors;
                    temp.add(newNode);
                    que.add(nb);
                } else {
                    Node target = nodeMap.get(nb.val);
                    List<Node> temp = nodeMap.get(now.val).neighbors;
                    temp.add(target);
                }
            }
        }

        return nodeMap.get(node.val);
    }
}