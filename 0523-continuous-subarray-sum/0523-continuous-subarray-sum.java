class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            total %= k;

            if (total == 0 && i > 0) return true;
            if (map.containsKey(total) && i - map.get(total) > 1) return true;
            if (!map.containsKey(total)) map.put(total, i);
        }

        return false;
    }
}