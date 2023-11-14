class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int chk = numbers[lo] + numbers[hi];
            if (chk == target) {
                break;
            } else if (chk < target) {
                lo++;
            } else {
                hi--;
            }
        }

        int[] result = {lo + 1, hi + 1};
        return result;
    }
}