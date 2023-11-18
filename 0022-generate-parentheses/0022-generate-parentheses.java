class Solution {
    private void generate(List<String> result, String route, int lo, int hi, int n) {
        if (route.length() == 2 * n) {
            result.add(route);
            return;
        }
        if (lo < n) {
            generate(result, route + "(", lo + 1, hi, n);
        }
        if (hi < lo) {
            generate(result, route + ")", lo, hi + 1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
}