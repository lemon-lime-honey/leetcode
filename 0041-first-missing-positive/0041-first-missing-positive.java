class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (0 < nums[i] && nums[i] < n + 1) {
                continue;
            }
            nums[i] = n + 1;
        }

        for (int i = 0; i < n; i++) {
            int target = Math.abs(nums[i]);
            if (target > n) {
                continue;
            }
            target--;

            if (nums[target] > 0) {
                nums[target] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}