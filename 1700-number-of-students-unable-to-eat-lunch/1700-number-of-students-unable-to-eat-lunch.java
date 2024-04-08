class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] nums = {0, 0};
        int idx = 0;

        for (int student: students) {
            nums[student]++;
        }

        while (idx < sandwiches.length) {
            if (nums[sandwiches[idx]] > 0) {
                nums[sandwiches[idx]]--;
            } else {
                break;
            }
            idx++;
        }

        return sandwiches.length - idx;
    }
}