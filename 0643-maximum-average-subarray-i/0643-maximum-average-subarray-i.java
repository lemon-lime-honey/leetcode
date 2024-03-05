class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int lo = 0, hi = k - 1;
        long total = 0;

        for (int i = 0; i < k; i++) {
            total += nums[i];
        }

        long result = total;

        while (hi < nums.length - 1) {
            lo++;
            hi++;
            total += nums[hi] - nums[lo - 1];
            result = Math.max(result, total);
        }

        return result / 1.0 / k;
    }
}