class Solution {
    public int pivotInteger(int n) {
        int[] forward = new int[n + 1];
        int[] backward = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            forward[i] = forward[i - 1] + i;
        }

        backward[n] = n;

        for (int i = n - 1; i > 0; i--) {
            backward[i] = backward[i + 1] + i;
        }

        for (int i = 1; i < n + 1; i++) {
            if (forward[i] == backward[i]) {
                return i;
            }
        }

        return -1;
    }
}