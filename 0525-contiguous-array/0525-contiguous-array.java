class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        int total = 0, result = 0;
        prefix.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                total--;
            } else {
                total++;
            }
            if (!prefix.containsKey(total)) {
                prefix.put(total, i);
            } else {
                result = Math.max(result, i - prefix.get(total));
            }
        }

        return result;
    }
}