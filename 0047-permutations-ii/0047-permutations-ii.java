class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void backtrack(int[] nums, List<Integer> route, boolean[] used) {
        if (route.size() == nums.length) {
            result.add(new ArrayList<Integer>(route));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            route.add(nums[i]);
            used[i] = true;
            backtrack(nums, route, used);
            used[i] = false;
            route.remove(route.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }
}