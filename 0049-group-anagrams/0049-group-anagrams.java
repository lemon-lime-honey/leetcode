class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word: strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);

            if (!map.containsKey(sorted)) {
                List<String> temp = new ArrayList<>();
                temp.add(word);
                map.put(sorted, temp);
            } else {
                map.get(sorted).add(word);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> value: map.values()) {
            result.add(value);
        }

        return result;
    }
}