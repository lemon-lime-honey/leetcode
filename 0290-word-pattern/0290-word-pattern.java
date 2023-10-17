class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) return false;

        HashMap<Character, String> dict1 = new HashMap<>();
        HashMap<String, Character> dict2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!dict1.containsKey(pattern.charAt(i)) &&
                !dict2.containsKey(words[i])) {
                dict1.put(pattern.charAt(i), words[i]);
                dict2.put(words[i], pattern.charAt(i));
            } else if (!dict1.containsKey(pattern.charAt(i)) ||
                       !dict2.containsKey(words[i])) {
                return false;
            } else if (!dict1.get(pattern.charAt(i)).equals(words[i]) ||
                       !dict2.get(words[i]).equals(pattern.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}