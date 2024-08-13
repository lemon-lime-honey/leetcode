class Solution {
    private List<List<Integer>> result;

    private void backtrack(int idx, int total, List<Integer> route, int[] candidates, int target) {
        if (total >= target) {
            if (total == target) {
                result.add(new ArrayList<>(route));
            }
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            route.add(candidates[i]);
            total += candidates[i];
            backtrack(i + 1, total, route, candidates, target);
            total -= candidates[i];
            route.remove(route.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, 0, new ArrayList<>(), candidates, target);
        return result;
    }
}