class Solution {
    private List<List<Integer>> result;

    private void get(int idx, List<Integer> sub, int[] nums) {
        result.add(new ArrayList<>(sub));
        for (int i = idx; i < nums.length; i++) {
            sub.add(nums[i]);
            get(i + 1, sub, nums);
            sub.remove(sub.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        get(0, new ArrayList<>(), nums);
        return result;
    }
}