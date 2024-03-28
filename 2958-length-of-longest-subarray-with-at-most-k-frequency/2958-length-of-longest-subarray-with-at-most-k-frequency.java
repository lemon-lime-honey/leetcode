class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int lo = 0, result = 0;

        for (int hi = 0; hi < nums.length; hi++) {
            cnt.put(nums[hi], cnt.getOrDefault(nums[hi], 0) + 1);

            while (cnt.get(nums[hi]) > k && lo < hi) {
                cnt.put(nums[lo], cnt.get(nums[lo]) - 1);
                lo++;
            }

            result = Math.max(result, hi - lo + 1);
        }

        return result;
    }
}