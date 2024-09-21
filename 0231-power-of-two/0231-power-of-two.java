class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (n > 1) return false;
                return true;
            }
            n >>= 1;
        }

        return false;
    }
}