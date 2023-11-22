class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void backtrack(List<Integer> numbers, int[] nums, Set<Integer> used) {
        if (numbers.size() == nums.length) {
            result.add(new ArrayList<>(numbers));
            return;
        }
        for (int num: nums) {
            if (used.contains(num)) {
                continue;
            }
            numbers.add(num);
            used.add(num);
            backtrack(numbers, nums, used);
            used.remove(num);
            numbers.remove(numbers.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>(), nums, new HashSet<Integer>());
        return result;
    }
}