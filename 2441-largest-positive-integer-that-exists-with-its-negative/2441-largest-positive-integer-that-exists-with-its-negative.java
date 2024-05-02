class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            if (nums[lo] == -1 * nums[hi]) {
                return nums[hi];
            }
            if (nums[lo] < -1 * nums[hi]) {
                lo++;
            } else {
                hi--;
            }
        }

        return -1;
    }
}