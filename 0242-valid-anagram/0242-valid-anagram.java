import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> counter = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (!counter.containsKey(s.charAt(i))) {
                counter.put(s.charAt(i), 1);
            } else {
                counter.put(s.charAt(i), counter.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!counter.containsKey(t.charAt(i)) ||
                counter.get(t.charAt(i)) == 0) return false;
            counter.put(t.charAt(i), counter.get(t.charAt(i)) - 1);
        }

        return true;
    }
}