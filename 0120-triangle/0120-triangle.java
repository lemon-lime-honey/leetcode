class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<int[]> dp = new ArrayList<>();
        int result = Integer.MAX_VALUE;

        for (List<Integer> line: triangle) {
            int[] temp = new int[line.size()];
            if (dp.size() == 0) {
                temp[0] = line.get(0);
                dp.add(temp);
                continue;
            }
            for (int i = 0; i < line.size(); i++) {
                temp[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < dp.size(); i++) {
                temp[i] = Math.min(temp[i], dp.get(dp.size() - 1)[i] + line.get(i));
                temp[i + 1] = Math.min(temp[i + 1], dp.get(dp.size() - 1)[i] + line.get(i + 1));
            }
            dp.add(temp);
        }

        for (int num: dp.get(triangle.size() - 1)) {
            result = Math.min(result, num);
        }

        return result;
    }
}