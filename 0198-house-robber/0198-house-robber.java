class Solution {
    public int rob(int[] nums) {
        int r1 = 0, r2 = 0;

        for (int num: nums) {
            int temp = Math.max(r1 + num, r2);
            r1 = r2;
            r2 = temp;
        }

        return Math.max(r1, r2);
    }
}