import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);

            if (!magMap.containsKey(c)) magMap.put(c, 1);
            else magMap.put(c, magMap.get(c) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);

            if (!magMap.containsKey(c) || magMap.get(c) == 0) return false;
            else magMap.put(c, magMap.get(c) - 1);
        }

        return true;
    }
}