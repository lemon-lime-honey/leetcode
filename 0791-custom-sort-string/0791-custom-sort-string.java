class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> letters = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < order.length(); i++) {
            letters.put(order.charAt(i), 0);
        }

        for (int i = 0; i < s.length(); i++) {
            if (letters.containsKey(s.charAt(i))) {
                letters.put(s.charAt(i), letters.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < order.length(); i++) {
            for (int j = 0; j < letters.get(order.charAt(i)); j++) {
                result.append(order.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!letters.containsKey(s.charAt(i))) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}