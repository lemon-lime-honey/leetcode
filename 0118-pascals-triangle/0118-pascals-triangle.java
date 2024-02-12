class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            if (!result.isEmpty()) {
                for (int j = 0; j < i - 1; j++) {
                    int target = (result.get(result.size() - 1).get(j) +
                                  result.get(result.size() - 1).get(j + 1));
                    temp.add(target);
                }
                temp.add(1);
            }

            result.add(temp);
        }

        return result;
    }
}