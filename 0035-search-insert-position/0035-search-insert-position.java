class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;

        if (nums[n - 1] < target) return n;

        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid;
            } else {
                return mid;
            }
        }

        return lo;
    }
}