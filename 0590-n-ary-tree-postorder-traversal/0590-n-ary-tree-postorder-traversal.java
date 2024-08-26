class Solution {
    private void traverse(Node node, List<Integer> result) {
        if (node == null) return;
        for (Node child: node.children) {
            traverse(child, result);
        }
        result.add(node.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
}