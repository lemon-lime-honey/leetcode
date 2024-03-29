class Solution {
    public long countSubarrays(int[] nums, int k) {
        int cnt = 0, lo = 0, maxNum = 0;
        long result = 0;

        for (int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        for (int hi = 0; hi < nums.length; hi++) {
            if (nums[hi] == maxNum) {
                cnt++;
            }

            while (cnt >= k) {
                result += (long)nums.length - hi;
                if (nums[lo] == maxNum) {
                    cnt--;
                }
                lo++;
            }
        }

        return result;
    }
}