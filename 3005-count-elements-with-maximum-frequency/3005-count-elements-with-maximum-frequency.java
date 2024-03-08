class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int max = 0;

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int value: map.values()) {
            max = Math.max(max, value);
        }

        for (int value: map.values()) {
            if (value == max) {
                result += value;
            }
        }

        return result;
    }
}