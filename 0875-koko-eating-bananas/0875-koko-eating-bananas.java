class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int lo = 1, hi = piles[n - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;

            for (int pile: piles) {
                cnt += pile / mid;
                if (pile % mid != 0) {
                    cnt++;
                }
            }

            if (cnt > h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}