class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        Arrays.sort(nums);
        int result = -1;

        for (int num: nums) {
            int sqrt = (int) Math.sqrt(num);

            if (sqrt * sqrt == num && numMap.containsKey(sqrt)) {
                numMap.put(num, numMap.get(sqrt) + 1);
                result = Math.max(result, numMap.get(num));
            } else {
                numMap.put(num, 1);
            }
        }

        return result;
    }
}