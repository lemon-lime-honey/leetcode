import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            magMap.put(magazine.charAt(i),
                magMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magMap.containsKey(ransomNote.charAt(i)) 
                || magMap.get(ransomNote.charAt(i)) == 0) return false;
            magMap.put(ransomNote.charAt(i),
                magMap.get(ransomNote.charAt(i)) - 1);
        }

        return true;
    }
}