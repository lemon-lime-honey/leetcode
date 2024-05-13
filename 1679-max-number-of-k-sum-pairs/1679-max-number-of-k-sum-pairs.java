class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int result = 0;

        while (lo < hi) {
            int chk = nums[lo] + nums[hi];
            if (chk < k) lo++;
            else if (chk > k) hi--;
            else {
                result++;
                lo++;
                hi--;
            }
        }

        return result;
    }
}