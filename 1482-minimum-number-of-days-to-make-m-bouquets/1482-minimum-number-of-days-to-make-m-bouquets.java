class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * k > bloomDay.length) return -1;
        int lo = 1, hi = (int)1e9;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int flower = 0, bouquet = 0;
            for (int day: bloomDay) {
                if (mid < day) flower = 0;
                else flower++;
                if (k <= flower) {
                    flower = 0;
                    bouquet++;
                    if (bouquet == m) break;
                }
            }
            if (bouquet == m) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}