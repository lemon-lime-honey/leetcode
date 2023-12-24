class Solution {
    public boolean isUgly(int n) {
        int[] factors = {2, 3, 5};
        for (int factor: factors) {
            while (n >= factor && n % factor == 0) {
                n /= factor;
            }
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}