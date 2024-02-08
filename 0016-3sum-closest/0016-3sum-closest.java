class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n - 1;

            while (lo < hi) {
                int chk = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(chk - target) < Math.abs(result - target)) {
                    result = chk;
                }
                if (chk > target) {
                    hi--;
                } else if (chk < target) {
                    lo++;
                } else {
                    return target;
                }
            }
        }

        return result;
    }
}