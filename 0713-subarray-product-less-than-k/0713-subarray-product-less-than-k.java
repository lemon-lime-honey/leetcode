class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int result = 0, calc = 1, lo = 0;

        for (int hi = 0; hi < nums.length; hi++) {
            calc *= nums[hi];

            while (calc >= k) {
                calc /= nums[lo];
                lo++;
            }

            result += hi - lo + 1;
        }

        return result;
    }
}