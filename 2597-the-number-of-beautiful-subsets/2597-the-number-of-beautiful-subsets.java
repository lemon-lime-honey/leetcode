class Solution {
    private int result;

    private void backtrack(int idx, List<Integer> sub, int[] nums, int k) {
        if (idx == nums.length) {
            if (!sub.isEmpty()) result++;
            return;
        }

        if (!sub.contains(nums[idx] - k)) {
            sub.add(nums[idx]);
            backtrack(idx + 1, sub, nums, k);
            sub.remove(sub.size() - 1);
        }

        backtrack(idx + 1, sub, nums, k);
    }

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        result = 0;
        backtrack(0, new ArrayList<>(), nums, k);
        return result;
    }
}