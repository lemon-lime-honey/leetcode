class Solution {
    public int minimumLength(String s) {
        int lo = 0, hi = s.length() - 1;

        while (lo < hi && s.charAt(lo) == s.charAt(hi)) {
            char target = s.charAt(lo);
            while (lo <= hi && s.charAt(lo) == target) {
                lo++;
            }
            while (lo <= hi && s.charAt(hi) == target) {
                hi--;
            }
        }

        return hi - lo + 1;
    }
}