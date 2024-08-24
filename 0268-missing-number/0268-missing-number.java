class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;

        for (int i = 1; i < nums.length + 1; i++) {
            result ^= i;
        }

        for (int num: nums) {
            result ^= num;
        }

        return result;
    }
}