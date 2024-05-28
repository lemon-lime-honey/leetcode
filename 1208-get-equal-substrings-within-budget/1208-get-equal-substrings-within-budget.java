class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int lo = 0, hi = 0;
        int result = 0, cost = 0;

        while (hi < s.length()) {
            if (Math.abs(s.charAt(hi) - t.charAt(hi)) + cost <= maxCost) {
                cost += Math.abs(s.charAt(hi) - t.charAt(hi));
                result = Math.max(result, hi - lo + 1);
                hi++;
            } else {
                cost -= Math.abs(s.charAt(lo) - t.charAt(lo));
                lo++;
            }
        }

        return result;
    }
}