class Solution {
    private List<List<Integer>> result;
    private boolean[] visited;
    private Set<Integer> route;
    private int n;
    private int k;

    private void combination(int index) {
        if (route.size() == k) {
            result.add(List.copyOf(route));
            return;
        }

        for (int i = index; i < n + 1; i++) {
            if (!visited[i]) {
                route.add(i);
                visited[i] = true;
                combination(i + 1);
                route.remove(i);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        visited = new boolean[n + 1];
        route = new HashSet<>();
        this.n = n;
        this.k = k;

        combination(1);

        return result;
    }
}