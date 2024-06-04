class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] result = new int[n * m];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(mat[i][j]);
            }
        }

        List<Integer> sortedKeys = new ArrayList(map.keySet());
        Collections.sort(sortedKeys);
        int idx = 0;

        for (int key: sortedKeys) {
            if (key % 2 == 1) {
                for (int i = 0; i < map.get(key).size(); i++) {
                    result[idx] = map.get(key).get(i);
                    idx++;
                }
            } else {
                for (int i = map.get(key).size() - 1; i >= 0; i--) {
                    result[idx] = map.get(key).get(i);
                    idx++;
                }
            }
        }

        return result;
    }
}