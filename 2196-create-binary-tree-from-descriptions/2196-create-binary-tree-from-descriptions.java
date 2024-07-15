class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeDict = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        for (int i = 0; i < descriptions.length; i++) {
            if (!nodeDict.containsKey(descriptions[i][0])) {
                nodeDict.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
            }
            if (!nodeDict.containsKey(descriptions[i][1])) {
                nodeDict.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
            }
            if (descriptions[i][2] == 1) {
                nodeDict.get(descriptions[i][0]).left = nodeDict.get(descriptions[i][1]);
            } else {
                nodeDict.get(descriptions[i][0]).right = nodeDict.get(descriptions[i][1]);
            }
            if (!parent.containsKey(descriptions[i][0])) {
                parent.put(descriptions[i][0], -1);
            }
            parent.put(descriptions[i][1], descriptions[i][0]);
        }

        for (Map.Entry<Integer, Integer> map: parent.entrySet()) {
            int key = map.getKey();
            if (parent.get(key) == -1) {
                return nodeDict.get(key);
            }
        }

        return null;
    }
}