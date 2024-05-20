class Solution {
    private int solve(int n, int value, int[] nums) {
        if (n == nums.length) return value;
        return solve(n + 1, value ^ nums[n], nums) + solve(n + 1, value, nums);
    }

    public int subsetXORSum(int[] nums) {
        return solve(0, 0, nums);
    }
}