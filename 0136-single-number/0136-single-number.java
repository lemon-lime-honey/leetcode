class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            if (numSet.contains(num)) {
                numSet.remove(num);
            } else {
                numSet.add(num);
            }
        }

        for (int num: numSet) {
            return num;
        }

        return 0;
    }
}