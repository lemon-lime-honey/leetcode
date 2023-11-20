class Solution {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> que = new ArrayDeque<>();
        Set<Character> letters = new HashSet<>();
        int result = 0;
        int idx = 0;

        while (idx < s.length()) {
            if (letters.contains(s.charAt(idx))) {
                while (que.peekFirst() != s.charAt(idx)) {
                    letters.remove(que.pollFirst());
                }
                que.pollFirst();
                que.add(s.charAt(idx));
                idx++;
            } else {
                que.add(s.charAt(idx));
                letters.add(s.charAt(idx));
                idx++;
            }
            result = Math.max(result, que.size());
        }
        return result;
    }
}