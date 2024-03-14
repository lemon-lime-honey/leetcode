class Solution {
    private int getNumber(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int lo = 0, hi = 0, cnt = 0, total = 0;

        while (hi < nums.length) {
            total += nums[hi];
            while (lo <= hi && total > goal) {
                total -= nums[lo];
                lo++;
            }
            cnt += hi - lo + 1;
            hi++;
        }

        return cnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return getNumber(nums, goal) - getNumber(nums, goal - 1);
    }
}