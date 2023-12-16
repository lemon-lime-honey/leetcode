class Solution {
    private Map<Character, List<Character>> map = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));

        find(new StringBuilder(), -1, digits);

        return result;
    }

    public void find(StringBuilder sb, int idx, String digits) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = idx + 1; i < digits.length(); i++) {
            for (char ch: map.get(digits.charAt(i))) {
                sb.append(ch);
                find(sb, i, digits);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}