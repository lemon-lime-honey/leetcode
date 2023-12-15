class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[lo] && nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[lo] && nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] > nums[lo]) {
                hi = mid;
            } else {
                return nums[mid];
            }
        }

        return nums[lo];
    }
}