class Solution {
    public int mySqrt(int x) {
        int lo = 1, hi = x;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long)mid * mid;
            if (square == x) {
                return mid;
            }
            if (square < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo - 1;
    }
}