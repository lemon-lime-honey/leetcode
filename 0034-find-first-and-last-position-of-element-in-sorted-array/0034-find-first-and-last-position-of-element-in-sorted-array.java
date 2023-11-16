class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;

                while (start > 0 && nums[start - 1] == target) {
                    start--;
                }

                while (end < nums.length - 1 && nums[end + 1] == target) {
                    end++;
                }

                return new int[] {start, end};
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return new int[] {-1, -1};
    }
}