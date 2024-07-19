class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> min = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int target = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                target = Math.min(target, matrix[i][j]);
            }
            min.add(target);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int target = 0;
            for (int j = 0; j < matrix.length; j++) {
                target = Math.max(target, matrix[j][i]);
            }
            if (min.contains(target)) result.add(target);
        }

        return result;
    }
}