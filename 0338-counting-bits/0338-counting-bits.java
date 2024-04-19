class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int num = i;
            while (num != 0) {
                result[i] += num & 1;
                num = num >> 1;
            }
        }

        return result;
    }
}