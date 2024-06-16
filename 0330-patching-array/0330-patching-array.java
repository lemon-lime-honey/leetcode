class Solution {
    public int minPatches(int[] nums, int n) {
        long num = 1;
        int idx = 0, result = 0;

        while (num <= n) {
            if (idx < nums.length && nums[idx] <= num) {
                num += nums[idx++];
            } else {
                num += num;
                result++;
            }
        }

        return result;
    }
}