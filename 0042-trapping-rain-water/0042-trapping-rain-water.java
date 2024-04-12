class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int lo = 0, hi = height.length - 1;
        int maxL = height[lo], maxR = height[hi];
        int result  = 0;

        while (lo < hi) {
            if (maxL < maxR) {
                lo++;
                maxL = Math.max(maxL, height[lo]);
                result += Math.max(0, maxL - height[lo]);
            } else {
                hi--;
                maxR = Math.max(maxR, height[hi]);
                result += Math.max(0, maxR - height[hi]);
            }
        }

        return result;
    }
}