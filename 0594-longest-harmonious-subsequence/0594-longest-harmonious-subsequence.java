class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numDict = new HashMap<>();
        int result = 0;

        for (int num: nums) {
            numDict.put(num, numDict.getOrDefault(num, 0) + 1);
        }

        for (int num: nums) {
            if (numDict.containsKey(num + 1)) {
                result = Math.max(result, numDict.get(num) + numDict.get(num + 1));
            }
        }

        return result;
    }
}