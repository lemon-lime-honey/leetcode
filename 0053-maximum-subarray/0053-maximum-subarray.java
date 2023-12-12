class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int now = nums[0];

        for (int i = 1; i < nums.length; i++) {
            now = Math.max(nums[i], now + nums[i]);
            result = Math.max(result, now);
        }

        return result;
    }
}