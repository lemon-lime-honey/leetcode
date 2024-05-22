class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        for (int num: arr) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        for (int num: cnt.values()) {
            if (seen.contains(num)) return false;
            seen.add(num);
        }

        return true;
    }
}