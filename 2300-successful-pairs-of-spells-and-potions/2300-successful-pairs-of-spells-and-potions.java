class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        int m = spells.length;
        int[] result = new int[m];
        Arrays.sort(potions);

        for (int i = 0; i < m ; i++) {
            int lo = 0, hi = n - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                long chk = (long)potions[mid] * spells[i] - success;
                if (chk >= 0) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }

            result[i] = n - lo;
        }

        return result;
    }
}