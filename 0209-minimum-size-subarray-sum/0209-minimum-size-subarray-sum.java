class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int lo = 0, add = 0, result = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            add += nums[i];
            while (add >= target) {
                result = Math.min(result, i - lo + 1);
                add -= nums[lo];
                lo++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            return 0;
        }

        return result;
    }
}