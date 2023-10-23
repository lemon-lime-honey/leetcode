class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n < 3)
            return n;

        int k = 1;
        int i = 1;
        int before = nums[0];
        int cnt = 1;

        while (i < n) {
            if (nums[i] == before) {
                cnt++;
                if (cnt == 3) {
                    while (i < n && nums[i] == before) {
                        i++;
                    }

                    if (i == n)
                        break;

                    before = nums[i];
                    nums[k] = nums[i];
                    cnt = 1;
                    k++;
                    i++;
                } else {
                    nums[k] = nums[i];
                    k++;
                    i++;
                }
            } else {
                nums[k] = nums[i];
                before = nums[i];
                cnt = 1;
                i++;
                k++;
            }
        }

        return k;
    }
}