class Solution {
    List<List<Integer>> result;
    int k;
    int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        result = new ArrayList<>();
        combine(1, new ArrayList<>());
        return result;
    }

    private void combine(int idx, List<Integer> route) {
        if (route.size() == k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += route.get(i);
            }
            if (sum == n) {
                result.add(new ArrayList<>(route));
                return;
            }
            return;
        }

        for (int i = idx; i < 10; i++) {
            route.add(i);
            combine(i + 1, route);
            route.remove(route.size() - 1);
        }
    }
}