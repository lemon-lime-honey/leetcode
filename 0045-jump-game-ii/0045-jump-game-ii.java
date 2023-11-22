class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int reach = 0;
        int last = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (i == last) {
                last = reach;
                result++;
            }
        }

        return result;
    }
}