class Solution {
    public boolean judgeSquareSum(int c) {
        long lo = 0, hi = Math.round(Math.sqrt(c));

        while (lo <= hi) {
            long chk = lo * lo + hi * hi;
            if (chk == c) return true;
            if (chk < c) lo++;
            else hi--;
        }

        return false;
    }
}