class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> record = new HashSet<>();
    Set<Integer> num = new HashSet<>();

    private void backtrack(int[] nums, List<Integer> route) {
        if (route.size() == nums.length && !record.contains(route)) {
            List<Integer> temp = new ArrayList<Integer>(route);
            record.add(temp);
            result.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (num.contains(i)) {
                continue;
            }
            route.add(nums[i]);
            num.add(i);
            backtrack(nums, route);
            num.remove(i);
            route.remove(route.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>());
        return result;
    }
}