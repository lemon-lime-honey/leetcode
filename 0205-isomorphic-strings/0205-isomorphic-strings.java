import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        int ref = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!sMap.containsKey(s.charAt(i)) && !tMap.containsKey(t.charAt(i))) {
                sMap.put(s.charAt(i), ref);
                tMap.put(t.charAt(i), ref);
                ref++;
            } else if (!sMap.containsKey(s.charAt(i)) || !tMap.containsKey(t.charAt(i))) {
                return false;
            } else {
                if (sMap.get(s.charAt(i)) != tMap.get(t.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}