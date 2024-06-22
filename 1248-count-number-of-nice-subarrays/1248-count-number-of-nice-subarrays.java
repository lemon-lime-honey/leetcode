class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int lo = 0, hi = 0, cnt = 0, result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) cnt++;
            while (cnt > k) {
                if (nums[lo] % 2 == 1) cnt--;
                lo++;
                hi = lo;
            }
            if (cnt == k) {
                while (nums[hi] % 2 == 0) hi++;
                result += hi - lo + 1;
            }
        }

        return result;
    }
}