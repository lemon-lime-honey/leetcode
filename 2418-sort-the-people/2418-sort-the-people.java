class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);
        String[] result = new String[names.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            result[heights.length - i - 1] = map.get(heights[i]);
        }

        return result;
    }
}