class Solution {
    public int pivotInteger(int n) {
        if (n == 1) return 1;

        int[] prefix = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + i;
        }

        for (int i = n - 1; i > 0; i--) {
            if (prefix[n] - prefix[i - 1] == prefix[i]) {
                return i;
            }
        }

        return -1;
    }
}