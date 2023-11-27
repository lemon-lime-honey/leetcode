class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!indices.containsKey(nums[i])) {
                List<Integer> temp = new ArrayList<>();
                indices.put(nums[i], temp);
            }
            indices.get(nums[i]).add(i);
        }

        for (List<Integer> numbers: indices.values()) {
            for (int i = 1; i < numbers.size(); i++) {
                if (Math.abs(numbers.get(i - 1) - numbers.get(i)) <= k) {
                    return true;
                }
            }
        }

        return false;
    }
}