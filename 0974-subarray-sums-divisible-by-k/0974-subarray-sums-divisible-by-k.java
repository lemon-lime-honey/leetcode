class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] sums = new int[k + 1];
        int total = 0, result = 0;
        sums[0] = 1;

        for (int num: nums) {
            total += num;
            total %= k;
            if (total < 0) total += k;
            if (sums[total] != 0) result += sums[total];
            sums[total]++;
        }

        return result;
    }
}